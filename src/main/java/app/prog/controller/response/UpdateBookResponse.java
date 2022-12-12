package app.prog.controller.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UpdateBookResponse {

  private int id;
  private String author;
  private String title;
  private List<String> category;
}
