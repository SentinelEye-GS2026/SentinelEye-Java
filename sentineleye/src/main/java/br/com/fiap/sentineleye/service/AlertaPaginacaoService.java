package br.com.fiap.sentineleye.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.fiap.sentineleye.dto.AlertaDTO;
import br.com.fiap.sentineleye.model.Alerta;
import br.com.fiap.sentineleye.repository.AlertaRepository;

@Service
public class AlertaPaginacaoService {

	@Autowired
	private AlertaRepository repA;

	@Transactional(readOnly = true)
	public Page<AlertaDTO> paginar(PageRequest req) {
		Page<Alerta> paginados = repA.findAll(req);
		Page<AlertaDTO> paginados_dto = paginados.map(alerta -> new AlertaDTO(alerta));
		return paginados_dto;
	}
}
