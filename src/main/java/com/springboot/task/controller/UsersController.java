package com.springboot.task.controller;
import com.springboot.task.model.User;
import com.springboot.task.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/app")
public class UsersController {

    private final UserService userService;
    public UsersController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/app/users";
    }

    @GetMapping(value = "/users/new")
    public String newUser(@ModelAttribute("user") User user){
        return "new";
    }

    @GetMapping(value = "/users")
    public String printUsers(Model model){
        List <User> userList = userService.listUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    @GetMapping(value = "/users{id}")
    public String getUsersById(@PathVariable("id") Long id, Model model){
        model.addAttribute(userService.getUserById(id));
        return "userId";
    }

    @GetMapping(value = "/users/{id}/update")
    public String update(Model model, @PathVariable("id") Long id, User user){
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping (value = "/users/{id}")
    public String update1(@ModelAttribute("user") User user, @PathVariable("id") Long id){
        userService.update(id, user);
        return "redirect:/app/users";
    }

    @DeleteMapping(value = "/users/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/app/users";
    }

}
