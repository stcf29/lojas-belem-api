package miranda.sergio.comercio.controller;

import miranda.sergio.comercio.dto.FiltroPesquisa;
import miranda.sergio.comercio.dto.Loja;
import miranda.sergio.comercio.dto.LojaRespostaDTO;
import miranda.sergio.comercio.enums.Categoria;
import miranda.sergio.comercio.repository.LojaRepository;
import miranda.sergio.comercio.service.LojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comercios")
public class LojaController {

    private final LojaService service;
    private final LojaRepository repository;

    public LojaController(LojaService service, LojaRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("/pesquisarLojas")
    public ResponseEntity<List<LojaRespostaDTO>> pesquisar(@RequestBody FiltroPesquisa filtro) {
        return ResponseEntity.ok(service.pesquisarPorNome(filtro));
    }

    @GetMapping("/listCategorias")
    public Categoria[] listarCategorias() {
        return Categoria.values();
    }

    @PostMapping("/adicionarLoja")
    public Loja salvar(@RequestBody Loja loja) {
        return repository.save(loja);
    }
}
