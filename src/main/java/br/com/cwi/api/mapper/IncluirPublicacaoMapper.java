package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.IncluirPublicacaoRequest;
import br.com.cwi.api.domain.Publicacao;

public class IncluirPublicacaoMapper {
    public static Publicacao toEntity(IncluirPublicacaoRequest request) {

        return Publicacao.builder()
                .descricao(request.getDescricao())
                .imagemPublicacao(request.getImagem())
                .privado(request.isPrivado())
                .build();

    }
}
