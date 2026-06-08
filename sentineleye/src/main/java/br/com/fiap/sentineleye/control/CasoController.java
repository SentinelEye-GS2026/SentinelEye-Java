package br.com.fiap.sentineleye.control;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.fiap.sentineleye.dto.CasoDTO;
import br.com.fiap.sentineleye.mapper.CasoMapperAutomatico;
import br.com.fiap.sentineleye.model.Caso;
import br.com.fiap.sentineleye.repository.CasoRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/casos")
public class CasoController {

	@Autowired
	private CasoRepository repC;

	@Autowired
	private CasoMapperAutomatico mapper;

	@Operation(description = "Retorna todos os casos investigativos com linha do tempo",
			   summary = "Retornar todos os casos",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/todos")
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public ResponseEntity<List<CasoDTO>> retornarTodosCasos() {
		List<CasoDTO> lista = repC.findAll().stream()
				.map(mapper::toDTO).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@Operation(description = "Retorna um caso pelo ID",
			   summary = "Retornar caso por ID",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/{id}")
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public ResponseEntity<CasoDTO> retornarCasoPorID(@PathVariable String id) {
		Optional<Caso> op = repC.findById(id);
		if (op.isPresent()) {
			return ResponseEntity.ok(mapper.toDTO(op.get()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Operation(description = "Retorna casos por status",
			   summary = "Retornar casos por status",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/status")
	public ResponseEntity<List<CasoDTO>> retornarCasosPorStatus(@RequestParam String status) {
		return ResponseEntity.ok(repC.findByStatus(status).stream()
				.map(mapper::toDTO).collect(Collectors.toList()));
	}

	@Operation(description = "Insere novo caso investigativo",
			   summary = "Inserir novo caso",
			   tags = "Persistencia de Informacoes")
	@PostMapping(value = "/inserir")
	public ResponseEntity<CasoDTO> inserirCaso(@RequestBody @Valid Caso caso) {
		repC.save(caso);
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(caso));
	}

	@Operation(description = "Remove um caso investigativo",
			   summary = "Remover caso",
			   tags = "Remocao de Informacoes")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CasoDTO> removerCaso(@PathVariable String id) {
		Optional<Caso> op = repC.findById(id);
		if (op.isPresent()) {
			repC.delete(op.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Operation(description = "Atualiza um caso investigativo",
			   summary = "Atualizar caso",
			   tags = "Atualizacao de Informacoes")
	@PutMapping(value = "/{id}")
	public ResponseEntity<CasoDTO> atualizarCaso(@PathVariable String id,
			@RequestBody @Valid Caso caso) {
		Optional<Caso> op = repC.findById(id);
		if (op.isPresent()) {
			Caso caso_banco = op.get();
			caso_banco.transferirCaso(caso);
			repC.save(caso_banco);
			return ResponseEntity.ok(mapper.toDTO(caso_banco));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
