package pt.psoft.g1.psoftg1.authormanagement.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pt.psoft.g1.psoftg1.authormanagement.model.Author;
import pt.psoft.g1.psoftg1.authormanagement.repositories.AuthorRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AuthorRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AuthorRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Author alex = new Author("Alex", "O Alex escreveu livros");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        List<Author> list = employeeRepository.findByName(alex.getName());

        // then
        assertThat(list.get(0).getName())
                .isEqualTo(alex.getName());
    }
}
