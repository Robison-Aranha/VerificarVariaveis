package br.com.cwi.api.service;


import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesfazerAmizade {

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    public void desfazer(Long id, IdRequest request) {

        Usuario usuario = buscarUsuarioService.porId(id);

        Usuario amigo = buscarUsuarioService.porId(request.getId());

        usuario.desfazerAmizade(amigo);

        usuarioRepository.save(usuario);
    }
}
