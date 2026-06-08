package br.com.fiap.sentineleye.control;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.sentineleye.dto.AlertaDTO;
import br.com.fiap.sentineleye.mapper.AlertaMapperAutomatico;
import br.com.fiap.sentineleye.model.Alerta;
import br.com.fiap.sentineleye.projection.AlertaProjection;
import br.com.fiap.sentineleye.repository.AlertaRepository;
import br.com.fiap.sentineleye.service.AlertaCachingService;
import br.com.fiap.sentineleye.service.AlertaPaginacaoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/alertas")
public class AlertaController {

	@Autowired
	private AlertaRepository repA;

	@Autowired
	private AlertaPaginacaoService paginacaoA;

	@Autowired
	private AlertaCachingService cacheA;

	@Autowired
	private AlertaMapperAutomatico mapper;

	@Operation(description = "Retorna alertas em forma de paginas de AlertaDTO",
			   summary = "Retornar paginas de AlertasDTO",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/paginados")
	public ResponseEntity<Page<AlertaDTO>> paginar(
		@RequestParam(name = "page", defaultValue = "0") Integer page,
		@RequestParam(name = "size", defaultValue = "2") Integer size) {
		PageRequest pr = PageRequest.of(page, size);
		Page<AlertaDTO> alertas_dto_paginados = paginacaoA.paginar(pr);
		return ResponseEntity.ok(alertas_dto_paginados);
	}

	@Operation(description = "Retorna todos os alertas via Caching",
			   summary = "Retornar todos os alertas (caching)",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/todos")
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public ResponseEntity<List<AlertaDTO>> retornarTodosAlertas() {
		List<AlertaDTO> lista = cacheA.findAll().stream()
				.map(mapper::toDTO).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@Operation(description = "Retorna alertas por ID",
			   summary = "Retornar alerta por ID",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlertaDTO> retornarAlertaPorID(@PathVariable String id) {
		Optional<Alerta> op = cacheA.findById(id);
		if (op.isPresent()) {
			return ResponseEntity.ok(mapper.toDTO(op.get()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Operation(description = "Retorna projecoes de alertas por substring (caching)",
			   summary = "Retornar projecoes de alertas via substring (caching)",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/substring_caching")
	public ResponseEntity<List<AlertaProjection>>
	retornarAlertasPorSubstringCaching(@RequestParam String substring) {
		return ResponseEntity.ok(cacheA.retornarAlertasPorSubstring(substring));
	}

	@Operation(description = "Retorna projecoes de alertas por substring",
			   summary = "Retornar projecoes de alertas via substring",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/substring")
	public ResponseEntity<List<AlertaProjection>>
	retornarAlertasPorSubstring(@RequestParam String substring) {
		return ResponseEntity.ok(repA.retornarAlertasPorSubstring(substring));
	}

	@Operation(description = "Retorna alertas por nivel (otimizado por JPQL)",
			   summary = "Retornar alertas por nivel (otimizado)",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/nivel_otimizado")
	public ResponseEntity<List<AlertaDTO>> retornarAlertasPorNivelOtimizado(@RequestParam String nivel) {
		return ResponseEntity.ok(cacheA.retornarAlertasPorNivel(nivel)
				.stream().map(mapper::toDTO).collect(Collectors.toList()));
	}

	@Operation(description = "Retorna alertas por nivel",
			   summary = "Retornar alertas por nivel",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/nivel")
	public ResponseEntity<List<AlertaDTO>> retornarAlertasPorNivel(@RequestParam String nivel) {
		List<Alerta> todos = cacheA.findAll();
		List<Alerta> filtrados = todos.stream()
				.filter(a -> a.getNivel().equals(nivel))
				.collect(Collectors.toList());
		return ResponseEntity.ok(filtrados.stream().map(mapper::toDTO)
				.collect(Collectors.toList()));
	}

	@Operation(description = "Insere novo alerta",
			   summary = "Inserir novo alerta",
			   tags = "Persistencia de Informacoes")
	@PostMapping(value = "/inserir")
	public ResponseEntity<AlertaDTO> inserirAlerta(@RequestBody @Valid Alerta alerta) {
		repA.save(alerta);
		cacheA.removerCache();
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(alerta));
	}

	@Operation(description = "Remove um alerta",
			   summary = "Remover alerta",
			   tags = "Remocao de Informacoes")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AlertaDTO> removerAlerta(@PathVariable String id) {
		Optional<Alerta> op = cacheA.findById(id);
		if (op.isPresent()) {
			repA.delete(op.get());
			cacheA.removerCache();
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Operation(description = "Atualiza um alerta",
			   summary = "Atualizar alerta",
			   tags = "Atualizacao de Informacoes")
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlertaDTO> atualizarAlerta(@PathVariable String id,
			@RequestBody @Valid Alerta alerta) {
		Optional<Alerta> op = cacheA.findById(id);
		if (op.isPresent()) {
			Alerta alerta_banco = op.get();
			alerta_banco.transferirAlerta(alerta);
			repA.save(alerta_banco);
			cacheA.removerCache();
			return ResponseEntity.ok(mapper.toDTO(alerta_banco));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
