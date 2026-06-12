package hexlet.code.games;

import hexlet.code.Engine;

public class GcdGame {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void start() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num1 = (int) (Math.random() * 100) + 1;
            int num2 = (int) (Math.random() * 100) + 1;

            String question = num1 + " " + num2;
            String correctAnswer = String.valueOf(gcd(num1, num2));

            roundsData[i][0] = question;
            roundsData[i][1] = correctAnswer;
        }

        Engine.run(GAME_DESCRIPTION, roundsData);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
