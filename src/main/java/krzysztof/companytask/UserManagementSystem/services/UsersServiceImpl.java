package krzysztof.companytask.UserManagementSystem.services;

import javassist.NotFoundException;
import krzysztof.companytask.UserManagementSystem.domain.User;
import krzysztof.companytask.UserManagementSystem.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    private UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> getUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()){
//            throw new NotFoundException("User with id: "+String.valueOf(id)+ "was not found.");
            System.out.println("User with id: "+String.valueOf(id)+ "was not found.");
        }
        return optionalUser.get();
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
