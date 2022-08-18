package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IgnorarSolicitacaoService {


    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    public void ignorar(Long id, IdRequest request) {

        Usuario usuario = buscarUsuarioService.porId(id);

        Usuario solicitador = buscarUsuarioService.porId(request.getId());

        usuario.retirarSolicitacao(solicitador);

        usuarioRepository.save(usuario);
    }
}
