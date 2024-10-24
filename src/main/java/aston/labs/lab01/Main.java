package aston.labs.lab01;

import aston.labs.LabRunner;
import aston.labs.OperationStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

final public class Main implements LabRunner {
    public Main() { }

    @Override
    public void run() {
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\nAston Course: Lab1 implementation (classes and object)\n");
        Administrator administrator = new Administrator();

        List<Automobile> automobiles = new ArrayList<>(Arrays.asList(
                new Automobile("BMW", 828734.0),
                new Automobile("Toyota", 123457.0),
                new Automobile("Lada", 567345.0),
                new Automobile("Mercedes", 2234567.0),
                new Automobile("Nissan", 4567312.0))
        );

        List<Client> clients = new ArrayList<>(Arrays.asList(
                new Client("0402 124564", "John Lord",123780.9, 51),
                new Client("0404 765123", "Patrick Roy",1437238.9, 17),
                new Client("0423 876443", "Susane Rise",1008970.0, 47),
                new Client("0409 223432", "Phil Collins", 14372386.9, 22),
                new Client("0407 112334", "Matt Daemon",100000.0, 34))

        );

        while (automobiles.size() > 0) {
            int indexClient = new Random().nextInt(clients.size());
            Client client = clients.get(indexClient);

            int indexAuto = new Random().nextInt(automobiles.size());
            Automobile auto = automobiles.get(indexAuto);

            int numOfRentDays = new Random().nextInt(30);
            Order order = new Order(client, auto, numOfRentDays);
            OperationStatus status =  administrator.makeDeal(order);

            if (status == OperationStatus.WRECKED_CAR) {
                System.out.println("Car was wrecked");
                automobiles.remove(auto);
            }

            if (status == OperationStatus.OK) {
                System.out.println("Car was sold!");
                automobiles.remove(auto);
            }

            System.out.println(client);
            System.out.println(auto);
            System.out.println(status);
            System.out.println("***********************\n");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("FINISH! No cars left to rent.");
    }
}
