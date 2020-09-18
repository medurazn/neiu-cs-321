package valet;

import lombok.Data;

@Data
public class VehicleInfo {
    private final String make;
    private final String model;
    private final Type type;

    public static enum Type {
        FORD, CHEVY, NISSAN, TESLA, TOYOTA, VW, HONDA, DODGE,
        LAMBORGHINI, FERRARI, HYUNDAI, JEEP, ACURA, ROVER, CHRYSLER,
        MASERATI
    }
}