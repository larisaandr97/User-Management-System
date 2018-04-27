package krzysztof.companytask.UserManagementSystem.services;

import krzysztof.companytask.UserManagementSystem.commands.UserCommand;
import krzysztof.companytask.UserManagementSystem.domain.User;

import java.util.Set;

public interface UsersService {
    Set<User> getUsers();
    User findById(Long id);

    UserCommand findCommandById(Long id);

    void deleteUserById(Long id);
    UserCommand saveUserCommand(UserCommand userCommand);
}
