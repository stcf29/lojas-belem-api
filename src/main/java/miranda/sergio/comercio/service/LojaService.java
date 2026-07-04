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

        return loja;
    }


}
