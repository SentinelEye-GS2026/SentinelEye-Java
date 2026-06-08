package br.com.fiap.sentineleye.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.fiap.sentineleye.model.Alerta;
import br.com.fiap.sentineleye.projection.AlertaProjection;

public interface AlertaRepository extends JpaRepository<Alerta, String> {

	@Query("from Alerta a where a.nivel = :nivel")
	List<Alerta> retornarAlertasPorNivel(String nivel);

	@Query(nativeQuery = true,
		   value = "select distinct a.nivel, a.tipo_ameaca, a.lat, a.lon, "
		   		 + "a.regiao, a.status, s.nome as satelite_nome "
		   		 + "from alerta a "
		   		 + "inner join satelite s on (a.fk_satelite = s.id) "
		   		 + "where (upper(a.regiao) like upper(concat('%',:substring,'%'))) "
		   		 + "or (upper(s.nome) like upper(concat('%',:substring,'%'))) "
		   		 + "order by a.nivel asc")
	List<AlertaProjection> retornarAlertasPorSubstring(String substring);

	List<Alerta> findByStatus(String status);
	List<Alerta> findByNivel(String nivel);
}
