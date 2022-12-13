package app.prog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
