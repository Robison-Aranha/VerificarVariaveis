package br.com.cwi.api.security.domain;

import br.com.cwi.api.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder @AllArgsConstructor
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Permissao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
