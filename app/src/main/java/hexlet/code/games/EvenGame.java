package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = (int) (Math.random() * 100) + 1;
            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            roundsData[i][0] = String.valueOf(number);
            roundsData[i][1] = correctAnswer;
        }

        Engine.run(GAME_DESCRIPTION, roundsData);
    }
}
