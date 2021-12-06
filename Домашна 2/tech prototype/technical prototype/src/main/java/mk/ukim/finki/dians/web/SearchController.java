package mk.ukim.finki.dians.web;

import mk.ukim.finki.dians.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping()
    public String getHomePage(Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        return "home";
    }

    @GetMapping("/show/{id}")
    public String getItemPage(@PathVariable Long id, Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        if(searchService.findByIdHospital(id).isPresent())
            model.addAttribute("item", searchService.findByIdHospital(id).get());
        else if(searchService.findByIdVeterinary(id).isPresent())
            model.addAttribute("item", searchService.findByIdVeterinary(id).get());
        else if(searchService.findByIdClinic(id).isPresent())
            model.addAttribute("item", searchService.findByIdClinic(id).get());
        else
            model.addAttribute("item", searchService.findByIdPharmacy(id).get());
        return "item";
    }

    @PostMapping("search")
    public String postSearch(@RequestParam(required = false) String text, Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        if(text!="") {
            if (searchService.findByNameHospital(text).isPresent())
                model.addAttribute("item", searchService.findByNameHospital(text).get());
            else if (searchService.findByNameVeterinary(text).isPresent())
                model.addAttribute("item", searchService.findByNameVeterinary(text).get());
            else if (searchService.findByNameClinic(text).isPresent())
                model.addAttribute("item", searchService.findByNameClinic(text).get());
            else if (searchService.findByNamePharmacy(text).isPresent())
                model.addAttribute("item", searchService.findByNamePharmacy(text).get());
        }
        if(model.getAttribute("item")==null)
            return "redirect:/";
        return "item";
    }

}
