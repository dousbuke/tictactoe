package game;

import model.Movement;

import java.util.Random;

public class AIMove {

    private static Random generator = new Random();

    public static Movement compRandomMove(int size) {
        return Movement.builder()
                .row(generateNumber(size))
                .column(generateNumber(size))
                .build();
    }

    private static int generateNumber(int size) {
        return generator.nextInt(size);
    }


}
