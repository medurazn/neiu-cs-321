package valet.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import valet.VehicleInfo;
import valet.VehicleInfo.Type;


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

    @ModelAttribute
    public void addAttributes(Model model) {
        List<VehicleInfo> vehicles = createVehicleInfoList();
        Type[] types = VehicleInfo.Type.values();
        for(Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(vehicles, type));
        }
    }

    private List<VehicleInfo> filterByType(List<VehicleInfo> vehicles, Type type) {
        return vehicles
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    private List<VehicleInfo> createVehicleInfoList() {
        List<VehicleInfo> vehicles = Arrays.asList(
                new VehicleInfo("CHEVY", "Impala", Type.SEDAN),
                new VehicleInfo("CHEVY", "Cruze", Type.SEDAN),
                new VehicleInfo("CHEVY", "Equinox", Type.SUV),
                new VehicleInfo("CHEVY", "Corvette", Type.SPORTS),
                new VehicleInfo("CHEVY", "Colorado", Type.PICKUP),
                new VehicleInfo("CHEVY", "Silverado", Type.PICKUP),
                new VehicleInfo("CHEVY", "Malibu", Type.COMPACT),
                new VehicleInfo("TOYOTA", "RAV4", Type.SUV),
                new VehicleInfo("TOYOTA", "Avalon", Type.SEDAN),
                new VehicleInfo("TOYOTA", "Camry", Type.SEDAN),
                new VehicleInfo("TOYOTA", "Highlander", Type.SUV),
                new VehicleInfo("TOYOTA", "Tacoma", Type.PICKUP),
                new VehicleInfo("TOYOTA", "Tundra", Type.PICKUP),
                new VehicleInfo("TOYOTA", "Sienna", Type.MINIVAN),
                new VehicleInfo("JEEP", "Cherokee", Type.SUV),
                new VehicleInfo("JEEP", "Wrangler", Type.SUV),
                new VehicleInfo("VW", "Jetta", Type.SEDAN),
                new VehicleInfo("ACURA", "MDX", Type.SUV),
                new VehicleInfo("ACURA", "RDX", Type.SUV),
                new VehicleInfo("TESLA", "Model 3", Type.LUXURY),
                new VehicleInfo("TESLA", "Model S", Type.LUXURY),
                new VehicleInfo("TESLA", "Model X", Type.LUXURY),
                new VehicleInfo("CHRYSLER", "Pacifica", Type.MINIVAN),
                new VehicleInfo("FORD", "Mustang", Type.CONVERTIBLE),
                new VehicleInfo("FORD", "MustangC", Type.COUPE),
                new VehicleInfo("FORD", "MustangS", Type.SPORTS),
                new VehicleInfo("FORD", "Fusion", Type.SEDAN),
                new VehicleInfo("FORD", "F-150", Type.PICKUP),
                new VehicleInfo("FORD", "Ranger", Type.PICKUP),
                new VehicleInfo("FORD", "Explorer", Type.SUV),
                new VehicleInfo("FORD", "Fiesta", Type.COMPACT),
                new VehicleInfo("FORD", "Escape", Type.SUV),
                new VehicleInfo("NISSAN", "Versa", Type.COMPACT),
                new VehicleInfo("NISSAN", "Altima", Type.SEDAN),
                new VehicleInfo("NISSAN", "Maxima", Type.SEDAN),
                new VehicleInfo("NISSAN", "ROGUE", Type.SUV),
                new VehicleInfo("HONDA", "Civic", Type.SEDAN),
                new VehicleInfo("HONDA", "CivicH", Type.HATCHBACK),
                new VehicleInfo("HONDA", "Accord", Type.SEDAN),
                new VehicleInfo("HONDA", "CR-V", Type.SUV),
                new VehicleInfo("HONDA", "Odyssey", Type.MINIVAN),
                new VehicleInfo("HYUNDAI", "Elantra", Type.COMPACT),
                new VehicleInfo("DODGE", "Ram", Type.PICKUP),
                new VehicleInfo("DODGE", "Grand Caravan", Type.MINIVAN),
                new VehicleInfo("DODGE", "Charger", Type.SEDAN),
                new VehicleInfo("DODGE", "Challenger", Type.COUPE),
                new VehicleInfo("DODGE", "Journey", Type.SUV),
                new VehicleInfo("DODGE", "Durango", Type.SUV),
                new VehicleInfo("MASERATI", "Ghibli", Type.SEDAN),
                new VehicleInfo("MASERATI", "Levante", Type.SUV),
                new VehicleInfo("FERRARI", "America", Type.LUXURY),
                new VehicleInfo("LAMBORGHINI", "Veneno", Type.LUXURY),
                new VehicleInfo("ROVER", "Sport", Type.SUV),
                new VehicleInfo("ROVER", "Discovery", Type.SUV)
        );
        return vehicles;

    }
}
