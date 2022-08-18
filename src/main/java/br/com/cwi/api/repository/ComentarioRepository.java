package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Comentario;
import br.com.cwi.api.domain.Publicacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    Page<Comentario> findByPublicacaoOrderByDataPostagemAsc(Publicacao publicacao, Pageable pageable);

    void deleteAllByPublicacao(Publicacao publicacao);
}
