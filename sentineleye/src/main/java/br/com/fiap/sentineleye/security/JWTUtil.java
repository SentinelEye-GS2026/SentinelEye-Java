package br.com.fiap.sentineleye.security;

import java.util.Date;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	// Chave fixa — token valido mesmo apos restart da API
	private static final String SECRET =
		"sentineleye-fiap-gs-2026-chave-secreta-java-advanced-seguranca";

	private final SecretKey CHAVE = Keys.hmacShaKeyFor(
		SECRET.getBytes(StandardCharsets.UTF_8));

	// geracao de token
	public String gerarToken(String username, Integer duracao) {
		Date data_atual = new Date();
		JwtBuilder builder = Jwts.builder()
								 .subject(username)
								 .issuedAt(data_atual)
								 .expiration(
								  new Date(data_atual.getTime() + (1000 * 60 * duracao)))
								 .signWith(CHAVE);
		return builder.compact();
	}

	// extrair um usuario de um token
	public String extrairUsername(String token) {
		try {
			JwtParser parser = Jwts.parser().verifyWith(CHAVE).build();
			return parser.parseSignedClaims(token).getPayload().getSubject();
		} catch (Exception e) {
			return null;
		}
	}

	// validar token
	public boolean validarToken(String token) {
		try {
			JwtParser parser = Jwts.parser().verifyWith(CHAVE).build();
			parser.parseSignedClaims(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
