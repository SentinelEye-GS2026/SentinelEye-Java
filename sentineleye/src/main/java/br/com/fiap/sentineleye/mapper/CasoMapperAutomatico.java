package br.com.fiap.sentineleye.mapper;

import org.springframework.stereotype.Component;
import br.com.fiap.sentineleye.dto.CasoDTO;
import br.com.fiap.sentineleye.model.Caso;

@Component
public class CasoMapperAutomatico {

	public CasoDTO toDTO(Caso caso) {
		CasoDTO dto = new CasoDTO(caso);
		// Garante que alertaId nunca vem vazio
		if (dto.getAlertaId() == null || dto.getAlertaId().isEmpty()) {
			if (caso.getAlertas() != null && !caso.getAlertas().isEmpty()) {
				dto.setAlertaId(caso.getAlertas().get(0).getId());
			}
		}
		return dto;
	}

	public Caso toEntity(CasoDTO dto) {
		Caso caso = new Caso();
		caso.setId(dto.getId());
		caso.setAlertaId(dto.getAlertaId());
		caso.setTitulo(dto.getTitulo());
		caso.setNivel(dto.getNivel());
		caso.setStatus(dto.getStatus());
		caso.setAgenteId(dto.getAgenteId());
		caso.setAgenteNome(dto.getAgenteNome());
		caso.setAberturaEm(dto.getAberturaEm());
		caso.setAtualizadoEm(dto.getAtualizadoEm());
		caso.setFechadoEm(dto.getFechadoEm());
		caso.setNotas(dto.getNotas());
		return caso;
	}
}
