package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EnviarSolicitacaoAmizadeService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;


    public void enviar(Long id, IdRequest request) {

        Usuario usuario = buscarUsuarioService.porId(id);

        Usuario solicitado = buscarUsuarioService.porId(request.getId());

        if (solicitado.getSolicitacoes().indexOf(usuario) != -1){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Voce ja enviou uma solicitacao para este usuario!");
        }

        if (solicitado.getAmigos().indexOf(usuario) != -1){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Voce ja é amigo deste usuario!");
        }

        solicitado.adicionarSolicitacao(usuario);

        usuarioRepository.save(solicitado);

    }
}
