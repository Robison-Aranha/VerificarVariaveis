package br.com.cwi.api.service;

import br.com.cwi.api.domain.Publicacao;
import br.com.cwi.api.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarPublicacaoService {

    @Autowired
    PublicacaoRepository publicacaoRepository;

    public Publicacao porId(Long id) {

        return publicacaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma publicacao achada para este id!"));

    }
}
