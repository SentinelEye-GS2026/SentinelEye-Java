package br.com.fiap.sentineleye.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "evento_linha_tempo")
public class EventoLinhaTempo {

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "fk_caso")
	@JsonIgnore
	private Caso caso;

	@NotEmpty(message = "A mensagem e um campo obrigatorio")
	@Size(min = 1, max = 500)
	private String mensagem;

	private LocalDateTime timestamp;
	private String tipo;

	public EventoLinhaTempo() {}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public Caso getCaso() { return caso; }
	public void setCaso(Caso caso) { this.caso = caso; }
	public String getMensagem() { return mensagem; }
	public void setMensagem(String mensagem) { this.mensagem = mensagem; }
	public LocalDateTime getTimestamp() { return timestamp; }
	public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
}
