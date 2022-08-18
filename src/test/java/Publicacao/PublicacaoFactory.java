package Publicacao;

import br.com.cwi.api.domain.Publicacao;

public class PublicacaoFactory {

    public static Publicacao getPublicacao(){

        Long id = Long.valueOf(4);

        return Publicacao.builder()
                .id(id)
                .descricao("abacate")
                .imagemPublicacao("http://batata.com")
                .build();
    }

}
