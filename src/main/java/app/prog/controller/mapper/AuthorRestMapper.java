package app.prog.controller.mapper;

import org.springframework.stereotype.Component;

import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthorResponse;
import app.prog.controller.response.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;

@Component
public class AuthorRestMapper {
    public AuthorResponse toRest(AuthorEntity author) {
        return AuthorResponse.builder()
                .name(author.getName())
                .id(author.getId())
                .particularity(author.getParticularity())
                .hasParticularity(author.hasParticularity())
                .build();
    }

    public AuthorEntity toDomain(CreateAuthorResponse author) {
        return AuthorEntity.builder()
                .name(author.getName())
                .particularity(author.getParticularity())
                .birthDate(author.getBirthDate())
                .build();
    }

    public AuthorEntity toDomain(UpdateAuthorResponse author) {
        return AuthorEntity.builder()
                .name(author.getName())
                .particularity(author.getParticularity())
                .birthDate(author.getBirthDate())
                .id(author.getId())
                .build();
    }
}
