package br.com.cwi.api.mapper;


import br.com.cwi.api.controller.response.UsuarioDetalharResponse;
import br.com.cwi.api.domain.PerfilUsuario;
import br.com.cwi.api.domain.Usuario;

public class DetalharPerfilUsuarioMapper {
    public static UsuarioDetalharResponse toResponse(PerfilUsuario entity) {
        UsuarioDetalharResponse response = new UsuarioDetalharResponse();

        response.setImagemPerfil(entity.getImagemPerfil());
        response.setDescricao(entity.getDescricao());
        response.setIdade(entity.getIdade());
        response.setEmail(entity.getUsuario().getEmail());
        response.setNome(entity.getUsuario().getNome());
        response.setApelido(entity.getApelido());

        return response;
    }
}
