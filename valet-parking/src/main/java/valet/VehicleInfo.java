package valet;

import lombok.Data;

@Data
public class VehicleInfo {
    private final String make;
    private final String model;
    private final Type type;
//    private final String color;
//    private final int year;
//    private final int tixNum;
//    private final String location;
//    private final String plateNum;
//    private final String initials;

    public static enum Type {
        SEDAN, COUPE, SUV, PICKUP, HATCHBACK, SPORTS,
        LUXURY, MINIVAN, COMPACT, CONVERTIBLE, CROSSOVER, VAN
    }
}