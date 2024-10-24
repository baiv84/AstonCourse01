package aston.labs;

import java.util.Random;

final public class Tools {
    public static boolean imitateRandomWreck() {
        int randomNum = new Random().nextInt(100);
        return randomNum < 5;
    }
}
