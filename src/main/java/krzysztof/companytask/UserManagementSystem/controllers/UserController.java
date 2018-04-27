package krzysztof.companytask.UserManagementSystem.controllers;

import krzysztof.companytask.UserManagementSystem.commands.UserCommand;
import krzysztof.companytask.UserManagementSystem.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    @RequestMapping("/user/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("user", usersService.findById(new Long(id)));
        return "user/show";
    }

    @GetMapping
    @RequestMapping("/user/{id}/update")
    public String updateUser(@PathVariable String id, Model model){
        model.addAttribute("user", usersService.findCommandById(Long.valueOf(id)));
        return "user/userform";
    }

    @GetMapping
    @RequestMapping("/user/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserCommand());
        return "user/userform";
    }

    @PostMapping
    @RequestMapping("user")
    public String saveOrUpdate(@ModelAttribute UserCommand userCommand){
        UserCommand savedCommand = usersService.saveUserCommand(userCommand);
        return "redirect:/user/"+savedCommand.getId()+"/show";
    }

    @GetMapping
    @RequestMapping("user/{id}/delete")
    public String deleteUser(@PathVariable String id){
        usersService.deleteUserById(Long.valueOf(id));
        return "redirect:/";
    }

}
