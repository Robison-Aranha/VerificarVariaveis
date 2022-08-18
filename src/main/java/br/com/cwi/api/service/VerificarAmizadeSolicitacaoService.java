package br.com.cwi.api.service;


import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificarAmizadeSolicitacaoService {

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    public Integer verificar(Long id, IdRequest request) {

        Usuario usuario1 = buscarUsuarioService.porId(id);

        Usuario usuario2 = buscarUsuarioService.porId(request.getId());

        if (usuario1.getAmigos().indexOf(usuario2) != -1){
            return 0;
        }

        if (usuario2.getAmigos().indexOf(usuario1) != -1){
            return 0;
        }

        if (usuario1.getSolicitacoes().indexOf(usuario2) != -1){
            return 1;
        }

        if (usuario2.getSolicitacoes().indexOf(usuario1) != -1){
            return 1;
        }

        return 2;
    }
}
