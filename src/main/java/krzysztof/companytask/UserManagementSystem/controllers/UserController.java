package krzysztof.companytask.UserManagementSystem.controllers;

import krzysztof.companytask.UserManagementSystem.commands.NewCommand;
import krzysztof.companytask.UserManagementSystem.commands.UserCommand;
import krzysztof.companytask.UserManagementSystem.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/user/show/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("user", usersService.getUserById(new Long(id)));
        return "user/show";
    }

    @RequestMapping("/user/new")
    public String newUser(Model model){
        model.addAttribute("user", new NewCommand());
        return "user/userform";
    }

    @PostMapping
    @RequestMapping("user")
    public String saveNewUser(@ModelAttribute UserCommand userCommand){
        UserCommand savedCommand = usersService.saveUserCommand(userCommand);
        return "redirect:/user/show/"+savedCommand.getId();
    }
}
