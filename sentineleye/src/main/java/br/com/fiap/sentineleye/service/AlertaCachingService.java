package br.com.fiap.sentineleye.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import br.com.fiap.sentineleye.model.Alerta;
import br.com.fiap.sentineleye.projection.AlertaProjection;
import br.com.fiap.sentineleye.repository.AlertaRepository;

@Service
public class AlertaCachingService {

	@Autowired
	private AlertaRepository repA;

	@Cacheable(value = "todosAlertas")
	public List<Alerta> findAll() {
		return repA.findAll();
	}

	@Cacheable(value = "alertaPorID", key = "#id")
	public Optional<Alerta> findById(String id) {
		return repA.findById(id);
	}

	@Cacheable(value = "alertasPorSubstring", key = "#substring")
	public List<AlertaProjection> retornarAlertasPorSubstring(String substring) {
		return repA.retornarAlertasPorSubstring(substring);
	}

	@Cacheable(value = "alertasPorNivel", key = "#nivel")
	public List<Alerta> retornarAlertasPorNivel(String nivel) {
		return repA.retornarAlertasPorNivel(nivel);
	}

	@CacheEvict(value = { "todosAlertas", "alertaPorID",
			"alertasPorSubstring", "alertasPorNivel" }, allEntries = true)
	public void removerCache() {
		System.out.println("Removendo cache de alertas");
	}
}
