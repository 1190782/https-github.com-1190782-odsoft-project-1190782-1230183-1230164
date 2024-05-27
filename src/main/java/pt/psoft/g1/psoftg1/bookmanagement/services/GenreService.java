package pt.psoft.g1.psoftg1.bookmanagement.services;


import pt.psoft.g1.psoftg1.bookmanagement.model.Book;
import pt.psoft.g1.psoftg1.bookmanagement.model.Genre;
import pt.psoft.g1.psoftg1.bookmanagement.model.GenreBookCountDTO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface GenreService {

    Iterable<Genre> findAll();

    Genre save(Genre genre);

    Optional<Genre> findByString(String name);

    List<GenreBookCountDTO> findTopGenreByBooks();
}
