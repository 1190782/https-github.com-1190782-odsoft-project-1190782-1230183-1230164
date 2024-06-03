package pt.psoft.g1.psoftg1.authormanagement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pt.psoft.g1.psoftg1.authormanagement.model.Author;
import pt.psoft.g1.psoftg1.authormanagement.repositories.AuthorRepository;
import pt.psoft.g1.psoftg1.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repo;
    private final AuthorMapper mapper;
    @Override
    public Iterable<Author> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Author> findByAuthorNumber(final Long authorNumber) {
        return repo.findByAuthorNumber(authorNumber);
    }

    @Override
    public List<Author> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Author create(final CreateAuthorRequest resource) {
        final Author author = mapper.create(resource);
        return repo.save(author);
    }

    @Override
    public Author partialUpdate(final Long authorNumber, final UpdateAuthorRequest resource, final long desiredVersion) {
        // first let's check if the object exists so we don't create a new object with
        // save
        final var author = findByAuthorNumber(authorNumber)
                .orElseThrow(() -> new NotFoundException("Cannot update an object that does not yet exist"));

        // since we got the object from the database we can check the version in memory
        // and apply the patch
        author.applyPatch(desiredVersion, resource.getName(),resource.getBio());

        // in the meantime some other user might have changed this object on the
        // database, so concurrency control will still be applied when we try to save
        // this updated object
        return repo.save(author);
    }
    @Override
    public List<Author> findTopAuthorByLendings() {
        Pageable pageableRules = PageRequest.of(0,5);
        return repo.findTopAuthorByLendings(pageableRules).getContent();
    }
}
