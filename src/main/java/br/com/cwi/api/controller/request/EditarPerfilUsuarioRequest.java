package br.com.cwi.api.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EditarPerfilUsuarioRequest {

    @NotNull
    private int idUsuario;

    private String descricao;

    private String apelido;

    @NotNull
    private Integer idade;

    private String imagemPerfil;

}
