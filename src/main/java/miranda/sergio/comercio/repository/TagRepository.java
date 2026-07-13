package miranda.sergio.comercio.repository;

import miranda.sergio.comercio.dto.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByNomeIgnoreCase(String nome);
}
