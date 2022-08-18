package br.com.cwi.api.domain;


import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String descricao;

    private String apelido;

    private Integer idade;


    @Column(name = "imagem_perfil")
    private String imagemPerfil;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
