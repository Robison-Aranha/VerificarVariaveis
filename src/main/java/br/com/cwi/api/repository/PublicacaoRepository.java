package br.com.cwi.api.repository;

import br.com.cwi.api.controller.response.ListarPublicacoesResponse;
import br.com.cwi.api.domain.Publicacao;
import br.com.cwi.api.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {


    @Query(value = "select * from publicacao where id_usuario = ?1 or id_usuario in (select id_usuario2 from amigos where id_usuario1 = ?1) order by data_postagem desc", nativeQuery = true)
    Page<Publicacao> findUsuariosPublicacoes(Long id, Pageable pageable);

    Page<Publicacao> findByUsuarioPostagemOrderByDataPostagemDesc(Usuario usuario, Pageable pageable);

    Page<Publicacao> findByUsuarioPostagemAndPrivadoOrderByDataPostagemDesc(Usuario usuario, boolean b, Pageable pageable);

}
