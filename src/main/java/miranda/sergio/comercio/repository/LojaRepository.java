package miranda.sergio.comercio.repository;

import miranda.sergio.comercio.dto.Loja;
import miranda.sergio.comercio.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LojaRepository extends JpaRepository<Loja, Long> {

    List<Loja> findByNomeContainingIgnoreCase(String nome);

    List<Loja> findByCategoria(Categoria categoria);
}