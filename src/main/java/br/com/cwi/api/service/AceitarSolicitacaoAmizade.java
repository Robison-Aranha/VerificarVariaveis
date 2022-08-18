package br.com.cwi.api.service;


import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AceitarSolicitacaoAmizade {

    @Autowired
    BuscarUsuarioService buscarUsuarioService;


    @Autowired
    UsuarioRepository usuarioRepository;


    public void aceitar(Long id, IdRequest request) {

        Usuario usuario = buscarUsuarioService.porId(id);

        Usuario amigo = buscarUsuarioService.porId(request.getId());

        if (usuario.getSolicitacoes().indexOf(amigo) == -1){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Esse usuario não lhe enviou nenhuma solicitacao!");
        }

        usuario.retirarSolicitacao(amigo);

        usuario.adicionarAmigo(amigo);

        usuarioRepository.save(usuario);

    }
}
