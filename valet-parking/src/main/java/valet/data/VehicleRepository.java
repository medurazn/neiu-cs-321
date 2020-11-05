package valet.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import valet.User;
import valet.Vehicle;

import java.util.List;

public interface VehicleRepository  extends CrudRepository<Vehicle, Long> {

    List<Vehicle> findAll();

    Vehicle findByTicket(String ticket);

    List<Vehicle> findAllByUser(User user, Pageable pageable);
}
