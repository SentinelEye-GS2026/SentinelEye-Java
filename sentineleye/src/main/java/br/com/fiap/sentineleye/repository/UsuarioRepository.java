package br.com.fiap.sentineleye.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.fiap.sentineleye.model.Usuario;
import br.com.fiap.sentineleye.record.UsuarioResponse;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByRm(String rm);

	@Query(nativeQuery = true,
		   value = "select u.rm, p.nome, u.permissao, u.status, "
		   		 + "p.data_nascimento, p.email_pessoal from "
		   		 + "usuario u inner join pessoa p "
		   		 + "on(p.id = u.fk_pessoa) where u.status = :status")
	List<UsuarioResponse> buscarPorStatus(String status);

	@Query(nativeQuery = true,
		   value = "select distinct u.rm, p.nome, u.permissao, u.status, "
		   		 + "p.data_nascimento, p.email_pessoal from "
		   		 + "usuario u inner join pessoa p "
		   		 + "on(p.id = u.fk_pessoa) where "
		   		 + "(upper(p.nome) like upper(concat('%',:substring,'%'))) "
		   		 + "or "
		   		 + "(upper(u.rm) like upper(concat('%',:substring,'%')))")
	List<UsuarioResponse> buscarPorSubstring(String substring);
}
