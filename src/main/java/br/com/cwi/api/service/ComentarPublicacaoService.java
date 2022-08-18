package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.controller.request.IncluirComentarioRequest;
import br.com.cwi.api.domain.Comentario;
import br.com.cwi.api.domain.Publicacao;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.IncluirComentarioMapper;
import br.com.cwi.api.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ComentarPublicacaoService {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    @Autowired
    BuscarPublicacaoService buscarPublicacaoService;

    @Autowired
    FormatarHoraService formatarHoraService;

    public void comentar(Long id, IncluirComentarioRequest request) {

        Usuario usuario = buscarUsuarioService.porId(request.getIdUsuario());

        Publicacao publicacao = buscarPublicacaoService.porId(id);

        Comentario comentario = IncluirComentarioMapper.toEntity(request);


        comentario.setDataPostagem(LocalDateTime.now());

        comentario.setPublicacao(publicacao);
        comentario.setUsuarioComentario(usuario);

        comentarioRepository.save(comentario);
    }
}
