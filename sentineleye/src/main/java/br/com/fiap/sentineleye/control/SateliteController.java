package br.com.fiap.sentineleye.control;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.sentineleye.model.Satelite;
import br.com.fiap.sentineleye.repository.SateliteRepository;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/satelites")
public class SateliteController {

	@Autowired
	private SateliteRepository repS;

	@Operation(description = "Retorna todos os satelites",
			   summary = "Retornar todos os satelites",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/todos")
	public ResponseEntity<List<Satelite>> retornarTodosSatelites() {
		return ResponseEntity.status(HttpStatus.OK).body(repS.findAll());
	}

	@Operation(description = "Retorna satelite por ID",
			   summary = "Retornar satelite por ID",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Satelite> retornarSatelitePorID(@PathVariable String id) {
		Optional<Satelite> op = repS.findById(id);
		if (op.isPresent()) {
			return ResponseEntity.ok(op.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Operation(description = "Retorna satelites por status",
			   summary = "Retornar satelites por status",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/status")
	public ResponseEntity<List<Satelite>> retornarSatelitesPorStatus(@RequestParam String status) {
		return ResponseEntity.ok(repS.findByStatus(status));
	}

	@Operation(description = "Retorna satelites por agencia",
			   summary = "Retornar satelites por agencia",
			   tags = "Retorno de Informacoes")
	@GetMapping(value = "/agencia")
	public ResponseEntity<List<Satelite>> retornarSatelitesPorAgencia(@RequestParam String agencia) {
		return ResponseEntity.ok(repS.retornarPorAgencia(agencia));
	}
}
