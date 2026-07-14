package miranda.sergio.comercio.service;

import miranda.sergio.comercio.dto.FiltroPesquisa;
import miranda.sergio.comercio.dto.Loja;
import miranda.sergio.comercio.dto.LojaRespostaDTO;
import miranda.sergio.comercio.dto.Tag;
import miranda.sergio.comercio.repository.LojaRepository;
import miranda.sergio.comercio.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LojaService {

    private final LojaRepository repository;
    private final TagRepository tagRepository;

    public LojaService(LojaRepository repository, TagRepository tagRepository) {
        this.repository = repository;
        this.tagRepository = tagRepository;
    }

    public List<Loja> pesquisar(FiltroPesquisa filtro) {
        boolean temTexto = filtro.getNome() != null && !filtro.getNome().isBlank();
        boolean temCategoria = filtro.getCategoria() != null;

        if (temTexto && temCategoria) {
            return repository.pesquisarPorTextoECategoria(filtro.getNome(), filtro.getCategoria());
        }

        if (temTexto) {
            return repository.pesquisar(filtro.getNome());
        }

        if (temCategoria) {
            return repository.findByCategoria(filtro.getCategoria());
        }

        return repository.findAll();
    }

    public Loja salvar(Loja loja) {
        List<Tag> tags = new ArrayList<>();

        for (Tag tag : loja.getTags()) {
            Tag existente = tagRepository.findByNomeIgnoreCase(tag.getNome()).orElseGet(() -> tagRepository.save(tag));
            tags.add(existente);
        }

        loja.setTags(tags);
        return repository.save(loja);
    }

    public void salvarLote(List<Loja> lojasDTO) {
        List<Loja> lojas = lojasDTO.stream().map(this::converter).toList();
        repository.saveAll(lojas);
    }

    private Loja converter(Loja dto) {
        Loja loja = new Loja();
        loja.setNome(dto.getNome());
        loja.setEndereco(dto.getEndereco());
        loja.setNumero(dto.getNumero());
        loja.setComplemento(dto.getComplemento());
        loja.setBairro(dto.getBairro());
        loja.setCep(dto.getCep());
        loja.setTelefone(dto.getTelefone());
        loja.setWhatsapp(dto.getWhatsapp());
        loja.setEmail(dto.getEmail());
        loja.setInstagram(dto.getInstagram());
        loja.setCategoria(dto.getCategoria());
        loja.setLatitude(dto.getLatitude());
        loja.setLongitude(dto.getLongitude());
        loja.setTags(dto.getTags());
        return loja;
    }

    public List<Loja> listar() {
        return repository.findAll();
    }
}
