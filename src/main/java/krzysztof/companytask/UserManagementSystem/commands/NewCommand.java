package krzysztof.companytask.UserManagementSystem.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
public class NewCommand {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 40)
    private String userName;

//    @NotBlank
//    private String category;

//    @NotBlank
//    @Size(max = 1000)
//    private String password;

    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
}
