package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class AuthorService {

  private AuthorRepository repository;

  public AuthorEntity getByName(String name) {
    return repository.findByName(name);
  }

  public List<AuthorEntity> getAll() {
    return repository.findAllByOrderByBirthDateDesc();
  }

  public List<AuthorEntity> saveAll(List<AuthorEntity> authors) {
    return repository.saveAll(authors);
  }

  public AuthorEntity deleteAuthor(int AuthorEntityId) {
    Optional<AuthorEntity> optional = repository.findById(
      String.valueOf(AuthorEntityId)
    );
    if (optional.isPresent()) {
      repository.delete(optional.get());
      return optional.get();
    } else {
      throw new RuntimeException(
        "AuthorEntity." + AuthorEntityId + " not found"
      );
    }
  }
}
