package valet;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class VehicleCategory {

    @Id
    private final String id;

    @Enumerated(EnumType.STRING)
    private final Type type;

    public static enum Type {
        SEDAN, COUPE, TRUCK, HATCHBACK, SPORT, CONVERTIBLE

    }
}