package br.com.cwi.api.service;


import br.com.cwi.api.domain.Publicacao;
import br.com.cwi.api.repository.ComentarioRepository;
import br.com.cwi.api.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class RemoverPublicacaoService {

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    ComentarioRepository comentarioRepository;

    public void deletar(Long id) {

        Publicacao publicacao = publicacaoRepository.findById(id).get();

        comentarioRepository.deleteAllByPublicacao(publicacao);

        publicacaoRepository.deleteById(id);

    }
}
