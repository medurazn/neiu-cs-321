package valet.data;

import valet.Vehicle;

import java.util.List;

public interface VehicleRepository {

    Vehicle save(Vehicle vehicle);

    List<Vehicle> findAll();
}
