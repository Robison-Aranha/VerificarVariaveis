package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.ListarComentariosResponse;
import br.com.cwi.api.domain.Comentario;

import java.time.format.DateTimeFormatter;

public class ListarComentariosMapper {

    public static ListarComentariosResponse toResponse(Comentario entity) {
        return ListarComentariosResponse.builder()
                .imagemUsuario(entity.getUsuarioComentario().getPerfilUsuario().getImagemPerfil())
                .comentario(entity.getComentario())
                .dataPostagem(entity.getDataPostagem().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .IdUsuario(entity.getUsuarioComentario().getId())
                .id(entity.getId())
                .build();
    }
}
