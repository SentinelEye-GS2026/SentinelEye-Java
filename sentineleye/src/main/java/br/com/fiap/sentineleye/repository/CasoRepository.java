package br.com.fiap.sentineleye.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.fiap.sentineleye.model.Caso;

public interface CasoRepository extends JpaRepository<Caso, String> {

	List<Caso> findByStatus(String status);
	List<Caso> findByNivel(String nivel);

	@Query("from Caso c where c.agenteNome like %:substring%")
	List<Caso> retornarCasosPorAgente(String substring);
}
