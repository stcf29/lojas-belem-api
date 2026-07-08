package miranda.sergio.comercio.controller;

import miranda.sergio.comercio.dto.FiltroPesquisa;
import miranda.sergio.comercio.dto.FormFaleConosco;
import miranda.sergio.comercio.dto.Loja;
import miranda.sergio.comercio.dto.LojaRespostaDTO;
import miranda.sergio.comercio.enums.Categoria;
import miranda.sergio.comercio.repository.LojaRepository;
import miranda.sergio.comercio.service.ContatoService;
import miranda.sergio.comercio.service.LojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/lojas")
public class LojaController {

    private final LojaService service;
    private final ContatoService contatoService;
    private final LojaRepository repository;

    public LojaController(LojaService service, LojaRepository repository, ContatoService contatoService) {
        this.service = service;
        this.repository = repository;
        this.contatoService = contatoService;
    }

    @PostMapping("/pesquisarLojas")
    public ResponseEntity<List<Loja>> pesquisar(@RequestBody FiltroPesquisa filtro) {
        return ResponseEntity.ok(service.pesquisar(filtro));
    }

    @GetMapping("/listCategorias")
    public Categoria[] listarCategorias() {
        return Categoria.values();
    }

    @PostMapping("/adicionarLoja")
    public Loja salvar(@RequestBody Loja loja) {
        return repository.save(loja);
    }

    @PostMapping("/faleConosco")
    public ResponseEntity<Void> enviar(@RequestBody FormFaleConosco form) {
        contatoService.enviarEmail(form);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/lote")
    public ResponseEntity<Void> cadastrarLote(@RequestBody List<Loja> lojas) {
        service.salvarLote(lojas);
        return ResponseEntity.ok().build();
    }
}
