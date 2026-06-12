package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeGame {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_NUMBER = 100;

    public static void start() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = (int) (Math.random() * MAX_NUMBER) + 1;
            String correctAnswer = isPrime(number) ? "yes" : "no";

            roundsData[i][0] = String.valueOf(number);
            roundsData[i][1] = correctAnswer;
        }

        Engine.run(GAME_DESCRIPTION, roundsData);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
