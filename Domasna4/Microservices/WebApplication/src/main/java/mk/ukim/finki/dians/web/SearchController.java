
package mk.ukim.finki.dians.web;

import mk.ukim.finki.dians.model.Clinic;
import mk.ukim.finki.dians.model.Hospital;
import mk.ukim.finki.dians.model.Pharmacy;
import mk.ukim.finki.dians.model.Veterinary;
import mk.ukim.finki.dians.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping("/mk")
    public String getMk(HttpSession session,Model model)
    {
        this.addModelAttr(model);
        session.setAttribute("lan", "mk");
        return "home_mk";
    }

    @GetMapping("/ang")
    public String getAng(HttpSession session,Model model)
    {
        this.addModelAttr(model);
        session.setAttribute("lan", "ang");
        return "home";
    }

    @GetMapping("/category/{cat}")
    public String getCategory(HttpSession session,@PathVariable String cat, Model model)
    {
        this.addModelAttr(model);
        model.addAttribute("categoryName", cat);
        switch (cat) {
            case "Pharmacies":
            case "Аптеки":
                model.addAttribute("category", searchService.findAllPharmacies());
                break;
            case "Hospitals":
            case "Болници":
                model.addAttribute("category", searchService.findAllHospitals());
                break;
            case "Clinics":
            case "Клиники":
                model.addAttribute("category", searchService.findAllClinics());
                break;
            case "Veterinarians":
            case "Ветеринарни ординации":
                model.addAttribute("category", searchService.findAllVeterinaries());
                break;
        }
        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
            return "category_mk";
        return "category";
    }

    @GetMapping()
    public String getHomePage(@RequestParam(required = false) String error,  HttpSession session,Model model )
    {
        if (error!=null)
        {
            model.addAttribute("error", "No result found");
            if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                model.addAttribute("error", "Не се пронајдени резултати");
        }
        this.addModelAttr(model);
        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
            return "home_mk";
        return "home";
    }

    @GetMapping("/show/{id}")
    public String getItemPage(HttpSession session,@PathVariable Long id, Model model)
    {
        this.addModelAttr(model);
        if(searchService.findByIdHospital(id).isPresent() )
            model.addAttribute("item", searchService.findByIdHospital(id).get());
        else if(searchService.findByIdVeterinary(id).isPresent())
            model.addAttribute("item", searchService.findByIdVeterinary(id).get());
        else if(searchService.findByIdClinic(id).isPresent())
            model.addAttribute("item", searchService.findByIdClinic(id).get());
        else
            model.addAttribute("item", searchService.findByIdPharmacy(id).get());
        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
            return "item_mk";
        return "item";
    }
