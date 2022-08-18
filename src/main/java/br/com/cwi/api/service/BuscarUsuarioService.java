package br.com.cwi.api.service;


import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario porId(Long idUsuario) {

        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum usuario encontrado para este id!"));

    }
}
