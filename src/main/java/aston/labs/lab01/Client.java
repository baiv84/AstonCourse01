package aston.labs.lab01;

import lombok.Getter;
import lombok.Setter;

final public class Client {
    @Getter
    private final String idNumber;

    @Getter
    private final String fullName;

    @Getter
    @Setter
    private double balance;

    @Getter
    private final int age;

    public Client(String idNumber,
                  String fullName,
                  Double balance,
                  Integer age) {

        this.idNumber = idNumber;
        this.fullName = fullName;
        this.balance = balance;
        this.age = age;
    }

    @Override
    public String toString() {
        return "id: " + this.idNumber + " name: " + this.fullName + " age: " + this.age + " balance: " + balance;
    }
}
