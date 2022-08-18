package br.com.cwi.api.controller.response;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDetalharResponse {


    private String nome;

    private String apelido;

    private String email;

    private Integer idade;

    private String descricao;

    private String imagemPerfil;

}
