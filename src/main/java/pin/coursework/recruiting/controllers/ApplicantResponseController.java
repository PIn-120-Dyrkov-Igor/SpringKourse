package pin.coursework.recruiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pin.coursework.recruiting.ApplicantData;
import pin.coursework.recruiting.models.ApplicantResponse;
import pin.coursework.recruiting.models.ApplicantResume;
import pin.coursework.recruiting.models.RecruiterJob;
import pin.coursework.recruiting.repositories.ApplicantResponseRepository;
import pin.coursework.recruiting.repositories.RecruiterJobRepository;

import java.util.Date;

@RequestMapping("/getJob")
@Controller
public class ApplicantResponseController {
    @Autowired
    private RecruiterJobRepository recruiterJobRepository;
    @Autowired
    private ApplicantResponseRepository applicantResponseRepository;

    @GetMapping("/newResponse/{id}")
    public String newResponse(Model model) {
        Iterable<RecruiterJob> recruiterJobs = recruiterJobRepository.findAll();
        model.addAttribute("jobs",recruiterJobs);
        return "newApplicantResponse";

    }
    @PostMapping("/newResponse")
    public String newResponse(@ModelAttribute ApplicantResponse applicantResponse, Model model){
        Date today = new Date();
        applicantResponse.setResponseDate(today);
        applicantResponse.setStatus("Активен");
        return "redirect:/resume/all";
    }
}
