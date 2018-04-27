package krzysztof.companytask.UserManagementSystem.controllers;

import krzysztof.companytask.UserManagementSystem.commands.NewCommand;
import krzysztof.companytask.UserManagementSystem.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/user/userform")
    public String addNewUser(Model model){
        model.addAttribute("user", new NewCommand());
        return "user/userform";
    }
}