//
//    @GetMapping("/show/clinic/{id}")
//    public String getClinicPage(HttpSession session,@PathVariable Long id, Model model)
//    {
//        this.addModelAttr(model);
//        if(searchService.findByIdClinic(id).isPresent())
//            model.addAttribute("item", searchService.findByIdClinic(id).get());
//        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
//            return "item_mk";
//        return "item";
//    }
//
//    @GetMapping("/show/hospital/{id}")
//    public String getHospitalPage(HttpSession session,@PathVariable Long id, Model model)
//    {
//        this.addModelAttr(model);
//        if(searchService.findByIdHospital(id).isPresent())
//            model.addAttribute("item", searchService.findByIdHospital(id).get());
//        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
//            return "item_mk";
//        return "item";
//    }
//
//    @GetMapping("/show/veterinary/{id}")
//    public String getVeterinaryPage(HttpSession session,@PathVariable Long id, Model model)
//    {
//        this.addModelAttr(model);
//        if(searchService.findByIdVeterinary(id).isPresent())
//            model.addAttribute("item", searchService.findByIdVeterinary(id).get());
//        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
//            return "item_mk";
//        return "item";
//    }
//    @GetMapping("/show/pharmacy/{id}")
//    public String getPharmacyPage(HttpSession session,@PathVariable Long id, Model model)
//    {
//        this.addModelAttr(model);
//        if(searchService.findByIdPharmacy(id).isPresent())
//            model.addAttribute("item", searchService.findByIdPharmacy(id).get());
//        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
//            return "item_mk";
//        return "item";
//    }

    @PostMapping("search")
    public String postSearch(HttpSession session,@RequestParam(required = false) String text, Model model)
    {
        model.addAttribute("text", text);
        this.addModelAttr(model);
        switch (text.toLowerCase()) {
            case "hospital":
            case "hospitals":
            case "болница":
            case "болници":
                model.addAttribute("category", searchService.findAllHospitals());
                if (session.getAttribute("lan") != null && session.getAttribute("lan").equals("mk"))
                    return "category_mk";
                return "category";
            case "veterinary":
            case "veterinaries":
            case "veterinarians":
            case "veterinarian":
            case "ветеринари":
            case "ветеринар":
                model.addAttribute("category", searchService.findAllVeterinaries());
                if (session.getAttribute("lan") != null && session.getAttribute("lan").equals("mk"))
                    return "category_mk";
                return "category";
            case "clinic":
            case "clinics":
            case "клиники":
            case "клиника":
                model.addAttribute("category", searchService.findAllClinics());
                if (session.getAttribute("lan") != null && session.getAttribute("lan").equals("mk"))
                    return "category_mk";
                return "category";
            case "pharmacy":
            case "pharmacies":
            case "аптека":
            case "аптеки":
                model.addAttribute("category", searchService.findAllPharmacies());
                if (session.getAttribute("lan") != null && session.getAttribute("lan").equals("mk"))
                    return "category_mk";
                return "category";
        }
        if(!text.equals("")) {
            if (searchService.findByNameHospital(text).size()>0)
                return findByText("Hospital", text, model, session);

            else if (searchService.findByNameVeterinary(text).size()>0)
                return findByText("Veterinary", text, model, session);

            else if (searchService.findByNameClinic(text).size()>0)
                return findByText("Clinic", text, model, session);

            else if (searchService.findByNamePharmacy(text).size()>0)
                return findByText("Pharmacy", text, model, session);

            else  return "redirect:/?error=error";
        }
        return "redirect:/";
    }

    private String findByText(String building,String text, Model model, HttpSession session)
    {
        switch (building) {
            case "Hospital": {
                List<Hospital> list = searchService.findByNameHospital(text);
                if (list.size() == 1) {
                    model.addAttribute("item", list.get(0));
                    return this.returnItem(session);
                } else {
                    model.addAttribute("category", list);
                    return this.returnCategory(session);
                }
            }
            case "Clinic": {
                List<Clinic> list = searchService.findByNameClinic(text);
                if (list.size() == 1) {
                    model.addAttribute("item", list.get(0));
                    return this.returnItem(session);
                } else {
                    model.addAttribute("category", list);
                    return this.returnCategory(session);
                }
            }
            case "Veterinary": {
                List<Veterinary> list = searchService.findByNameVeterinary(text);
                if (list.size() == 1) {
                    model.addAttribute("item", list.get(0));
                    return this.returnItem(session);
                } else {
                    model.addAttribute("category", list);
                    return this.returnCategory(session);
                }
            }
            default: // default: категорија Pharmacy
                {
                List<Pharmacy> list = searchService.findByNamePharmacy(text);
                if (list.size() == 1) {
                    model.addAttribute("item", list.get(0));
                    return this.returnItem(session);
                } else {
                    model.addAttribute("category", list);
                    return this.returnCategory(session);
                }
            }
        }
    }

    private String returnItem(HttpSession session)
    {
        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
            return "item_mk";
        return "item";
    }

    private String returnCategory(HttpSession session)
    {
        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
            return "category_mk";
        return "category";
    }

    private void addModelAttr(Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
    }
}
