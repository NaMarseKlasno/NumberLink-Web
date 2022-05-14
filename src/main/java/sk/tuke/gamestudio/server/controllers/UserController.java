package sk.tuke.gamestudio.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.tuke.gamestudio.core.Field;
import sk.tuke.gamestudio.entity.Person;
import sk.tuke.gamestudio.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;


@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserController {
    private Person sign_in_user;

    private Field field;


    @Autowired
    private UserService userService;

//    @Autowired
//    private NumberlinkController numberlinkController;

    @RequestMapping("/login")
    public String login(@ModelAttribute("login") String login) {
        if (login.length() == 0) {
            return "index";
        }
        sign_in_user = userService.getPerson(login);

        if (sign_in_user == null) {
            sign_in_user = new Person(login, 1);
            userService.addUser(sign_in_user);
        }


        return "redirect:/numberlink";
    }

    @RequestMapping("/login-as-guest")
    public String loginGuest() {

        sign_in_user = userService.getPerson("Guest");
        if (sign_in_user == null) {
            sign_in_user = new Person("Guest", 1);
            userService.addUser(sign_in_user);
        }

        return "redirect:/numberlink";
    }

    public Person getPerson() {
        return sign_in_user;
    }

//    @RequestMapping("/logout")
//    public String logout() {
//        sign_in_user = null;
//        return "redirect:/";
//    }

    public void setSign_in_user(Person sign_in_user) {
        this.sign_in_user = sign_in_user;
    }
}

