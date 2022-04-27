//package sk.tuke.gamestudio.server.controllers;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.WebApplicationContext;
//import sk.tuke.gamestudio.entity.Person;
//
//
//
//@Controller
//@Scope(WebApplicationContext.SCOPE_SESSION)
//public class MainController {
//    private Person loggedUser;
//
//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
//
////    @RequestMapping("/login")
////    public String login(String login, String password) {
////        if ("heslo".equals(password)) {
////            loggedUser = new User(login);
////            return "redirect:/mines";
////        }
////
////        return "redirect:/";
////    }
////
////    @RequestMapping("/logout")
////    public String logout() {
////        loggedUser = null;
////        return "redirect:/";
////    }
//
//    public Person getLoggedUser() {
//        return loggedUser;
//    }
//
//    public boolean isLogged() {
//        return loggedUser != null;
//    }
//}
//
