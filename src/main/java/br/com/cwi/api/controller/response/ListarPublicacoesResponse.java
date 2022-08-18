package br.com.cwi.api.controller.response;


import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListarPublicacoesResponse {

    private Long id;

    private String descricao;

    private boolean privado;

    private String imagem;

    private Integer curtidas;

    private Long idUsuario;

    private String dataPostagem;

    private String fotoUsuario;
}
