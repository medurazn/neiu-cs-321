package valet.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicles")
public class VehicleSavedController {

    @GetMapping("/current")
    public String savedVehicles(){
        return "vehicleForm";
    }

}
