package valet.web;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import valet.VehicleCategory;

import javax.validation.constraints.*;
import javax.websocket.OnMessage;
import java.util.List;

@Data
public class Vehicle {

    @NotNull(message="The make is required")
    @Size(min = 3, message = "Make must be at least 3 characters long.")
    private String make;

    @NotNull(message="The model is required")
    @Size(min = 3, message = "Model must be at least 3 characters long.")
    private String model;

    @NotNull(message="The color is required")
    @Size(min = 3, message = "Color must be at least 3 characters long.")
    private String color;

    @Min(value = 4, message = "Needs to be 4 characters long")
    @NotNull(message="The year is required ####")
    private Integer year;

    @NotNull(message="The ticket is required")
    @Size(min = 7, message = "The Ticket must be at least 7 characters long with the format 123-456")
    private String ticket;

    @NotNull(message="The location is required")
    @Size(min = 2, message = "Location must be at least 2 characters long.")
    private String location;

    @NotNull(message="The plate is required")
    @Size(min = 1, max = 8, message = "Plate number must be at least 1 character and 8 characters max")
    private String plate;

    @NotEmpty(message="You must choose at least one model")
    private String category;
}
