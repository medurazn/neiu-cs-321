package valet.data;

import valet.VehicleCategory;

import java.util.List;

public interface VehicleCategoryRepository {

    List<VehicleCategory> findAll();

    VehicleCategory findOne(String id);

    VehicleCategory save(VehicleCategory category);
}
