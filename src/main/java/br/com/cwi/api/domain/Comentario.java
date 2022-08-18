package br.com.cwi.api.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Comentario {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String comentario;

    @Column(name = "data_postagem")
    private LocalDateTime dataPostagem;

    @ManyToOne
    @JoinColumn(name = "id_publicacao")
    private Publicacao publicacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioComentario;
}
