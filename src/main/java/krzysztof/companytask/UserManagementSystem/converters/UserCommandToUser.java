package krzysztof.companytask.UserManagementSystem.converters;

import krzysztof.companytask.UserManagementSystem.commands.UserCommand;
import krzysztof.companytask.UserManagementSystem.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCommandToUser implements Converter<UserCommand, User> {

    @Override
    public User convert(UserCommand source) {
        if (source == null) return null;

        User user = new User();
        user.setId(source.getId());
        user.setUserName(source.getUserName());
        user.setPassword(source.getPassword());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setDateOfBirth(source.getDateOfBirth());

        return user;
    }
}
