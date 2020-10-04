package valet.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import valet.Vehicle;
import valet.VehicleCategory.Type;
import valet.VehicleCategory;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @GetMapping
    public String showVehicleForm() {

        return "vehicle";
    }

    @PostMapping
    public String processVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, Errors errors) {
        if(errors.hasErrors()){
            return "vehicle";
        }

        return "redirect:/vehicles/current";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        List<VehicleCategory> categories = createVehicleCategoryList();
        model.addAttribute("categories", categories);
        model.addAttribute("vehicle", new Vehicle());
    }

    private List<VehicleCategory> createVehicleCategoryList() {
        List<VehicleCategory> categories = Arrays.asList(
                new VehicleCategory("SDN", Type.SEDAN),
                new VehicleCategory("CPE", Type.COUPE),
                new VehicleCategory("TRK", Type.TRUCK),
                new VehicleCategory("HTK", Type.HATCHBACK),
                new VehicleCategory("SPT", Type.SPORT),
                new VehicleCategory("CVT", Type.CONVERTIBLE)

        );
        return categories;
    }
}
