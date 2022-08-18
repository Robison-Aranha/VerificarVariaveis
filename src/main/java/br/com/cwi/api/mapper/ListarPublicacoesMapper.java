package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.ListarPublicacoesResponse;
import br.com.cwi.api.domain.Publicacao;

import java.time.format.DateTimeFormatter;

public class ListarPublicacoesMapper {
    public static ListarPublicacoesResponse toResponse(Publicacao entity) {
        return ListarPublicacoesResponse.builder()
                .descricao(entity.getDescricao())
                .imagem(entity.getImagemPublicacao())
                .curtidas(entity.getCurtidas())
                .id(entity.getId())
                .privado(entity.isPrivado())
                .idUsuario(entity.getUsuarioPostagem().getId())
                .dataPostagem(entity.getDataPostagem().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .fotoUsuario(entity.getUsuarioPostagem().getPerfilUsuario().getImagemPerfil())
                .build();
    }
}
