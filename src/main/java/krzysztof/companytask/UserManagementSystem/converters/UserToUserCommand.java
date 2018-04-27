package krzysztof.companytask.UserManagementSystem.converters;

import krzysztof.companytask.UserManagementSystem.commands.UserCommand;
import krzysztof.companytask.UserManagementSystem.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand> {
    @Override
    public UserCommand convert(User source) {

        if (source == null) return null;

        final UserCommand command = new UserCommand();
        command.setId(source.getId());
        command.setUserName(source.getUserName());
        command.setPassword(source.getPassword());
        command.setFirstName(source.getFirstName());
        command.setLastName(source.getLastName());
        command.setDateOfBirth(source.getDateOfBirth());

        return command;
    }
}
