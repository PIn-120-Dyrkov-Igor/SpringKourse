package pin.coursework.recruiting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {
    //http://localhost:8080/
    @GetMapping("/")
    public String start(Model model){
        model.addAttribute("title","Главная страница");
        return "main";//main.html
    }

    @GetMapping("/home")
    public String main(Model model){
        model.addAttribute("title","Главная страница");
        return "main";//main.html
    }

    @GetMapping("/to")
    public RedirectView two(Model model){
        model.addAttribute("title","Вторая страница");

        return new RedirectView("/applicant");
    }
}
