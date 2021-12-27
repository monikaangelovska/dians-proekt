package mk.ukim.finki.dians.web;

import mk.ukim.finki.dians.model.Pharmacy;
import mk.ukim.finki.dians.service.SearchService;
import org.apache.catalina.Session;
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

    @GetMapping("/mk")
    public String getMk(HttpSession session,Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        session.setAttribute("lan", "mk");
        return "home_mk";
    }

    @GetMapping("/ang")
    public String getAng(HttpSession session,Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        session.setAttribute("lan", "ang");
        return "home";
    }

    @GetMapping("/category/{cat}")
    public String getCategory(HttpSession session,@PathVariable String cat, Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        model.addAttribute("categoryName", cat);
        if(cat.equals("Pharmacies") || cat.equals("Аптеки"))
            model.addAttribute("category", searchService.findAllPharmacies());
        else if(cat.equals("Hospitals") || cat.equals("Болници"))
            model.addAttribute("category", searchService.findAllHospitals());
        else if(cat.equals("Clinics") || cat.equals("Клиники"))
            model.addAttribute("category", searchService.findAllClinics());
        else if(cat.equals("Veterinarians") || cat.equals("Ветеринарни ординации"))
            model.addAttribute("category", searchService.findAllVeterinaries());
        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
            return "category_mk";
        return "category";
    }

    @GetMapping()
    public String getHomePage(HttpSession session,Model model)
    {
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
            return "home_mk";
        return "home";
    }

    @GetMapping("/show/{id}")
    public String getItemPage(HttpSession session,@PathVariable Long id, Model model)
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
        if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
            return "item_mk";
        return "item";
    }

    @PostMapping("search")
    public String postSearch(HttpSession session,@RequestParam(required = false) String text, Model model)
    {
        model.addAttribute("text", text);
        model.addAttribute("pharmacies", searchService.findAllPharmacies());
        model.addAttribute("veterinaries", searchService.findAllVeterinaries());
        model.addAttribute("hospitals", searchService.findAllHospitals());
        model.addAttribute("clinics", searchService.findAllClinics());
        if("hospitals".contains(text.toLowerCase()) || "болница".contains(text.toLowerCase()) ||
                "болници".contains(text.toLowerCase()) ) {
            model.addAttribute("category", searchService.findAllHospitals());
//            model.addAttribute("categoryName", "Hospitals");
            if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                return "category_mk";
            return "category";
        }
        else if("veterinary".contains(text.toLowerCase()) || "veterinaries".contains(text.toLowerCase())
        || "veterinarians".contains(text.toLowerCase()) || "ветеринари".contains(text.toLowerCase()) ) {
            model.addAttribute("category", searchService.findAllVeterinaries());
//            model.addAttribute("categoryName", "Veterinaries");
            if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                return "category_mk";
            return "category";
        }
        else if("clinics".contains(text.toLowerCase()) ||"клиники".contains(text.toLowerCase())
        || "клиника".contains(text.toLowerCase()) ) {
            model.addAttribute("category", searchService.findAllClinics());
//            model.addAttribute("categoryName", "Clinics");
            if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                return "category_mk";
            return "category";
        }
        else if("pharmacy".contains(text.toLowerCase())||"pharmacies".contains(text.toLowerCase())
        || "аптека".contains(text.toLowerCase())||"аптеки".contains(text.toLowerCase())) {
            model.addAttribute("category", searchService.findAllPharmacies());
//            model.addAttribute("categoryName", "Pharmacies");
            if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                return "category_mk";
            return "category";
        }
        if(text!="") {
            if("zegin".contains(text.toLowerCase()) || "зегин".contains(text.toLowerCase()))
            {
                List<Pharmacy> list1=searchService.findByNamePharmacy("zegin");
                List<Pharmacy> list2=searchService.findByNamePharmacy("зегин");
                list1.addAll(list2);
                list1.sort(Pharmacy.compareByName);
                model.addAttribute("category", list1);
                if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                    return "category_mk";
                return "category";
            }
            else if("eurofarm".contains(text.toLowerCase()) || "еурофарм".contains(text.toLowerCase()))
            {
                List<Pharmacy> list1=searchService.findByNamePharmacy("eurofarm");
                List<Pharmacy> list2=searchService.findByNamePharmacy("еурофарм");
                list1.addAll(list2);
                list1.sort(Pharmacy.compareByName);
                model.addAttribute("category", list1);
                if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                    return "category_mk";
                return "category";
            }
            else if (searchService.findByNameHospital(text).size()>0)
            {
                if(searchService.findByNameHospital(text).size()==1)
                {
                    model.addAttribute("item", searchService.findByNameHospital(text).get(0));
                    if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                        return "item_mk";
                    return "item";
                }
                else
                {
                    model.addAttribute("category", searchService.findByNameHospital(text));
                    if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                        return "category_mk";
                    return "category";
                }
            }

            else if (searchService.findByNameVeterinary(text).size()>0)
            {
                if (searchService.findByNameVeterinary(text).size()==1)
                {
                    model.addAttribute("item", searchService.findByNameVeterinary(text).get(0));
                    if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                        return "item_mk";
                    return "item";
                }
                else
                {
                    model.addAttribute("category", searchService.findByNameVeterinary(text));
                    if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                        return "category_mk";
                    return "category";
                }
            }

            else if (searchService.findByNameClinic(text).size()>0)
            {
                if (searchService.findByNameClinic(text).size()==1)
                {
                    model.addAttribute("item", searchService.findByNameClinic(text).get(0));
                    if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                        return "item_mk";
                    return "item";
                }
                else
                {
                    model.addAttribute("category", searchService.findByNameClinic(text));
                    if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                        return "category_mk";
                    return "category";
                }
            }

            else if (searchService.findByNamePharmacy(text).size()>0)
            {
                if (searchService.findByNamePharmacy(text).size()==1)
                {
                    model.addAttribute("item", searchService.findByNamePharmacy(text).get(0));
                    if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                        return "item_mk";
                    return "item";
                }
                else
                {
                    model.addAttribute("category", searchService.findByNamePharmacy(text));
                    if(session.getAttribute("lan")!=null && session.getAttribute("lan").equals("mk"))
                        return "category_mk";
                    return "category";
                }
            }

        }
        return "redirect:/";

    }

}
