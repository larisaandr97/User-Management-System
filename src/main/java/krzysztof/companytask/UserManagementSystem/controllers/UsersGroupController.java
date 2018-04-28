package krzysztof.companytask.UserManagementSystem.controllers;

import krzysztof.companytask.UserManagementSystem.commands.UsersGroupCommand;
import krzysztof.companytask.UserManagementSystem.services.UsersGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersGroupController {

    private UsersGroupService usersGroupService;

    public UsersGroupController(UsersGroupService usersGroupService) {
        this.usersGroupService = usersGroupService;
    }

    @GetMapping({"/groups"})
    public String showUsersGroupListPage(Model model){
        model.addAttribute("usersGroup" ,usersGroupService.getUsersGroup());
        return "groups";
    }

    @GetMapping
    @RequestMapping("/groups/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("usersGroup", usersGroupService.findById(Long.valueOf(id)));
        return "list/showGr";
    }

    @GetMapping
    @RequestMapping("/groups/{id}/update")
    public String updateUsersGroup(@PathVariable String id, Model model){
        model.addAttribute("usersGroup", usersGroupService.findGroupsCommandById(Long.valueOf(id)));
        return "list/groupsform";
    }

    @GetMapping
    @RequestMapping("/groups/new")
    public String newUsersGroup(Model model){
        model.addAttribute("usersGroup", new UsersGroupCommand());
        return "list/groupsform";
    }

    @PostMapping
    @RequestMapping("groups")
    public String saveOrUpdate(@ModelAttribute UsersGroupCommand userCommand){
        UsersGroupCommand savedCommand = usersGroupService.saveUsersGroupCommand(userCommand);
        return "redirect:/groups/"+savedCommand.getId()+"/show";
    }

    @GetMapping
    @RequestMapping("groups/{id}/delete")
    public String deleteUser(@PathVariable String id){
        usersGroupService.deleteUsersGroupById(Long.valueOf(id));
        return "redirect:/groups/";
    }
}
