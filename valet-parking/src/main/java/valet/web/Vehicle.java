package valet.web;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import valet.VehicleInfo;

import javax.validation.constraints.*;
import javax.websocket.OnMessage;
import java.util.List;

@Data
public class Vehicle {

    @NotNull(message="The name is required")
    @Size(min = 5, message = "Name must be at least 5 characters long.")
    private String name;

    @NotNull(message="The color is required")
    @Size(min = 3, message = "Color must be at least 3 characters long.")
    private String color;

    @Min(value = 4, message = "Needs to be 4 characters long")
    @NotNull(message="The year is required")
    private Integer year;


    private String ticket;
    private String location;
    private String plate;

    @NotEmpty(message="You must choose at least one model")
//    @Max(value = 1)
    private List<String> vehicles;

}
