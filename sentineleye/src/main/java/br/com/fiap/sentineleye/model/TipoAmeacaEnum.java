package br.com.fiap.sentineleye.model;

public enum TipoAmeacaEnum {
	PESCA_ILEGAL("Pesca Ilegal"),
	DESMATAMENTO("Desmatamento"),
	TRAFICO("Trafico"),
	ANOMALIA("Anomalia");

	private String descricao;

	TipoAmeacaEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
