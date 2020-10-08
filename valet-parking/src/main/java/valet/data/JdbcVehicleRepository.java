package valet.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import valet.Vehicle;

import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Arrays;

@Repository
public class JdbcVehicleRepository implements VehicleRepository{

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcVehicleRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicle.setId(saveVehicleInfo(vehicle));
            jdbc.update("insert into Vehicle_Categories (vehicle, category) values (?, ?)",
                    vehicle.getId(), vehicle.getCategory());
        return vehicle;
    }

    private long saveVehicleInfo(Vehicle vehicle) {
        vehicle.setCreatedAt(LocalDateTime.now());
        PreparedStatementCreatorFactory pscFactory = new PreparedStatementCreatorFactory(
                "insert into Vehicle (make, model, color, year, ticket, location, plate, createdAt) values (?, ?, ?, ?, ?, ?, ?, ?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
        );
        pscFactory.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscFactory.newPreparedStatementCreator(
                Arrays.asList(vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear(),
                              vehicle.getTicket(), vehicle.getLocation(), vehicle.getPlate(),
                              Timestamp.valueOf(vehicle.getCreatedAt()))
        );

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }
}
