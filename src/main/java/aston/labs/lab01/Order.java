package aston.labs.lab01;

import lombok.Getter;

final public class Order {
    @Getter
    private final Client client;

    @Getter
    private final Automobile auto;

    @Getter
    private final int rentDaysNumber;

    public Order(Client client,
                 Automobile auto,
                 int rentDaysNumber) {
      this .client = client;
      this.auto = auto;
      this.rentDaysNumber = rentDaysNumber;
    }
}
