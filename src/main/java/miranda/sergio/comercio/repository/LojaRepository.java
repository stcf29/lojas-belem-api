package miranda.sergio.comercio.repository;

import miranda.sergio.comercio.dto.Loja;
import miranda.sergio.comercio.enums.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface LojaRepository extends JpaRepository<Loja, Long> {

    @Query("""
    SELECT DISTINCT l
    FROM Loja l
    LEFT JOIN l.tags t
    WHERE
    LOWER(l.nome) LIKE LOWER(CONCAT('%', :texto, '%'))
    OR
    LOWER(t.nome) LIKE LOWER(CONCAT('%', :texto, '%'))
    """)
    List<Loja> pesquisar(@Param("texto") String texto);


    @Query("""
    SELECT DISTINCT l
    FROM Loja l
    LEFT JOIN l.tags t
    WHERE
    (
        LOWER(l.nome) LIKE LOWER(CONCAT('%', :texto, '%'))
        OR LOWER(t.nome) LIKE LOWER(CONCAT('%', :texto, '%'))
    )
    AND l.categoria = :categoria
    """)
    List<Loja> pesquisarPorTextoECategoria(
            @Param("texto") String texto,
            @Param("categoria") Categoria categoria);

    List<Loja> findByCategoria(Categoria categoria);

}