package sk.tuke.gamestudio.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.entity.Person;
import sk.tuke.gamestudio.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserServiceRest {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Person> getUsersList() {
        return userService.getUsersList();
    }

    @PostMapping
    public void addUser(@RequestBody Person user) {
        userService.addUser(user);
    }
}
