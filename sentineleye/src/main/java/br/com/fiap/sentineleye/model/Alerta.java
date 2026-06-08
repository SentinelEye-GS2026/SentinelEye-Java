package br.com.fiap.sentineleye.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Essa entidade representa um alerta de ameaca ambiental detectada por satelite")
@Entity
@Table(name = "alerta")
public class Alerta {

	@Id
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_satelite")
	private Satelite satelite;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_caso")
	@JsonIgnore
	private Caso caso;

	@jakarta.persistence.Column(name = "caso_id")
	private String casoId;

	@NotEmpty(message = "O nivel e um campo obrigatorio")
	private String nivel;

	@NotEmpty(message = "O tipo de ameaca e um campo obrigatorio")
	private String tipoAmeaca;

	@Min(value = 0) @Max(value = 100)
	private Integer confianca;

	@NotNull @DecimalMin("-90.0") @DecimalMax("90.0")
	private Double lat;

	@NotNull @DecimalMin("-180.0") @DecimalMax("180.0")
	private Double lon;

	@NotEmpty @Size(min = 1, max = 200)
	private String regiao;

	private LocalDateTime detectadoEm;

	@Size(max = 500)
	private String descricao;

	private String status;

	public void transferirAlerta(Alerta alerta) {
		this.satelite = alerta.getSatelite();
		this.caso = alerta.getCaso();
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

	public Alerta() {}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public Satelite getSatelite() { return satelite; }
	public void setSatelite(Satelite satelite) { this.satelite = satelite; }
	public Caso getCaso() { return caso; }
	public void setCaso(Caso caso) { this.caso = caso; }
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
