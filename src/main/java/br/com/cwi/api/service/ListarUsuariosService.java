package br.com.cwi.api.service;


import br.com.cwi.api.controller.response.UsuarioListaResponse;
import br.com.cwi.api.mapper.ListarTodosUsuarioMapper;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarUsuariosService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Page<UsuarioListaResponse> listar(String nome, Pageable pageable, Long id) {

        return usuarioRepository.findUsuarios(id, nome, pageable)
                .map(ListarTodosUsuarioMapper::toResponse);

    }
}
