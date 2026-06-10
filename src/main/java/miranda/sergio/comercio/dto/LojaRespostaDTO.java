package miranda.sergio.comercio.dto;

import lombok.Getter;
import lombok.Setter;
import miranda.sergio.comercio.enums.Categoria;

@Getter
@Setter
public class LojaRespostaDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String bairro;
    private String instagram;
    private String telefone;
    private Categoria categoria;
}
