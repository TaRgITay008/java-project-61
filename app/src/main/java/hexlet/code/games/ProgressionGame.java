package hexlet.code.games;

import hexlet.code.Engine;

public class ProgressionGame {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_START = 1;
    private static final int MAX_START = 20;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;

    public static void start() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int length = MIN_LENGTH + (int) (Math.random() * (MAX_LENGTH - MIN_LENGTH + 1));
            int start = MIN_START + (int) (Math.random() * (MAX_START - MIN_START + 1));
            int step = MIN_STEP + (int) (Math.random() * (MAX_STEP - MIN_STEP + 1));
            int hiddenIndex = (int) (Math.random() * length);

            String[] progression = generateProgression(start, step, length);
            int hiddenValue = Integer.parseInt(progression[hiddenIndex]);
            progression[hiddenIndex] = "..";

            String question = String.join(" ", progression);
            String correctAnswer = String.valueOf(hiddenValue);

            roundsData[i][0] = question;
            roundsData[i][1] = correctAnswer;
        }

        Engine.run(GAME_DESCRIPTION, roundsData);
    }

    private static String[] generateProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }
}
