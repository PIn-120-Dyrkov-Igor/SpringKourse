package pin.coursework.recruiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pin.coursework.recruiting.ApplicantData;
import pin.coursework.recruiting.RecruiterData;
import pin.coursework.recruiting.models.Applicant;
import pin.coursework.recruiting.models.Recruiter;
import pin.coursework.recruiting.repositories.RecruiterRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("/recruiter")
@Controller
public class RecruiterController {
    @Autowired
    private RecruiterRepository recruiterRepository;

    @GetMapping("/new")
    public String newRecruiter(Model model) {
        if(RecruiterData.isFirstRegistrarion() == true){
            model.addAttribute("recruiter", new Recruiter());
            return "newRecruiter";
        }
        else if(RecruiterData.isSelected() == false){
            List<Recruiter> recruiters = (List<Recruiter>)recruiterRepository.findAll();
            model.addAttribute("recruiters",recruiters);
            return "allRecruiters";
        }
        else {
            Long id = RecruiterData.getRecruiter();
            Optional<Recruiter> optionalRecruiter =
                    recruiterRepository.findById(id);
            model.addAttribute("selectedRecruiter", optionalRecruiter.get());
            return "recruiter";
        }

    }
    @PostMapping("/new")
    public String newRecruiter(@ModelAttribute Recruiter recruiter, Model model){
        recruiterRepository.save(recruiter);
        RecruiterData.setRecruiter(recruiter.getId());
        return "redirect:/recruiter/all";
    }

    @GetMapping("/set/{id}")
    public String setRecruiter(Model model, @PathVariable("id") Long id) {
        Optional<Recruiter> optionalRecruiter =
                recruiterRepository.findById(id);
        if (optionalRecruiter.isEmpty()) {
            return "redirect:/recruiter";
        }
        model.addAttribute("selectedRecruiter", optionalRecruiter.get());
        RecruiterData.setRecruiter(id);
        return "recruiter";
    }

    @GetMapping("/all")
    public String main(Model model){
        model.addAttribute("title","Страница рекруитера");
        if(RecruiterData.isSelected() == false){
            List<Recruiter> recruiters = (List<Recruiter>)recruiterRepository.findAll();
            model.addAttribute("recruiters",recruiters);
            return "allRecruiter";
        }
        else {
            Long id = RecruiterData.getRecruiter();
            Optional<Recruiter> optionalRecruiter =
                    recruiterRepository.findById(id);
            model.addAttribute("selectedRecruiter", optionalRecruiter.get());
            return "recruiter";
        }
    }

    @GetMapping("/exit")
    public String exitRecruiter(Model model) {
        RecruiterData.clearRecruiter();
        return "redirect:/";
    }


}
