package br.com.fiap.sentineleye.dto;

import java.time.LocalDateTime;
import br.com.fiap.sentineleye.model.Alerta;

public class AlertaDTO {

	private String id;
	private String sateliteId;
	private String sateliteNome;
	private String casoId;
	private String nivel;
	private String tipoAmeaca;
	private Integer confianca;
	private Double lat;
	private Double lon;
	private String regiao;
	private LocalDateTime detectadoEm;
	private String descricao;
	private String status;

	public AlertaDTO() {}

	public AlertaDTO(Alerta alerta) {
		this.id = alerta.getId();
		// sateliteId e sateliteNome extraidos do objeto satelite
		if (alerta.getSatelite() != null) {
			this.sateliteId = alerta.getSatelite().getId();
			this.sateliteNome = alerta.getSatelite().getNome();
		}
		this.casoId = alerta.getCasoId();
		this.nivel = alerta.getNivel();
		this.tipoAmeaca = alerta.getTipoAmeaca();
		this.confianca = alerta.getConfianca();
		this.lat = alerta.getLat();
		this.lon = alerta.getLon();
		this.regiao = alerta.getRegiao();
		this.detectadoEm = alerta.getDetectadoEm();
		this.descricao = alerta.getDescricao();
		this.status = alerta.getStatus();
	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getSateliteId() { return sateliteId; }
	public void setSateliteId(String sateliteId) { this.sateliteId = sateliteId; }
	public String getSateliteNome() { return sateliteNome; }
	public void setSateliteNome(String sateliteNome) { this.sateliteNome = sateliteNome; }
	public String getCasoId() { return casoId; }
	public void setCasoId(String casoId) { this.casoId = casoId; }
	public String getNivel() { return nivel; }
	public void setNivel(String nivel) { this.nivel = nivel; }
	public String getTipoAmeaca() { return tipoAmeaca; }
	public void setTipoAmeaca(String tipoAmeaca) { this.tipoAmeaca = tipoAmeaca; }
	public Integer getConfianca() { return confianca; }
	public void setConfianca(Integer confianca) { this.confianca = confianca; }
	public Double getLat() { return lat; }
	public void setLat(Double lat) { this.lat = lat; }
	public Double getLon() { return lon; }
	public void setLon(Double lon) { this.lon = lon; }
	public String getRegiao() { return regiao; }
	public void setRegiao(String regiao) { this.regiao = regiao; }
	public LocalDateTime getDetectadoEm() { return detectadoEm; }
	public void setDetectadoEm(LocalDateTime detectadoEm) { this.detectadoEm = detectadoEm; }
	public String getDescricao() { return descricao; }
	public void setDescricao(String descricao) { this.descricao = descricao; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
}
