package br.com.cwi.api.service;


import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.controller.response.ListarPublicacoesResponse;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.ListarPublicacoesMapper;
import br.com.cwi.api.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPublicacoesPerfilService {

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    VerificarAmizadeSolicitacaoService verificarAmizadeSolicitacaoService;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    public Page<ListarPublicacoesResponse> listar(Long id, IdRequest request, Pageable pageable) {

        Integer verificacao = verificarAmizadeSolicitacaoService.verificar(id, request);

        Usuario usuario = buscarUsuarioService.porId(id);

        Usuario amigo = buscarUsuarioService.porId(request.getId());


        if (verificacao == 0) {
            return publicacaoRepository.findByUsuarioPostagemOrderByDataPostagemDesc(amigo, pageable).map(ListarPublicacoesMapper::toResponse);
        } else {
            return publicacaoRepository.findByUsuarioPostagemAndPrivadoOrderByDataPostagemDesc(amigo, false, pageable).map(ListarPublicacoesMapper::toResponse);
        }
    }
}
