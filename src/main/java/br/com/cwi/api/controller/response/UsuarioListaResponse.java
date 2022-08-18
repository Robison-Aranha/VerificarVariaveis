package br.com.cwi.api.controller.response;


import lombok.*;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioListaResponse {

    private Long id;
    private String apelido;
    private String nome;
    private Integer idade;
    private String email;
    private String imagemPerfil;

}
