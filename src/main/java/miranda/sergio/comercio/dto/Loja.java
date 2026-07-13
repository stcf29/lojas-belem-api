package miranda.sergio.comercio.dto;

import jakarta.persistence.*;
import lombok.Data;
import miranda.sergio.comercio.enums.Categoria;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "loja")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;

    private String telefone;

    private String whatsapp;

    private String email;

    private String instagram;

    private Categoria categoria;

    private Double latitude;

    private Double longitude;

    private Boolean destaque;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "loja_tags",
            joinColumns = @JoinColumn(name = "loja_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();
}
