package valet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import valet.Vehicle;
import valet.data.VehicleRepository;

import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {

    private VehicleRepository vehicleRepo;

    @Autowired
    public DataController(VehicleRepository vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @GetMapping
    public String showData(Model model) {
        List<Vehicle> vehicles = vehicleRepo.findAll();
        model.addAttribute("vehicles", vehicles);
        return "data";
    }

}
