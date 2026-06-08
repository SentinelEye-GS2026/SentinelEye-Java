package br.com.fiap.sentineleye.dto;

import java.time.LocalDate;
import br.com.fiap.sentineleye.model.Pessoa;
import br.com.fiap.sentineleye.model.StatusUsuarioEnum;

public class UsuarioDTO {

	private Pessoa pessoa;
	private String rm;
	private String permissao;
	private LocalDate dataCriacao;
	private StatusUsuarioEnum status;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Pessoa pessoa, String rm, String permissao,
			LocalDate dataCriacao, StatusUsuarioEnum status) {
		super();
		this.pessoa = pessoa;
		this.rm = rm;
		this.permissao = permissao;
		this.dataCriacao = dataCriacao;
		this.status = status;
	}

	public Pessoa getPessoa() { return pessoa; }
	public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
	public String getRm() { return rm; }
	public void setRm(String rm) { this.rm = rm; }
	public String getPermissao() { return permissao; }
	public void setPermissao(String permissao) { this.permissao = permissao; }
	public LocalDate getDataCriacao() { return dataCriacao; }
	public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
	public StatusUsuarioEnum getStatus() { return status; }
	public void setStatus(StatusUsuarioEnum status) { this.status = status; }
}
