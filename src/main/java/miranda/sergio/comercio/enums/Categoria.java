package miranda.sergio.comercio.enums;

import lombok.Getter;

@Getter
public enum Categoria {
    ELETRONICOS("Eletrônicos"),
    ROUPAS("Roupas"),
    MODA_INTIMA("Moda Íntima"),
    CALCADOS("Calçados"),
    JOALHERIA("Joalheria"),
    PAPELARIA("Papelaria"),
    FARMACIA("Farmácia"),
    INFORMATICA("Informática"),
    COSMETICOS("Cosmético"),
    UTILIDADES("Utilidades"),
    ALIMENTACAO("Alimentação"),
    CASA("Casa e Decoração"),
    CONSTRUCAO("Construção");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

}
