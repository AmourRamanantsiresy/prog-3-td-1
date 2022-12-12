package app.prog.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String title;

  @ManyToOne
  @JoinColumn(
    name = "author_id",
    foreignKey = @ForeignKey(name = "fk_book_author")
  )
  private AuthorEntity author;

  private Integer pageNumber;
  private LocalDate releaseDate;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "book_category",
    joinColumns = {
      @JoinColumn(name = "book_id", foreignKey = @ForeignKey(name = "fk_book")),
    },
    inverseForeignKey = @ForeignKey(name = "fk_category")
  )
  private List<CategoryEntity> category;

  public boolean hasAuthor() {
    return author != null;
  }
}
