package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.UsuarioListaResponse;
import br.com.cwi.api.domain.Usuario;

public class ListarTodosUsuarioMapper {
    public static UsuarioListaResponse toResponse(Usuario entity) {

        return UsuarioListaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .idade(entity.getPerfilUsuario().getIdade())
                .apelido(entity.getPerfilUsuario().getApelido())
                .email(entity.getEmail())
                .imagemPerfil(entity.getPerfilUsuario().getImagemPerfil())
                .build();
    }
}
