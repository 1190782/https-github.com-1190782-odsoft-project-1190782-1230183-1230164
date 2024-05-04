package pt.psoft.g1.psoftg1.authormanagement.infrastructure.repositories.impl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pt.psoft.g1.psoftg1.authormanagement.model.Author;
import pt.psoft.g1.psoftg1.authormanagement.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataAuthorRepository extends AuthorRepository, CrudRepository<Author, Long> {
    @Override
    Optional<Author> findByAuthorNumber(Long authorNumber);
    @Override
    @Query("SELECT a " +
            "FROM Author a " +
            "WHERE a.name.fullName = :name")
    Optional<Author> findByName(String name);
    @Override
    @Query("SELECT a " +
            "FROM Author a " +
            "WHERE a.name.fullName = :name")
    List<Author> searchByName(@Param("name") String name);

    @Override
    @Query("SELECT a " +
            "FROM Author a " +
            "WHERE a.authorNumber = :authorNumber")
    Author searchByAuthorNumber(@Param("authorNumber") Long authorNumber);


}
