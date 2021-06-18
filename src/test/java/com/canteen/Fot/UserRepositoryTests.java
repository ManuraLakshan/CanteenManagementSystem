package com.canteen.Fot;

import com.canteen.Fot.entity.User;
import com.canteen.Fot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("murugeshsujan22@gmail.com");
        user.setPassword("sujan123");
        user.setFirstName("Murugesh");
        user.setLastName("Sujan");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class,savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail() {
        String email = "murugeshsujan22@gmail.com";
        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();
    }

}
