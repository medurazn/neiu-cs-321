package valet.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import valet.Vehicle;
import valet.data.VehicleRepository;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/display_vehicle")
public class DisplayVehicleController {

    private final VehicleRepository vehicleRepo;

    public DisplayVehicleController(VehicleRepository vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @GetMapping
    public String displayVehicle() {

        return "display_vehicle";
    }

    @ModelAttribute("vehicles")
    public List<Vehicle> vehicles() {

        return  vehicleRepo.findAll();
    }

}
