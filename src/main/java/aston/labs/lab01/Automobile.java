package aston.labs.lab01;

import lombok.Getter;
import lombok.Setter;

final public class Automobile {
    @Getter
    private final String mark;

    @Getter
    private final Double price;

    @Getter
    @Setter
    private Boolean isBroken;

    public Automobile(String mark,
                      Double price) {
        this.mark = mark;
        this.price = price;
        this.isBroken = false;
    }

    @Override
    public String toString() {
        return "Mark: " + this.mark + " price: " + this.price;
    }
}
