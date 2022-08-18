package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.EditarPerfilUsuarioRequest;
import br.com.cwi.api.domain.PerfilUsuario;

public class EditarPerfilusuarioMapper {
    public static PerfilUsuario toEntity(EditarPerfilUsuarioRequest request) {
        return PerfilUsuario.builder()
                .apelido(request.getApelido())
                .descricao(request.getDescricao())
                .idade(request.getIdade())
                .imagemPerfil(request.getImagemPerfil())
                .build();
    }
}
