package br.com.fiap.sentineleye.record;

import java.time.LocalDate;

// Projection como interface - compativel com queries nativas do Spring Data JPA
// Mesmo padrao do MusicaProjection do professor
public interface UsuarioResponse {
	String getRm();
	String getNome();
	String getPermissao();
	String getStatus();
	LocalDate getDataNascimento();
	String getEmailPessoal();
}
