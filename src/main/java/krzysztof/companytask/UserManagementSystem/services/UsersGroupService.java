package krzysztof.companytask.UserManagementSystem.services;

import krzysztof.companytask.UserManagementSystem.commands.UserCommand;
import krzysztof.companytask.UserManagementSystem.commands.UsersGroupCommand;
import krzysztof.companytask.UserManagementSystem.domain.User;
import krzysztof.companytask.UserManagementSystem.domain.UsersGroup;

import java.util.Set;

public interface UsersGroupService {
    Set<UsersGroup> getUsersGroup();
    UsersGroup findById(Long id);

    UsersGroupCommand findGroupsCommandById(Long id);

    void deleteUsersGroupById(Long id);
    UsersGroupCommand saveUsersGroupCommand(UsersGroupCommand userCommand);
}
