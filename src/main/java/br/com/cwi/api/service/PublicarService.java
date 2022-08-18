package br.com.cwi.api.service;


import br.com.cwi.api.controller.request.IncluirPublicacaoRequest;
import br.com.cwi.api.domain.Publicacao;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.IncluirPublicacaoMapper;
import br.com.cwi.api.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PublicarService {

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    @Autowired
    FormatarHoraService formatarHoraService;

    public void publicar(Long id, IncluirPublicacaoRequest request) {

        Usuario usuario = buscarUsuarioService.porId(id);

        Publicacao publicacao = IncluirPublicacaoMapper.toEntity(request);

        publicacao.setUsuarioPostagem(usuario);

        publicacao.setDataPostagem(LocalDateTime.now());

        publicacaoRepository.save(publicacao);
    }
}
