package miranda.sergio.comercio.service;

import miranda.sergio.comercio.dto.FiltroPesquisa;
import miranda.sergio.comercio.dto.Loja;
import miranda.sergio.comercio.dto.LojaRespostaDTO;
import miranda.sergio.comercio.repository.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService {

    private final LojaRepository repository;

    public LojaService(LojaRepository repository) {
        this.repository = repository;
    }

    public List<LojaRespostaDTO> pesquisarPorNome(FiltroPesquisa filtro) {
        return repository.findByNomeContainingIgnoreCase(filtro.getNome())
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private LojaRespostaDTO toDTO(Loja loja) {

        LojaRespostaDTO dto = new LojaRespostaDTO();

        dto.setId(loja.getId());
        dto.setNome(loja.getNome());
        dto.setEndereco(loja.getEndereco());
        dto.setBairro(loja.getBairro());
        dto.setCategoria(loja.getCategoria());

        return dto;
    }
}
