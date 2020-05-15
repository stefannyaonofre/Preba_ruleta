package pruebaRuleta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pruebaRuleta.model.Apuesta;

public interface ApuestaRepo  extends JpaRepository<Apuesta, Integer> {
	
	

	@Query(value = "SELECT SUM(valor apostado) FROM apuesta WHERE id_ruleta = :idRuleta", nativeQuery = true)
	double resultadoApuesta(@Param("idRuleta") Integer idRuleta);
}
