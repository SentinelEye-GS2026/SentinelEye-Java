package br.com.fiap.sentineleye.control;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.sentineleye.dto.UsuarioDTO;
import br.com.fiap.sentineleye.mapper.UsuarioMapperAutomatico;
import br.com.fiap.sentineleye.model.StatusUsuarioEnum;
import br.com.fiap.sentineleye.model.Usuario;
import br.com.fiap.sentineleye.record.UsuarioResponse;
import br.com.fiap.sentineleye.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repU;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UsuarioMapperAutomatico mapper;

	@GetMapping("/todos")
	public ResponseEntity<List<UsuarioDTO>> listarTodos() {
		return ResponseEntity.ok(
		repU.findAll().stream().map(mapper::toDTO)
		.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
		Optional<Usuario> op = repU.findById(id);
		if (op.isPresent()) {
			return ResponseEntity.ok(mapper.toDTO(op.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/novo")
	public ResponseEntity<UsuarioDTO> inserirUsuario(@RequestBody Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		repU.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(usuario));
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<UsuarioDTO> removerUsuario(@PathVariable Long id) {
		Optional<Usuario> op = repU.findById(id);
		if (op.isPresent()) {
			repU.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/status")
	public ResponseEntity<List<UsuarioResponse>>
	buscarPorStatus(@RequestParam StatusUsuarioEnum status) {
		return ResponseEntity.ok(repU.buscarPorStatus(status.name()));
	}

	@GetMapping("/substring")
	public ResponseEntity<List<UsuarioResponse>>
	buscarPorSubstring(@RequestParam String substring) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(repU.buscarPorSubstring(substring));
	}
}
