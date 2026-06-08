package br.com.fiap.sentineleye.projection;

// Projection - igual ao MusicaProjection do professor
public interface AlertaProjection {
	public String getNivel();
	public String getTipoAmeaca();
	public Double getLat();
	public Double getLon();
	public String getRegiao();
	public String getStatus();
	public String getSateliteNome();
}
