package br.com.cwi.api.controller.response;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListarComentariosResponse {

    private String imagemUsuario;

    private Long id;

    private String dataPostagem;

    private String comentario;

    private Long IdUsuario;
}
