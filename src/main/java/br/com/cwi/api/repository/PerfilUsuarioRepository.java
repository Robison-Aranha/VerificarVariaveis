package br.com.cwi.api.repository;



import br.com.cwi.api.controller.response.UsuarioListaResponse;
import br.com.cwi.api.domain.PerfilUsuario;
import br.com.cwi.api.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> {

    @Query(value = "Select * from perfil_usuario where id_usuario in (Select id_usuario1 from solicitacao_amizade where id_usuario2 = ?1)", nativeQuery = true)
    Page<PerfilUsuario> findAllSolicitacoesUsuario(Long id, Pageable pageable);
}
