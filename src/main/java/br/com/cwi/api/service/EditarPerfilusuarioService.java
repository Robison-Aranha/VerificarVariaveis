package br.com.cwi.api.service;


import br.com.cwi.api.controller.request.EditarPerfilUsuarioRequest;
import br.com.cwi.api.domain.PerfilUsuario;
import br.com.cwi.api.repository.PerfilUsuarioRepository;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EditarPerfilusuarioService {

    @Autowired
    PerfilUsuarioRepository perfilUsuarioRepository;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    public void editar(EditarPerfilUsuarioRequest request) {

        Usuario usuario = buscarUsuarioService.porId(Long.valueOf(request.getIdUsuario()));

        if (Objects.isNull(usuario.getPerfilUsuario())){
            usuario.setPerfilUsuario(new PerfilUsuario());
        }

        PerfilUsuario perfil = usuario.getPerfilUsuario();

        perfil.setImagemPerfil(request.getImagemPerfil());
        perfil.setApelido(request.getApelido());
        perfil.setDescricao(request.getDescricao());
        perfil.setIdade(request.getIdade());
        perfil.setUsuario(usuario);

        perfilUsuarioRepository.save(perfil);

    }
}
