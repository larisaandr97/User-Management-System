package krzysztof.companytask.UserManagementSystem.controllers;

import krzysztof.companytask.UserManagementSystem.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private UsersService usersService;

    public IndexController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping({"", "/index"})
    public String showUsersListPage(){
        return "index";
    }
}
