package valet.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import valet.VehicleInfo;
import valet.VehicleInfo.Type;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @GetMapping
    public String showVehicleForm() {

        return "vehicle";
    }

    @PostMapping
    public String processVehicle(@Valid @ModelAttribute("savedVehicle") Vehicle savedVehicle, Errors errors) {
        if(errors.hasErrors()){
            return "vehicle";
        }
        //save vehicle

        return "redirect:/vehicles/current";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        List<VehicleInfo> vehicles = createVehicleInfoList();
        Type[] types = VehicleInfo.Type.values();
        for(Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(vehicles, type));
        }
        model.addAttribute("savedVehicle", new Vehicle());
    }

    private List<VehicleInfo> filterByType(List<VehicleInfo> vehicles, Type type) {
        return vehicles
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    private List<VehicleInfo> createVehicleInfoList() {
        List<VehicleInfo> vehicles = Arrays.asList(
                new VehicleInfo("Sedan", "Impala", Type.CHEVY),
                new VehicleInfo("Sedan", "Cruze", Type.CHEVY),
                new VehicleInfo("SUV", "Equinox", Type.CHEVY),
                new VehicleInfo("Convertible", "Corvette", Type.CHEVY),
                new VehicleInfo("Pick-up", "Colorado", Type.CHEVY),
                new VehicleInfo("Pick-up", "Silverado", Type.CHEVY),
                new VehicleInfo("Sedan", "Malibu", Type.CHEVY),
                new VehicleInfo("SUV", "RAV4", Type.TOYOTA),
                new VehicleInfo("Sedan", "Avalon", Type.TOYOTA),
                new VehicleInfo("TOYOTA", "Camry", Type.TOYOTA),
                new VehicleInfo("TOYOTA", "Highlander", Type.TOYOTA),
                new VehicleInfo("TOYOTA", "Tacoma", Type.TOYOTA),
                new VehicleInfo("TOYOTA", "Tundra", Type.TOYOTA),
                new VehicleInfo("TOYOTA", "Sienna", Type.TOYOTA),
                new VehicleInfo("JEEP", "Cherokee", Type.JEEP),
                new VehicleInfo("JEEP", "Wrangler", Type.JEEP),
                new VehicleInfo("VW", "Jetta", Type.VW),
                new VehicleInfo("ACURA", "MDX", Type.ACURA),
                new VehicleInfo("ACURA", "RDX", Type.ACURA),
                new VehicleInfo("TESLA", "Model 3", Type.TESLA),
                new VehicleInfo("TESLA", "Model S", Type.TESLA),
                new VehicleInfo("TESLA", "Model X", Type.TESLA),
                new VehicleInfo("CHRYSLER", "Pacifica", Type.CHRYSLER),
                new VehicleInfo("FORD", "Mustang", Type.FORD),
                new VehicleInfo("FORD", "MustangC", Type.FORD),
                new VehicleInfo("FORD", "MustangS", Type.FORD),
                new VehicleInfo("FORD", "Fusion", Type.FORD),
                new VehicleInfo("FORD", "F-150", Type.FORD),
                new VehicleInfo("FORD", "Ranger", Type.FORD),
                new VehicleInfo("FORD", "Explorer", Type.FORD),
                new VehicleInfo("FORD", "Fiesta", Type.FORD),
                new VehicleInfo("FORD", "Escape", Type.FORD),
                new VehicleInfo("NISSAN", "Versa", Type.NISSAN),
                new VehicleInfo("NISSAN", "Altima", Type.NISSAN),
                new VehicleInfo("NISSAN", "Maxima", Type.NISSAN),
                new VehicleInfo("NISSAN", "ROGUE", Type.NISSAN),
                new VehicleInfo("HONDA", "Civic", Type.HONDA),
                new VehicleInfo("HONDA", "CivicH", Type.HONDA),
                new VehicleInfo("HONDA", "Accord", Type.HONDA),
                new VehicleInfo("HONDA", "CR-V", Type.HONDA),
                new VehicleInfo("HONDA", "Odyssey", Type.HONDA),
                new VehicleInfo("HYUNDAI", "Elantra", Type.HYUNDAI),
                new VehicleInfo("DODGE", "Ram", Type.DODGE),
                new VehicleInfo("DODGE", "Grand Caravan", Type.DODGE),
                new VehicleInfo("DODGE", "Charger", Type.DODGE),
                new VehicleInfo("DODGE", "Challenger", Type.DODGE),
                new VehicleInfo("DODGE", "Journey", Type.DODGE),
                new VehicleInfo("DODGE", "Durango", Type.DODGE),
                new VehicleInfo("MASERATI", "Ghibli", Type.MASERATI),
                new VehicleInfo("MASERATI", "Levante", Type.MASERATI),
                new VehicleInfo("FERRARI", "America", Type.FERRARI),
                new VehicleInfo("LAMBORGHINI", "Veneno", Type.LAMBORGHINI),
                new VehicleInfo("ROVER", "Sport", Type.ROVER),
                new VehicleInfo("ROVER", "Discovery", Type.ROVER)
        );
        return vehicles;

    }
}
