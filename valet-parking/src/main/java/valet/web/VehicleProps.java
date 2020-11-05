package valet.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "valet.vehicles")
@Data
public class VehicleProps {

    private int pageSize;
}
