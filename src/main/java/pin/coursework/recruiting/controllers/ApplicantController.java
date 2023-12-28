package pin.coursework.recruiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pin.coursework.recruiting.ApplicantData;
import pin.coursework.recruiting.models.Applicant;
import pin.coursework.recruiting.repositories.ApplicantRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/applicant")
@Controller
public class ApplicantController {
    @Autowired
    private ApplicantRepository applicantRepository;
    //http://localhost:8080/
    @GetMapping("/all")
    public String main(Model model){
        model.addAttribute("title","Страница соискателя");
        if(ApplicantData.isSelected() == false){
            List<Applicant> applicants = (List<Applicant>)applicantRepository.findAll();
            model.addAttribute("applicants",applicants);
            return "allApplicants";
        }
        else {
            Long id = ApplicantData.getApplicant();
            Optional<Applicant> optionalApplicant =
                    applicantRepository.findById(id);
            model.addAttribute("selectedApplicant", optionalApplicant.get());
            return "applicant";
        }
    }

    @GetMapping("/set/{id}")
    public String setApplicant(Model model, @PathVariable("id") Long id) {
        Optional<Applicant> optionalApplicant =
                applicantRepository.findById(id);
        if (optionalApplicant.isEmpty()) {
            return "redirect:/applicant";
        }
        model.addAttribute("selectedApplicant", optionalApplicant.get());
        ApplicantData.setApplicant(id);
        return "applicant";
    }

    @GetMapping("/exit")
    public String exitApplicant(Model model) {
        ApplicantData.clearApplicant();
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newApplicant(Model model) {
        if(ApplicantData.isFirstRegistrarion() == true){
            model.addAttribute("applicant", new Applicant());
            return "newApplicant";
        }
        else if(ApplicantData.isSelected() == false){
            List<Applicant> applicants = (List<Applicant>)applicantRepository.findAll();
            model.addAttribute("applicants",applicants);
            return "allApplicants";//main.html
        }
        else {
            Long id = ApplicantData.getApplicant();
            Optional<Applicant> optionalApplicant =
                    applicantRepository.findById(id);
            model.addAttribute("selectedApplicant", optionalApplicant.get());
            return "applicant";
        }

    }
    @PostMapping("/new")
    public String newApplicant(@ModelAttribute Applicant applicant, Model model){
            Date today = new Date();
            applicant.setStatus("Активен");
            applicant.setRegistrationDate(today);
            applicantRepository.save(applicant);
            ApplicantData.setApplicant(applicant.getId());
            return "redirect:/applicant/all";
    }

    @GetMapping("/set")
    public String set(Model model) {
        ApplicantData.setApplicant((long)1);
        Optional<Applicant> optionalApplicant =
                applicantRepository.findById((long)1);
        model.addAttribute("selectedApplicant", optionalApplicant.get());
        return "test";
    }

}
