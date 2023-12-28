package pin.coursework.recruiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pin.coursework.recruiting.ApplicantData;
import pin.coursework.recruiting.RecruiterData;
import pin.coursework.recruiting.models.Applicant;
import pin.coursework.recruiting.models.ApplicantResume;
import pin.coursework.recruiting.repositories.ApplicantRepository;
import pin.coursework.recruiting.repositories.ApplicantResumeRepository;
import java.util.Optional;

@RequestMapping("/resume")
@Controller
public class ApplicantResumeController {

    @Autowired
    private ApplicantResumeRepository applicantResumeRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    @GetMapping("/new")
    public String newResume(Model model) {
            model.addAttribute("resume", new ApplicantResume());
            return "newApplicantResume";

    }
    @PostMapping("/new")
    public String newResume(@ModelAttribute ApplicantResume applicantResume, Model model){
        applicantResume.setApplicantId(ApplicantData.getApplicant());
        applicantResume.setStatus("Активен");
        applicantResumeRepository.save(applicantResume);
        return "redirect:/resume/all";
    }
    @GetMapping("/all")
    public String main(Model model){
        Long id = ApplicantData.getApplicant();
        Optional<Applicant> optionalApplicant =
                applicantRepository.findById(id);
        model.addAttribute("selectedApplicant", optionalApplicant.get());

        //List<ApplicantResume> applicantResumes = (List<ApplicantResume>)applicantResumeRepository.findAll();
        Iterable<ApplicantResume> applicantResumes = applicantResumeRepository.findApplicantResumesById(id);
        model.addAttribute("resumes",applicantResumes);
        return "allResumes";
    }

    @GetMapping("/details/{id}")
    public String details(Model model, @PathVariable("id") Long id) {
        Optional<ApplicantResume> optionalApplicantResume =
                applicantResumeRepository.findById(id);
        if (optionalApplicantResume.isEmpty()) {
            return "redirect:/students/all";
        }
        model.addAttribute("resume", optionalApplicantResume.get());
        return "resumeDetail";
    }

    @GetMapping("/findJob")
    public String findJob(Model model) {
        ApplicantData.setActive(true);
        RecruiterData.setActive(false);
        return "redirect:/job/all";
    }
}
