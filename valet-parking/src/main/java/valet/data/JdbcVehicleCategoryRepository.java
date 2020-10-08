package valet.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import valet.VehicleCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcVehicleCategoryRepository implements VehicleCategoryRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcVehicleCategoryRepository(JdbcTemplate jdbcTemplate){
        this.jdbc = jdbcTemplate;
    }

    @Override
    public List<VehicleCategory> findAll() {
        return jdbc.query("select id, type from VehicleCategory", this::mapRowToVehicleCategory);
    }

    private VehicleCategory mapRowToVehicleCategory(ResultSet rs, int rowNum) throws SQLException {
        return new VehicleCategory(
                rs.getString("id"),
                VehicleCategory.Type.valueOf(rs.getString("type"))
        );
    }

    @Override
    public VehicleCategory findOne(String id) {
        return jdbc.queryForObject("select id, type from VehicleCategory where id=?", this::mapRowToVehicleCategory, id);
    }

    @Override
    public VehicleCategory save(VehicleCategory category) {
        jdbc.update(
                "insert into VehicleCategory (id, type) value (?, ?)",
                category.getId(),
                category.getType().toString()
        );
        return category;
    }
}
