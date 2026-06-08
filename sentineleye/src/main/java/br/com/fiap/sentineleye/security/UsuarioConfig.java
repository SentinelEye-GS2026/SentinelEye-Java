package br.com.fiap.sentineleye.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import br.com.fiap.sentineleye.model.Usuario;
import br.com.fiap.sentineleye.repository.UsuarioRepository;

@Configuration
public class UsuarioConfig {

	@Autowired
	private UsuarioRepository repU;

	@Bean
	public UserDetailsService gerarUsuario() throws Exception {
		return rm -> {
			Usuario usuario = repU.findByRm(rm)
						  .orElseThrow(
						  () -> new UsernameNotFoundException("Usuario nao foi localizado"));
			return User.builder()
					.username(usuario.getRm())
					.password(usuario.getSenha())
					.roles(usuario.getPermissao())
					.build();
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
