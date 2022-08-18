package br.com.cwi.api.controller.request;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IncluirPublicacaoRequest {

    @NotBlank
    private String descricao;

    @NotBlank
    private String imagem;

    private boolean privado;

}
