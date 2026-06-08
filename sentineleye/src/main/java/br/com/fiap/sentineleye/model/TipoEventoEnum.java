package br.com.fiap.sentineleye.model;

public enum TipoEventoEnum {
	DETECCAO("Deteccao"),
	ATRIBUICAO("Atribuicao"),
	ATUALIZACAO("Atualizacao"),
	RESOLUCAO("Resolucao");

	private String descricao;

	TipoEventoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
