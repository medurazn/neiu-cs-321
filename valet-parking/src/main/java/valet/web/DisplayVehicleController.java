package valet.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import valet.User;
import valet.Vehicle;
import valet.data.VehicleRepository;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/display_vehicle")
public class DisplayVehicleController {

    private final VehicleRepository vehicleRepo;
    private VehicleProps props;

    @Autowired
    public DisplayVehicleController(VehicleRepository vehicleRepo, VehicleProps props) {
        this.vehicleRepo = vehicleRepo;
        this.props = props;
    }

    @GetMapping
    public String displayVehicle() {

        return "display_vehicle";
    }

    @ModelAttribute("vehicles")
    public List<Vehicle> vehicles(Model model, @AuthenticationPrincipal User user) {

        Pageable pageable = (Pageable) PageRequest.of(0, props.getPageSize());

        return vehicleRepo.findAllByUser(user, pageable);
    }

}
