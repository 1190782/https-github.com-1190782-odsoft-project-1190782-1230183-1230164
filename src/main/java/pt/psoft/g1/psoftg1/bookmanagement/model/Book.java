package pt.psoft.g1.psoftg1.bookmanagement.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.StaleObjectStateException;
import pt.psoft.g1.psoftg1.authormanagement.model.Author;
import pt.psoft.g1.psoftg1.bookmanagement.services.UpdateBookRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Book", uniqueConstraints = {
        @UniqueConstraint(name = "uc_book_isbn", columnNames = {"ISBN"})
})
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long pk;

    @Version
    @Getter
    private Long version;

    @Getter
    @Embedded
    Isbn isbn;

    @Getter
    @Embedded
    @NotNull
    Title title;

    @Getter
    @ManyToOne
    @NotNull
    Genre genre;

    @Getter
    @ManyToMany
    private List<Author> authors = new ArrayList<>();

    @Embedded
    Description description;

    private void setTitle(String title) {this.title = new Title(title);}

    private void setIsbn(String isbn) {
        this.isbn = new Isbn(isbn);
    }

    private void setDescription(String description) {this.description = new Description(description); }

    private void setGenre(Genre genre) {this.genre = genre; }

    private void setAuthors(List<Author> authors) {this.authors = authors; }

    public Optional<Description> getDescription(){ return Optional.ofNullable(description); }

    public Book(String isbn, String title, String description, Genre genre, List<Author> authors) {
        setTitle(title);
        setIsbn(isbn);
        if(description != null)
            setDescription(description);
        if(genre==null)
            throw new IllegalArgumentException("Genre cannot be null");
        setGenre(genre);
        if(authors == null)
            throw new IllegalArgumentException("Author list is null");
        if(authors.isEmpty())
            throw new IllegalArgumentException("Author list is empty");

        setAuthors(authors);
    }

    protected Book() {
        // got ORM only
    }

    public void applyPatch(final Long desiredVersion, UpdateBookRequest request) {
        if (this.version != desiredVersion)
            throw new StaleObjectStateException("Object was already modified by another user", this.pk);

        String title = request.getTitle();
        String description = request.getDescription();
        Genre genre = request.getGenreObj();
        List<Author> authors = request.getAuthorObjList();
        if(title != null) {
            setTitle(title);
        }

        if(description != null) {
            setDescription(description);
        }

        if(genre != null) {
            setGenre(genre);
        }

        if(authors != null) {
            setAuthors(authors);
        }
    }
}
