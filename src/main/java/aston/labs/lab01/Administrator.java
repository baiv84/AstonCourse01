package aston.labs.lab01;

import java.util.ArrayList;
import java.util.List;
import aston.labs.Tools;
import aston.labs.OperationStatus;

final public class Administrator {
    private final List<Client> blackList = new ArrayList<>();

    private void performOrder(Order order) {
        Client client = order.getClient();
        double orderPrice = order.getAuto().getPrice();
        client.setBalance(client.getBalance() - orderPrice);
    }

    private OperationStatus evaluateOrder(Order order) {
        Client client = order.getClient();
        Automobile auto = order.getAuto();

        double clientBalance = client.getBalance();
        double orderPrice = auto.getPrice();
        int clientAge = client.getAge();

        OperationStatus status = OperationStatus.OK;

        if (clientAge < 18 || clientAge >= 70) {
            status = OperationStatus.CLIENT_INCORRECT_AGE;
        }

        if (clientBalance < orderPrice) {
            status = OperationStatus.INSUFFICIENT_MONEY;
        }

        if (blackList.contains(client)) {
            status = OperationStatus.CLIENT_BANNED;
        }

        if (Tools.imitateRandomWreck()) {
            status = OperationStatus.WRECKED_CAR;
            blackList.add(client);
        }

        return status;
    }

    public Administrator() {}

    public OperationStatus makeDeal(Order order) {
        OperationStatus status = evaluateOrder(order);
        if (status == OperationStatus.OK) {
            performOrder(order);
        }
    return status;
    }
}
