package br.com.cwi.api.mapper;


import br.com.cwi.api.controller.response.UsuarioListaResponse;
import br.com.cwi.api.domain.PerfilUsuario;
import br.com.cwi.api.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public class ListarUsuarioMapper {


    public static UsuarioListaResponse toResponse(PerfilUsuario entity) {

        return UsuarioListaResponse.builder()
                .apelido(entity.getApelido())
                .idade(entity.getIdade())
                .id(entity.getUsuario().getId())
                .nome(entity.getUsuario().getNome())
                .imagemPerfil(entity.getImagemPerfil())
                .build();


    }
}
