package br.com.fiap.sentineleye.mapper;

import org.springframework.stereotype.Component;
import br.com.fiap.sentineleye.dto.UsuarioDTO;
import br.com.fiap.sentineleye.model.Usuario;

/**
 * Mapper automatico de Usuario — implementacao manual com @Component.
 */
@Component
public class UsuarioMapperAutomatico {

	public UsuarioDTO toDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO(
				usuario.getPessoa(),
				usuario.getRm(),
				usuario.getPermissao(),
				usuario.getDataCriacao(),
				usuario.getStatus());
		return dto;
	}

	public Usuario toEntity(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setPessoa(dto.getPessoa());
		usuario.setRm(dto.getRm());
		usuario.setPermissao(dto.getPermissao());
		usuario.setDataCriacao(dto.getDataCriacao());
		usuario.setStatus(dto.getStatus());
		return usuario;
	}
}
