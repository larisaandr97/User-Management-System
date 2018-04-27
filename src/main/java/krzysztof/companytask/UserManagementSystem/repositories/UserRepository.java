package krzysztof.companytask.UserManagementSystem.repositories;

import krzysztof.companytask.UserManagementSystem.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
