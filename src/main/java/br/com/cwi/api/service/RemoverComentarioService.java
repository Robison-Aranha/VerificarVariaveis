package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;


    public void remover(Long id) {

        comentarioRepository.deleteById(id);
    }
}
