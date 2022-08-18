package br.com.cwi.api.service;


import br.com.cwi.api.controller.response.UsuarioDetalharResponse;
import br.com.cwi.api.domain.PerfilUsuario;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.DetalharPerfilUsuarioMapper;
import br.com.cwi.api.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class DetalharPerfilUsuarioService {


    @Autowired
    PerfilUsuarioRepository perfilUsuarioRepository;


    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    public UsuarioDetalharResponse detalhar(Long id) {

        Usuario usuario = buscarUsuarioService.porId(id);

        PerfilUsuario perfilUsuario = usuario.getPerfilUsuario();

        if (Objects.isNull(perfilUsuario)){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não ha perfil ainda!");
        }

        UsuarioDetalharResponse response = DetalharPerfilUsuarioMapper.toResponse(perfilUsuario);

        return response;
    }
}
