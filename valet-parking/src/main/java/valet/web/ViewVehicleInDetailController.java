package valet.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import valet.Vehicle;
import valet.data.VehicleCategoryRepository;
import valet.data.VehicleRepository;

@Slf4j
@Controller
@RequestMapping("/view")
public class ViewVehicleInDetailController {

    private VehicleRepository vehicleRepo;
    private VehicleCategoryRepository categoryRepo;

    @Autowired
    public ViewVehicleInDetailController(VehicleRepository vehicleRepo, VehicleCategoryRepository categoryRepo) {
        this.vehicleRepo = vehicleRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/{vehicleId}")
    public String updateVehicle(@PathVariable("vehicleId") long id, Model model) {
        Vehicle vehicle = vehicleRepo.findById(id).get();
        model.addAttribute("vehicle", vehicle);
        return "view-in-detail";
    }

}
