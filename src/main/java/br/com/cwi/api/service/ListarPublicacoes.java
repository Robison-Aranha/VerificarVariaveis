package br.com.cwi.api.service;


import br.com.cwi.api.controller.response.ListarPublicacoesResponse;
import br.com.cwi.api.domain.Publicacao;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.ListarPublicacoesMapper;
import br.com.cwi.api.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPublicacoes {

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    public Page<ListarPublicacoesResponse> listar(Long id, Pageable pageable) {

        Usuario usuario = buscarUsuarioService.porId(id);

        return publicacaoRepository.findUsuariosPublicacoes(id, pageable).map(ListarPublicacoesMapper::toResponse);

    }
}
