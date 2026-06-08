package br.com.fiap.sentineleye.mapper;

import org.springframework.stereotype.Component;
import br.com.fiap.sentineleye.dto.AlertaDTO;
import br.com.fiap.sentineleye.model.Alerta;

@Component
public class AlertaMapperManual {

	public AlertaDTO toDTO(Alerta alerta) {
		AlertaDTO dto = new AlertaDTO(alerta);
		return dto;
	}
}
