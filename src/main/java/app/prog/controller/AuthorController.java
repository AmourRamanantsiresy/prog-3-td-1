package app.prog.controller;

import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthorResponse;
import app.prog.controller.response.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.service.AuthorService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

  private final AuthorService service;
  private final AuthorRestMapper mapper;

  @GetMapping("")
  public List<AuthorResponse> getAll() {
    return service.getAll().stream().map(mapper::toRest).toList();
  }

  @PutMapping("")
  public List<AuthorEntity> updateAll(List<UpdateAuthorResponse> authors) {
    List<AuthorEntity> authorEntity = authors
      .stream()
      .map(mapper::toDomain)
      .toList();
    return service.saveAll(authorEntity);
  }

  @PostMapping("")
  public List<AuthorEntity> saveAll(List<CreateAuthorResponse> authors) {
    List<AuthorEntity> authorEntity = authors
      .stream()
      .map(mapper::toDomain)
      .toList();
    return service.saveAll(authorEntity);
  }

  @DeleteMapping("/{authorId}")
  public AuthorResponse deleteAuthor(@PathVariable int authorId) {
    return mapper.toRest(service.deleteAuthor(authorId));
  }
}
