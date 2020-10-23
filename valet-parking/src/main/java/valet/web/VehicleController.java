package valet.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import valet.data.VehicleCategoryRepository;
import valet.data.VehicleRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleCategoryRepository categoryRepo;
    private final VehicleRepository vehicleRepo;

    @Autowired
    public VehicleController(VehicleCategoryRepository categoryRepo, VehicleRepository vehicleRepo) {
        this.categoryRepo = categoryRepo;
        this.vehicleRepo = vehicleRepo;
    }

    @GetMapping
    public String showVehicleForm() {

        return "vehicle";
    }

    @PostMapping
    public String processVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, Errors errors) {
        if(errors.hasErrors())
            return "vehicle";

        try {
            Vehicle savedVehicle = vehicleRepo.save(vehicle);
        }catch (DataIntegrityViolationException e) {
            errors.rejectValue("ticket", "invalidTicket", "Ticket not available. Please choose another ticket.");
            return "/vehicle";
        }
        Vehicle savedVehicle = vehicleRepo.save(vehicle);
        log.info("Processing..." + vehicle);
        return "redirect:/vehicles/current";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        List<VehicleCategory> categories = (List<VehicleCategory>) categoryRepo.findAll();
        model.addAttribute("categories", categories);
    }

    @ModelAttribute(name = "vehicle")
    public Vehicle addVehicleToModel() {
        return new Vehicle();
    }

}
