package sk.tuke.gamestudio.server.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.gamestudio.entity.Person;
import sk.tuke.gamestudio.entity.Rating;
import sk.tuke.gamestudio.entity.Review;
import sk.tuke.gamestudio.service.ReviewService;
import sk.tuke.gamestudio.service.UserService;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;



    @RequestMapping("/about-us")
    public String aboutUs(Model model) {
        model.addAttribute("ratingClass", new Rating());

        return "aboutUs";
    }


    @RequestMapping("/get-review")
    public String getComment(@ModelAttribute("comment") String comment, @ModelAttribute Rating rating) {

        if (rating.getRating() == null) return "redirect:/about-us";

        reviewService.addReview(new Review(userController.getPerson().getUserID(), comment, rating.getRating()));

        return "redirect:/about-us";
    }




    public String getListOfComments() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < reviewService.getReviewList().size(); i++) {

//            sb.append("<div class='col align-self-center'>");
            sb.append("<div class='card border-white bg-dark mb-4' style='width: 88rem;'>");
            sb.append("<div class='card-body'>");
            sb.append("<div class='container mb-2'> <div class='row justify-content-center'> <div class='col-auto'>");
            sb.append("<h5 class='card-title'>" + userService.getPersonByID(reviewService.getReviewList().get(i).getUserID()).getUserName() + "</h5>");
            sb.append("</div></div></div>");

            sb.append("<p class='card-text'> <strong>").append(reviewService.getReviewList().get(i).getCommentedAt()).append("</strong> ");
            sb.append(reviewService.getReviewList().get(i).getComment()).append("</p>");

//            sb.append(showCommentByName(username));
            sb.append("</div>");
            sb.append("</div>");
//            sb.append("</div>");
        }


        return sb.toString();
    }




}
