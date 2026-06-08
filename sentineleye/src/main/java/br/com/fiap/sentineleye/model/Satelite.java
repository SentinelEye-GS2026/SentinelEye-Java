package br.com.fiap.sentineleye.model;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Schema(description = "Essa entidade tem por objetivo representar a tabela satelite")
@Entity
@Table(name = "satelite")
public class Satelite {

	@Id
	private String id;

	@NotEmpty(message = "O nome do satelite e um campo obrigatorio")
	@Size(min = 1, max = 100, message = "O nome deve ter ao menos 1 e no maximo 100 caracteres")
	@Schema(description = "Nome do satelite", example = "Sentinel-1")
	private String nome;

	@NotEmpty(message = "A agencia e um campo obrigatorio")
	@Schema(description = "Agencia responsavel pelo satelite", example = "ESA")
	private String agencia;

	@NotEmpty(message = "O tipo e um campo obrigatorio")
	@Schema(description = "Tipo do sensor do satelite", example = "SAR")
	private String tipo;

	@Schema(description = "Altitude orbital em km", example = "693")
	private Integer altitudeKm;

	@Schema(description = "Intervalo de revisita em dias", example = "6")
	private Integer diasRevisita;

	@Schema(description = "Status operacional", example = "ativo")
	private String status;

	@Schema(description = "Areas de cobertura do satelite", example = "Atlantico Sul - Amazonia")
	private String cobertura;

	@Schema(description = "Descricao do satelite e suas capacidades")
	private String descricao;

	private LocalDateTime ultimaPassagem;
	private LocalDateTime proximaPassagem;

	@OneToMany(mappedBy = "satelite", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Alerta> alertas;

	public Satelite() {}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getAgencia() { return agencia; }
	public void setAgencia(String agencia) { this.agencia = agencia; }
	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
	public Integer getAltitudeKm() { return altitudeKm; }
	public void setAltitudeKm(Integer altitudeKm) { this.altitudeKm = altitudeKm; }
	public Integer getDiasRevisita() { return diasRevisita; }
	public void setDiasRevisita(Integer diasRevisita) { this.diasRevisita = diasRevisita; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	public String getCobertura() { return cobertura; }
	public void setCobertura(String cobertura) { this.cobertura = cobertura; }
	public String getDescricao() { return descricao; }
	public void setDescricao(String descricao) { this.descricao = descricao; }
	public LocalDateTime getUltimaPassagem() { return ultimaPassagem; }
	public void setUltimaPassagem(LocalDateTime ultimaPassagem) { this.ultimaPassagem = ultimaPassagem; }
	public LocalDateTime getProximaPassagem() { return proximaPassagem; }
	public void setProximaPassagem(LocalDateTime proximaPassagem) { this.proximaPassagem = proximaPassagem; }
	public List<Alerta> getAlertas() { return alertas; }
	public void setAlertas(List<Alerta> alertas) { this.alertas = alertas; }
}
