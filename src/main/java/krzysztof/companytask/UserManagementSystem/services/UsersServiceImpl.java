package krzysztof.companytask.UserManagementSystem.services;

import krzysztof.companytask.UserManagementSystem.commands.UserCommand;
import krzysztof.companytask.UserManagementSystem.converters.UserCommandToUser;
import krzysztof.companytask.UserManagementSystem.converters.UserToUserCommand;
import krzysztof.companytask.UserManagementSystem.domain.User;
import krzysztof.companytask.UserManagementSystem.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    private UserRepository userRepository;
    private UserToUserCommand userToUserCommand;
    private UserCommandToUser userCommandToUser;

    public UsersServiceImpl(UserRepository userRepository, UserToUserCommand userToUserCommand, UserCommandToUser userCommandToUser) {
        this.userRepository = userRepository;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
    }

    @Override
    public Set<User> getUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()){
            throw new RuntimeException("User with id: "+String.valueOf(id)+ "was not found.");
        }
        return optionalUser.get();
    }

    @Override
    public UserCommand findCommandById(Long id){
        return userToUserCommand.convert(findById(id));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserCommand saveUserCommand(UserCommand userCommand) {
        User detachedUser = userCommandToUser.convert(userCommand);
        User savedUser = userRepository.save(detachedUser);
        return userToUserCommand.convert(savedUser);
    }
}
