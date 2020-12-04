package valet.web;

import jdk.jfr.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import valet.Vehicle;
import valet.VehicleCategory;
import valet.data.VehicleCategoryRepository;
import valet.data.VehicleRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/modify")
public class ModifyVehicleController {

    private VehicleRepository vehicleRepo;
    private VehicleCategoryRepository categoryRepo;

    @Autowired
    public ModifyVehicleController(VehicleRepository vehicleRepo, VehicleCategoryRepository categoryRepo) {
        this.vehicleRepo = vehicleRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/{vehicleId}")
    public String updateVehicle(@PathVariable("vehicleId") long id, Model model) {
        Vehicle vehicle = vehicleRepo.findById(id).get();
        model.addAttribute("vehicle", vehicle);
        addCategoryToModel(model);
        return "update-vehicle";
    }

    @PostMapping("/update/{vehicleId}")
    public String processUpdateVehicle(@PathVariable("vehicleId") long id, @Valid @ModelAttribute("vehicle") Vehicle vehicle, Errors errors) {
        if(errors.hasErrors())
            return "update-vehicle";

        Vehicle newVehicle = vehicleRepo.findById(id).get();
        newVehicle.setTicket(vehicle.getTicket());
        newVehicle.setCategory(vehicle.getCategory());
        newVehicle.setMake(vehicle.getMake());
        newVehicle.setModel(vehicle.getModel());
        newVehicle.setColor(vehicle.getColor());
        newVehicle.setYear(vehicle.getYear());
        newVehicle.setLocation(vehicle.getLocation());
        newVehicle.setPlate(vehicle.getPlate());
        vehicleRepo.save(newVehicle);
        log.info("Processing...." + newVehicle);

        return "redirect:/display_vehicle";
    }

    private void addCategoryToModel(Model model) {
        List<VehicleCategory> categories = (List<VehicleCategory>) categoryRepo.findAll();
        model.addAttribute("categories", categories);
    }

//    @RequestMapping(value = "/delete/{vehicleId}")
//    public String deleteVehicle(@PathVariable("vehicleId") long id) {
//        vehicleRepo.deleteById(id);
//        return "redirect:/display_vehicle";
//
//    }

    @DeleteMapping("/delete/{vehicleId}")
    @ResponseStatus (code = HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable("vehicleId") long id){
        try {
            vehicleRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {}
    }
}
