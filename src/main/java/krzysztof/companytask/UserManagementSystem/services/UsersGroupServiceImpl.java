package krzysztof.companytask.UserManagementSystem.services;

import krzysztof.companytask.UserManagementSystem.commands.UsersGroupCommand;
import krzysztof.companytask.UserManagementSystem.converters.UsersGroupCommandToUsersGroup;
import krzysztof.companytask.UserManagementSystem.converters.UsersGroupToUsersGroupCommand;
import krzysztof.companytask.UserManagementSystem.domain.UsersGroup;
import krzysztof.companytask.UserManagementSystem.repositories.UsersGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UsersGroupServiceImpl implements UsersGroupService {

    private UsersGroupRepository usersGroupRepository;
    private UsersGroupToUsersGroupCommand usersGroupToUsersGroupCommand;
    private UsersGroupCommandToUsersGroup usersGroupCommandToUsersGroup;

    public UsersGroupServiceImpl(UsersGroupRepository usersGroupRepository, UsersGroupToUsersGroupCommand usersGroupToUsersGroupCommand, UsersGroupCommandToUsersGroup usersGroupCommandToUsersGroup) {
        this.usersGroupRepository = usersGroupRepository;
        this.usersGroupToUsersGroupCommand = usersGroupToUsersGroupCommand;
        this.usersGroupCommandToUsersGroup = usersGroupCommandToUsersGroup;
    }

    @Override
    public Set<UsersGroup> getUsersGroup() {
        Set<UsersGroup> usersGroups = new HashSet<>();
        usersGroupRepository.findAll().iterator().forEachRemaining(usersGroups::add);
        return usersGroups;
    }

    @Override
    public UsersGroup findById(Long id) {
        Optional<UsersGroup> optionalUser = usersGroupRepository.findById(id);
        if (!optionalUser.isPresent()){
            throw new RuntimeException("User with id: "+String.valueOf(id)+ "was not found.");
        }
        return optionalUser.get();
    }

    @Override
    public UsersGroupCommand findGroupsCommandById(Long id){
        return usersGroupToUsersGroupCommand.convert(findById(id));
    }

    @Override
    public void deleteUsersGroupById(Long id) {
        usersGroupRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UsersGroupCommand saveUsersGroupCommand(UsersGroupCommand userCommand) {
        UsersGroup detachedUser = usersGroupCommandToUsersGroup.convert(userCommand);
        UsersGroup savedUser = usersGroupRepository.save(detachedUser);
        return usersGroupToUsersGroupCommand.convert(savedUser);
    }
}
