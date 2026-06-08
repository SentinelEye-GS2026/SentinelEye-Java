package br.com.fiap.sentineleye.mapper;

import org.springframework.stereotype.Component;
import br.com.fiap.sentineleye.dto.AlertaDTO;
import br.com.fiap.sentineleye.model.Alerta;

@Component
public class AlertaMapperAutomatico {

	public AlertaDTO toDTO(Alerta alerta) {
		return new AlertaDTO(alerta);
	}

	public Alerta toEntity(AlertaDTO dto) {
		Alerta alerta = new Alerta();
		alerta.setId(dto.getId());
		alerta.setNivel(dto.getNivel());
		alerta.setTipoAmeaca(dto.getTipoAmeaca());
		alerta.setConfianca(dto.getConfianca());
		alerta.setLat(dto.getLat());
		alerta.setLon(dto.getLon());
		alerta.setRegiao(dto.getRegiao());
		alerta.setDetectadoEm(dto.getDetectadoEm());
		alerta.setDescricao(dto.getDescricao());
		alerta.setStatus(dto.getStatus());
		alerta.setCasoId(dto.getCasoId());
		return alerta;
	}
}
