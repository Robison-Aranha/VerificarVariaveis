package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.domain.Publicacao;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivarPostagemService {

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    @Autowired
    BuscarPublicacaoService buscarPublicacaoService;

    @Autowired
    PublicacaoRepository publicacaoRepository;


    public void privar(Long id) {

        Publicacao publicacao = buscarPublicacaoService.porId(id);

        publicacao.setPrivado(!publicacao.isPrivado());

        publicacaoRepository.save(publicacao);

    }
}
