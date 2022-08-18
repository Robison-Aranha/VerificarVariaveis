package br.com.cwi.api.controller.request;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class IncluirComentarioRequest {

    private Long idUsuario;

    private String Comentario;

}
