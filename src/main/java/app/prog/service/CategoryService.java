package app.prog.service;

import app.prog.model.CategoryEntity;
import app.prog.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class CategoryService {

  private CategoryRepository repository;

  public CategoryEntity getByName(String name) {
    return repository.findByName(name);
  }
}
