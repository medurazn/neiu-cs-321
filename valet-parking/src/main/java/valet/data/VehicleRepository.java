package valet.data;

import org.springframework.data.repository.CrudRepository;
import valet.Vehicle;

import java.util.List;

public interface VehicleRepository  extends CrudRepository<Vehicle, Long> {

    List<Vehicle> findAll();
}
