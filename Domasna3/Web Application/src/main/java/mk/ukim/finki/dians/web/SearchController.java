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

    @GetMapping("/map")
    public String getMap(Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        model.addAttribute("message", "messageText");
        System.out.println( searchService.findAllPharmacies().size());
        System.out.println(searchService.findAllPharmacies().get(0).getLat());
        return "map";
    }
    @GetMapping("/category/{cat}")
    public String getCategory(@PathVariable String cat, Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        model.addAttribute("categoryName", cat);
        if(cat.equals("Pharmacies"))
            model.addAttribute("category", searchService.findAllPharmacies());
        else if(cat.equals("Hospitals"))
            model.addAttribute("category", searchService.findAllHospitals());
        else if(cat.equals("Clinics"))
            model.addAttribute("category", searchService.findAllClinics());
        else if(cat.equals("Veterinarians"))
            model.addAttribute("category", searchService.findAllVeterinaries());
        return "category";
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
        if("hospitals".contains(text.toLowerCase())) {
            model.addAttribute("category", searchService.findAllHospitals());
            return "category";
        }
        else if("veterinary".contains(text.toLowerCase()) || "veterinaries".contains(text.toLowerCase())
        || "veterinarians".contains(text.toLowerCase())) {
            model.addAttribute("category", searchService.findAllVeterinaries());
            return "category";
        }
        else if("clinics".contains(text.toLowerCase())) {
            model.addAttribute("category", searchService.findAllClinics());
            return "category";
        }
        else if("pharmacy".contains(text.toLowerCase())||"pharmacies".contains(text.toLowerCase())) {
            model.addAttribute("category", searchService.findAllPharmacies());
            return "category";
        }
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
