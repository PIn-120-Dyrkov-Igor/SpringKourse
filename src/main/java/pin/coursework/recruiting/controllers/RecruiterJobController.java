package pin.coursework.recruiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pin.coursework.recruiting.RecruiterData;
import pin.coursework.recruiting.models.Recruiter;
import pin.coursework.recruiting.models.RecruiterJob;
import pin.coursework.recruiting.repositories.RecruiterJobRepository;
import pin.coursework.recruiting.repositories.RecruiterRepository;

import java.util.Optional;

@RequestMapping("/job")
@Controller
public class RecruiterJobController {
    @Autowired
    private RecruiterJobRepository recruiterJobRepository;
    @Autowired
    private RecruiterRepository recruiterRepository;

    @GetMapping("/new")
    public String recruiterJob(Model model) {
        model.addAttribute("job", new RecruiterJob());
        return "newRecruiterJob";

    }
    @PostMapping("/new")
    public String recruiterJob(@ModelAttribute RecruiterJob recruiterJob, Model model){
        recruiterJob.setRecruiterId(RecruiterData.getRecruiter());
        recruiterJob.setStatus("Активен");
        recruiterJobRepository.save(recruiterJob);
        return "redirect:/job/all";
    }

    @GetMapping("/all")
    public String main(Model model){
        Long id = RecruiterData.getRecruiter();
        Optional<Recruiter> optionalRecruiter =
                recruiterRepository.findById(id);
        model.addAttribute("selectedRecruiter", optionalRecruiter.get());

        Iterable<RecruiterJob> recruiterJobs = recruiterJobRepository.findRecruiterJobsById(id);
        model.addAttribute("jobs",recruiterJobs);
        return "allJobs";
    }

    @GetMapping("/find")
    public String find(Model model){
        Iterable<RecruiterJob> recruiterJobs = recruiterJobRepository.findAll();
        model.addAttribute("jobs",recruiterJobs);
        return "allJobs";
    }

}
