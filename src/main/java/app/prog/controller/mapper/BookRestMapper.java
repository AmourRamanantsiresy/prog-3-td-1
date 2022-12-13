package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.model.CategoryEntity;
import app.prog.service.AuthorService;
import app.prog.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookRestMapper {

  private AuthorService authorService;
  private CategoryService categoryService;

  public BookResponse toRest(BookEntity domain) {
    AuthorEntity author = domain.getAuthor();
    List<CategoryEntity> category = domain.getCategory() != null
      ? domain.getCategory()
      : null;

    return BookResponse
      .builder()
      .id(domain.getId())
      .title(domain.getTitle())
      .author(author != null ? author.getName() : null)
      .hasAuthor(domain.hasAuthor())
      .category(category)
      .build();
  }

  public BookEntity toDomain(CreateBookResponse rest) {
    AuthorEntity author = rest.getAuthor() != null
      ? authorService.getByName(rest.getAuthor())
      : null;
    List<CategoryEntity> category = getAllCategory(rest.getCategory());

    return BookEntity
      .builder()
      .author(author != null ? author : null)
      .title(rest.getTitle())
      .category(category)
      .pageNumber(0) //Constraint not null in database, default value is 0
      .build();
  }

  public BookEntity toDomain(UpdateBookResponse rest) {
    AuthorEntity author = rest.getAuthor() != null
      ? authorService.getByName(rest.getAuthor())
      : null;

    return BookEntity
      .builder()
      .id(rest.getId())
      .author(author != null ? author : null)
      .title(rest.getTitle())
      .pageNumber(0) //Constraint not null in database, default value is 0
      .build();
  }

  private List<CategoryEntity> getAllCategory(List<String> categories) {
    if (categories == null) return null;
    List<CategoryEntity> categoryEntities = new ArrayList<>();
    categories.forEach(e -> categoryEntities.add(categoryService.getByName(e)));
    return categoryEntities;
  }
}
