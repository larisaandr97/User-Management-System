package krzysztof.companytask.UserManagementSystem.converters;

import krzysztof.companytask.UserManagementSystem.commands.UserCommand;
import krzysztof.companytask.UserManagementSystem.commands.UsersGroupCommand;
import krzysztof.companytask.UserManagementSystem.domain.User;
import krzysztof.companytask.UserManagementSystem.domain.UsersGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UsersGroupCommandToUsersGroup implements Converter<UsersGroupCommand, UsersGroup> {

    @Override
    public UsersGroup convert(UsersGroupCommand source) {
        if (source == null) return null;

        UsersGroup usersGroup = new UsersGroup();
        usersGroup.setId(source.getId());
        usersGroup.setGroupName(source.getGroupName());

        return usersGroup;
    }
}
