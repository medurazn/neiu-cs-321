package valet;

import lombok.Data;

@Data
public class VehicleCategory {
    private final String id;
    private final Type type;

    public static enum Type {
        SEDAN, COUPE, TRUCK, HATCHBACK, SPORT, CONVERTIBLE

    }
}