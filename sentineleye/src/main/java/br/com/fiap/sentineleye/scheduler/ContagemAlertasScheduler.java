package br.com.fiap.sentineleye.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import br.com.fiap.sentineleye.service.AlertaCachingService;

@Component
public class ContagemAlertasScheduler {

	@Autowired
	private AlertaCachingService cacheA;

	@Scheduled(fixedRate = 30000)
	public void verificarQtdAlertas() {
		Integer qtd = cacheA.findAll().size();
		if (qtd >= 5) {
			System.out.println(" ===== ALERTA!!!! Existem " + qtd + " alertas ativos! =====");
		}
	}
}
