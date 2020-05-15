package pruebaRuleta.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pruebaRuleta.model.Apuesta;
import pruebaRuleta.model.Ruleta;
import pruebaRuleta.repo.ApuestaRepo;
import pruebaRuleta.repo.RuletaRepo;


@RestController
@RequestMapping("/apuesta")
public class ApuestaResController {

	@Autowired
	private ApuestaRepo repoApuesta;
	
	@Autowired
	private RuletaRepo repoRuleta;

	
	@PostMapping(path = "/realizarApuesta")
	public String placeBet(@RequestBody Apuesta apuesta) {
		
		if(apuesta.getIdApuesta()>=0 && apuesta.getNumeroApuesta()<=36) {
			if(apuesta.getColor().equals("negro")||apuesta.getColor().equals("rojo")) {
				if(apuesta.getValorApuesta()<=10000) {
					repoApuesta.save(apuesta);
					return "Apuesta valida";
				}
				return "La apuesta no cumple con el valor";
			}
			return "El color no es el adecuado para la apuesta";
		}
		
		return "El numero no es valido";	
	}
	
	
	@PutMapping(path = "/resultado/{idRuleta}")
	public double resultado(@RequestBody Ruleta ruleta, @PathVariable("idRuleta") Integer idRuleta) {
		
		int resultado=0;
		if(ruleta.getIdRuleta() == idRuleta) {
			if(ruleta.getEstado().equals("abierto")){
			ruleta.setEstado("cerrado");
			repoRuleta.save(ruleta);
			resultado= (int) repoApuesta.resultadoApuesta(idRuleta);
			}
			else if(ruleta.getEstado().equals("cerrado")) {
				return resultado;
			}
		}	
		return resultado;
	}
}
	
	