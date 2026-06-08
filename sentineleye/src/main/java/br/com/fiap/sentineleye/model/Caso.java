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

@Schema(description = "Essa entidade representa um caso investigativo aberto a partir de um alerta")
@Entity
@Table(name = "caso")
public class Caso {

	@Id
	private String id;

	@NotEmpty(message = "O titulo e um campo obrigatorio")
	@Size(min = 1, max = 200)
	private String titulo;
	private String nivel;
	private String status;
	@jakarta.persistence.Column(name = "alerta_id")
	private String alertaId;
	private String agenteId;
	private String agenteNome;
	private LocalDateTime aberturaEm;
	private LocalDateTime atualizadoEm;
	private LocalDateTime fechadoEm;

	@Size(max = 2000)
	private String notas;

	@OneToMany(mappedBy = "caso", cascade = CascadeType.ALL)
	private List<EventoLinhaTempo> linhaTempo;

	@OneToMany(mappedBy = "caso", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Alerta> alertas;

	public void transferirCaso(Caso caso) {
		this.titulo = caso.getTitulo();
		this.nivel = caso.getNivel();
		this.status = caso.getStatus();
		this.alertaId = caso.getAlertaId();
		this.agenteId = caso.getAgenteId();
		this.agenteNome = caso.getAgenteNome();
		this.atualizadoEm = caso.getAtualizadoEm();
		this.fechadoEm = caso.getFechadoEm();
		this.notas = caso.getNotas();
	}

	public Caso() {}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getNivel() { return nivel; }
	public void setNivel(String nivel) { this.nivel = nivel; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	public String getAlertaId() { return alertaId; }
	public void setAlertaId(String alertaId) { this.alertaId = alertaId; }
	public String getAgenteId() { return agenteId; }
	public void setAgenteId(String agenteId) { this.agenteId = agenteId; }
	public String getAgenteNome() { return agenteNome; }
	public void setAgenteNome(String agenteNome) { this.agenteNome = agenteNome; }
	public LocalDateTime getAberturaEm() { return aberturaEm; }
	public void setAberturaEm(LocalDateTime aberturaEm) { this.aberturaEm = aberturaEm; }
	public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
	public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
	public LocalDateTime getFechadoEm() { return fechadoEm; }
	public void setFechadoEm(LocalDateTime fechadoEm) { this.fechadoEm = fechadoEm; }
	public String getNotas() { return notas; }
	public void setNotas(String notas) { this.notas = notas; }
	public List<EventoLinhaTempo> getLinhaTempo() { return linhaTempo; }
	public void setLinhaTempo(List<EventoLinhaTempo> linhaTempo) { this.linhaTempo = linhaTempo; }
	public List<Alerta> getAlertas() { return alertas; }
	public void setAlertas(List<Alerta> alertas) { this.alertas = alertas; }
}
