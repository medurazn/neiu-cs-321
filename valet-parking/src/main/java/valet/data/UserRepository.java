package valet.data;

import org.springframework.data.repository.CrudRepository;
import valet.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
