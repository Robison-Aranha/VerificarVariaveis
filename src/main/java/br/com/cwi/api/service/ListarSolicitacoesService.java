package br.com.cwi.api.service;




import br.com.cwi.api.controller.response.UsuarioListaResponse;
import br.com.cwi.api.mapper.ListarUsuarioMapper;
import br.com.cwi.api.repository.PerfilUsuarioRepository;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarSolicitacoesService {

    @Autowired
    PerfilUsuarioRepository perfilUsuarioRepository;

    public Page<UsuarioListaResponse> listar(Long id, Pageable pageable) {

       return perfilUsuarioRepository.findAllSolicitacoesUsuario(id, pageable).map(ListarUsuarioMapper::toResponse);

    }
}
