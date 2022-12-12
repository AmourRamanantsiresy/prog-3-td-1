package app.prog.controller.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CreateAuthorResponse {
    private String name;
    private String particularity;
    private LocalDate birthDate;
}
