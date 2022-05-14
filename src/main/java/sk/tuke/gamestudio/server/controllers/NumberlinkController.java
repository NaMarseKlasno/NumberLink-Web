package sk.tuke.gamestudio.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.gamestudio.core.Field;
import sk.tuke.gamestudio.core.Tile;
import sk.tuke.gamestudio.entity.Comment;
import sk.tuke.gamestudio.entity.Person;
import sk.tuke.gamestudio.service.CommentService;
import sk.tuke.gamestudio.service.UserService;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class NumberlinkController {

    private Field field = new Field(0);

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;



    @RequestMapping("/numberlink")
    public String numberlink(Model model) {
        model.addAttribute("name", userController.getPerson().getUserName());
        model.addAttribute("last", userController.getPerson().getLastLevel());

        if (field.isLevelSolved()) {
            this.field.generate(userController.getPerson().getLastLevel()+1);
            userController.getPerson().setLastLevel(userController.getPerson().getLastLevel()+1);
            this.userService.update(userController.getPerson());
        }
        return "numberlink";
    }

    @RequestMapping("/numberlink/addcomment")
    public String getInputComment(@ModelAttribute("inComment") String inComment) {

        if (inComment.length()>0) commentService.addComment(new Comment(userController.getPerson().getUserID(), inComment));
        return "redirect:/numberlink";
    }

    @RequestMapping("/numberlink/terminal")
    public String terminalUI(@ModelAttribute("inCommand") String inCommand)
    {
        String line = inCommand.toUpperCase();
        if (line.length() < 4)
            return "redirect:/numberlink";

        String test = line.substring(0, 2);

        if (!test.matches("[1-9]{2}"))
            return "redirect:/numberlink";

        int x = Integer.parseInt(line.substring(0, 1));
        int y = Integer.parseInt(line.substring(1, 2));

        if (x > 0 && y > 0 && x <= field.getColumnCount() && y <= field.getRowCount()) {
            if (line.charAt(2) != 'W' && line.charAt(2) != 'E' && line.charAt(2) != 'S' && line.charAt(2) != 'N')
                return "redirect:/numberlink";
            String str = line.substring(3);
            if (!str.matches("[-+]?\\d+"))
                return "redirect:/numberlink";
            if (!field.connectTiles(x, y, line.charAt(2), Integer.parseInt(str)))
                return "redirect:/numberlink";
        } else return "redirect:/numberlink";

        return "redirect:/numberlink";
    }

    @RequestMapping("/start")
    public String start() {
        field.generate(userController.getPerson().getLastLevel());
        return "redirect:/numberlink";
    }

    public String invalid() {
        StringBuilder sb = new StringBuilder();

        if (userController.getPerson().getUserName().equals("Guest")) {
            sb.append("<input type='text' name='inComment' class='form-control bg-dark text-white is-invalid' placeholder='Enter comment' aria-label='Enter comment' aria-describedby='validationServerUsernameFeedback'> </input>");
            sb.append(" <div id='validationServerUsernameFeedback' class='invalid-feedback mb-2'>\n" + "Please sign in to comment publicly.\n" + "</div>");
        } else {
            sb.append("<input type='text' name='inComment' class='form-control bg-dark text-white' placeholder='Enter comment'            aria-label='Enter comment' aria-describedby='validationServerUsernameFeedback'>");
        }


        return sb.toString();
    }


    public String getHtmlField() {

        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n");

        sb.append("<tbody>\n");

        for (int i = 0; i < field.getRowCount(); ++i) {
            sb.append("<tr>\n");
            for (int j = 0; j < field.getColumnCount(); ++j) {
                sb.append("<td>\n");
                sb.append("<img src=" + getPicture(field.getTiles()[i][j]) + "class='rounded-3'>");
                sb.append("</td>\n");
            }
            sb.append("</tr>\n");
        }
        sb.append("</tbody>\n");
        sb.append("</table>\n");


        return sb.toString();
    }

    private String getPicture(Tile tile) {

        String width = "width='60'";
        String height = "height='60'";

        switch (tile.getContent()) {
            case 1: return "'/numbers/pg1.png'" + width + height;
            case 2: return "'/numbers/pg2.png'" + width + height;
            case 3: return "'/numbers/pg3.png'" + width + height;
            case 4: return "'/numbers/pg4.png'" + width + height;
            case 5: return "'/numbers/pg5.png'" + width + height;
            default: return "'/numbers/pg0.png'" + width + height;
        }
    }


    public String getUsersList() {
        StringBuilder sb = new StringBuilder();

        sb.append("<table class='table table-dark table-borderless table-cell-padding-y-sm'>");
        sb.append("<caption>List of users</caption> <thead> <tr>");
        sb.append("<th scope='col'>user name</th>");
        sb.append("<th scope='col'>last level</th></tr></thead>");
        sb.append("<tbody>");

        for (int i = 0; i < userService.getUsersList().size(); ++i) {
            sb.append("<tr>");
            sb.append("<td>" + userService.getUsersList().get(i).getUserName() + "</td>");
            sb.append("<td>" + userService.getUsersList().get(i).getLastLevel() + "</td>");
            sb.append("</tr>");
        }


        sb.append("</tbody>");
        sb.append("</table>");

        return sb.toString();
    }

    public String showProfile(String username) {
        StringBuilder sb = new StringBuilder();

        /*
                <div class="card border-white bg-dark" style="width: 18rem;">
                    <div class="card-body ">
                        <div class="mb-2" th:utext="${@numberlinkController.showProfile}"></div>
                        <div th:utext="${@numberlinkController.showCommentsByName(@userController.getPerson.getUserName)}"></div>
                    </div>
                </div>         */

        sb.append("<div class='card border-white bg-dark mb-4' style='width: 18rem;'>");
        sb.append("<div class='card-body'>");
        sb.append("<div class='container mb-2'> <div class='row justify-content-between'> <div class='col-auto'>");
        sb.append("<h5 class='card-title'>" + username + "</h5>");
        sb.append("</div> <div class='col-auto'>");
        sb.append("<h5 class='card-title'>level " + userService.getPerson(username).getLastLevel() + "</h5>");
        sb.append("</div></div></div>");
        sb.append(showCommentsByName(username));
        sb.append("</div>");
        sb.append("</div>");


        return sb.toString();
    }

    public String showCommentsByName(String username) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < commentService.getCommentsListByPerson(username).size(); ++i) {
            sb.append("<p class='card-text'> <strong>").append(commentService.getCommentsListByPerson(username).get(i).getCommentedAt()).append("</strong> ");
            sb.append(commentService.getCommentsListByPerson(username).get(i).getComment()).append("</p>");
        }

        return sb.toString();
    }

    public String showAllProfiles() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < userService.getUsersList().size(); i++) {
            if (!userService.getUsersList().get(i).getUserName().equals("Guest")) sb.append(showProfile(userService.getUsersList().get(i).getUserName()));
        }

        return sb.toString();
    }

    @RequestMapping("/logout")
    public String logout() {
        userController.setSign_in_user(null);
        field.generate(0);
        return "redirect:/";
    }

    @RequestMapping("/new-game")
    public String newGame() {
        field.generate(1);
        userController.getPerson().setLastLevel(1);
        userService.update(userController.getPerson());
        return "redirect:/numberlink";
    }

}
