package valet.data;

import org.springframework.data.repository.CrudRepository;
import valet.VehicleCategory;

public interface VehicleCategoryRepository  extends CrudRepository<VehicleCategory, String> {

}
