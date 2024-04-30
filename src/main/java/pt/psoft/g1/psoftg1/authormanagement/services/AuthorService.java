package pt.psoft.g1.psoftg1.authormanagement.services;

import pt.psoft.g1.psoftg1.authormanagement.services.UpdateAuthorRequest;
import pt.psoft.g1.psoftg1.authormanagement.model.Author;
import pt.psoft.g1.psoftg1.usermanagement.model.Name;

import java.util.Optional;

public interface AuthorService {

    Iterable<Author> findAll();

    Optional<Author> findOne(Name name);

    Author partialUpdate(Long authornumber, UpdateAuthorRequest resource, long parseLong);

    Author update(Long authornumber, UpdateAuthorRequest resource, long desiredVersion);

    Optional<Author> findOne(Long authorNumber);

    Author create(CreateAuthorRequest resource);

    Author save(Author author) throws Exception;

    /* VER DUVIDAS NO CONTROLLER, CONSOANTE VEREDITO APAGA-SE OU NAO*/
    /* |
       v  */
}