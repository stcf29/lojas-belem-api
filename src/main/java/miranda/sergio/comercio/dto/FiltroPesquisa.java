package miranda.sergio.comercio.dto;

import lombok.Getter;
import lombok.Setter;
import miranda.sergio.comercio.enums.Categoria;

@Getter
@Setter
public class FiltroPesquisa {
    private String nome;;
    private Categoria categoria;
}
