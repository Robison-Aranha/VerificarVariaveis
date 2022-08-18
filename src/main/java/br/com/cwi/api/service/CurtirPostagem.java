package br.com.cwi.api.service;


import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.domain.Publicacao;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtirPostagem {

    @Autowired
    BuscarPublicacaoService buscarPublicacaoService;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    @Autowired
    PublicacaoRepository publicacaoRepository;

    public void curtir(Long id, IdRequest request) {

        Publicacao publicacao = buscarPublicacaoService.porId(request.getId());

        Usuario usuario = buscarUsuarioService.porId(id);

        if (publicacao.getCurtidasUsuarios().indexOf(usuario) != -1){
            publicacao.desfazerCurtida(usuario);
        }
        else {
            publicacao.adicionarCurtida(usuario);
        }

        publicacaoRepository.save(publicacao);
    }
}
