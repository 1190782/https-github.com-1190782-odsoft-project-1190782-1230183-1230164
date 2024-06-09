package pt.psoft.g1.psoftg1.bookmanagement.services;


import pt.psoft.g1.psoftg1.bookmanagement.model.Book;

import java.util.List;

/**
 *
 */
public interface BookService {
    Book create(CreateBookRequest request, String isbn);
    Book save(Book book);
    Book findByIsbn(String isbn);
    Book update(UpdateBookRequest request, String currentVersion);
    List<Book> findByGenre(String genre);
    List<Book> findByTitle(String title);
    List<BookCountDTO> findTop5BooksLent();
    Book removeBookPhoto(String isbn, long desiredVersion);
    List<Book> getBooksSuggestionsForReader(String readerNumber);
}
