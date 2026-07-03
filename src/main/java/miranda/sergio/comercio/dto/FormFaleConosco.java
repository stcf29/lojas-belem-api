package miranda.sergio.comercio.dto;


import lombok.Getter;
import lombok.Setter;
import miranda.sergio.comercio.enums.Categoria;

@Getter
@Setter
public class FormFaleConosco {
    private String nome;
    private String email;
    private String telefone;
    private String assunto;
    private String mensagem;

}
