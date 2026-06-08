package br.com.fiap.sentineleye.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.sentineleye.model.Caso;
import br.com.fiap.sentineleye.model.EventoLinhaTempo;

public class CasoDTO {

	private String id;
	private String alertaId;
	private String titulo;
	private String nivel;
	private String status;
	private String agenteId;
	private String agenteNome;
	private LocalDateTime aberturaEm;
	private LocalDateTime atualizadoEm;
	private LocalDateTime fechadoEm;
	private String notas;
	private List<EventoLinhaTempo> linhaTempo;

	public CasoDTO() {}

	public CasoDTO(Caso caso) {
		this.id = caso.getId();
		this.alertaId = caso.getAlertaId();
		this.titulo = caso.getTitulo();
		this.nivel = caso.getNivel();
		this.status = caso.getStatus();
		this.agenteId = caso.getAgenteId();
		this.agenteNome = caso.getAgenteNome();
		this.aberturaEm = caso.getAberturaEm();
		this.atualizadoEm = caso.getAtualizadoEm();
		this.fechadoEm = caso.getFechadoEm();
		this.notas = caso.getNotas() != null ? caso.getNotas() : "";
		// linhaTempo nunca retorna null — sempre retorna [] se vazio
		if (caso.getLinhaTempo() != null) {
			this.linhaTempo = new ArrayList<>(caso.getLinhaTempo());
		} else {
			this.linhaTempo = new ArrayList<>();
		}
	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getAlertaId() { return alertaId; }
	public void setAlertaId(String alertaId) { this.alertaId = alertaId; }
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getNivel() { return nivel; }
	public void setNivel(String nivel) { this.nivel = nivel; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
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
}
