package pruebaRuleta.rest;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pruebaRuleta.model.Ruleta;
import pruebaRuleta.repo.RuletaRepo;

@RestController
@RequestMapping("/ruleta")
public class RuletaResController {

	@Autowired
	private RuletaRepo repoRuleta;
	
	
	@PostMapping(path = "/agregarRuleta")
	public int agregarRuleta(@RequestBody Ruleta ruleta) {
		repoRuleta.save(ruleta);
		return ruleta.getIdRuleta();
	}
	
	@PutMapping(path = "/cambia/{idRuleta}")
	public String cambiarEstado(@RequestBody Ruleta ruleta, @PathVariable("idRuleta") Integer idRuleta) {

		if(ruleta.getIdRuleta() == idRuleta) {
			if(ruleta.getEstado().equals("cerrado")){
			ruleta.setEstado("abierto");
			repoRuleta.save(ruleta);
			return "Operación Exitosa";	
			}
		}
		return "Operación Denegada";
	}
	
	@GetMapping(path ="/listaRuleta")
	public List<Ruleta> List() {
		return repoRuleta.findAll();
	}
	
}