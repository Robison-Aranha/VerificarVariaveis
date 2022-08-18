package br.com.cwi.api.service;


import br.com.cwi.api.controller.response.UsuarioListaResponse;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.ListarTodosUsuarioMapper;
import br.com.cwi.api.mapper.ListarUsuarioMapper;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarAmigosService {


    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    public Page<UsuarioListaResponse> listar(Long id, String nome, Pageable pageable) {

        Usuario usuario = buscarUsuarioService.porId(id);

        return usuarioRepository.findAmigos(id, nome, pageable).map(ListarTodosUsuarioMapper::toResponse);

    }
}
