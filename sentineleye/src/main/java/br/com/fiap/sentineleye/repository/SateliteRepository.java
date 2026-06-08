package br.com.fiap.sentineleye.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.fiap.sentineleye.model.Satelite;

public interface SateliteRepository extends JpaRepository<Satelite, String> {

	List<Satelite> findByStatus(String status);

	@Query("from Satelite s where s.agencia = :agencia")
	List<Satelite> retornarPorAgencia(String agencia);
}
