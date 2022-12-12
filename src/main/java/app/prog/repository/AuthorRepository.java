package app.prog.repository;

import app.prog.model.AuthorEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, String> {
  public AuthorEntity findByName(String name);

  public List<AuthorEntity> findAllOrderByBirth_dateAsc();
}
