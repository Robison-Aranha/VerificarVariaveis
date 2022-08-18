package br.com.cwi.api.service;


import br.com.cwi.api.controller.response.ListarComentariosResponse;
import br.com.cwi.api.domain.Publicacao;
import br.com.cwi.api.mapper.ListarComentariosMapper;
import br.com.cwi.api.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarComentariosPublicacaoService {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    BuscarPublicacaoService buscarPublicacaoService;

    public Page<ListarComentariosResponse> listar(Long id, Pageable pageable) {

        Publicacao publicacao = buscarPublicacaoService.porId(id);

        return comentarioRepository.findByPublicacaoOrderByDataPostagemAsc(publicacao, pageable).map(ListarComentariosMapper::toResponse);

    }
}
