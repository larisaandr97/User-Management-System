package krzysztof.companytask.UserManagementSystem.converters;

import krzysztof.companytask.UserManagementSystem.commands.UsersGroupCommand;
import krzysztof.companytask.UserManagementSystem.domain.UsersGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UsersGroupToUsersGroupCommand implements Converter<UsersGroup, UsersGroupCommand> {
    @Override
    public UsersGroupCommand convert(UsersGroup source) {

        if (source == null) return null;

        final UsersGroupCommand command = new UsersGroupCommand();
        command.setId(source.getId());
        command.setGroupName(source.getGroupName());

        return command;
    }
}
