package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final char[] OPERATIONS = {'+', '-', '*'};

    public static void start() {
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num1 = (int) (Math.random() * 50) + 1;
            int num2 = (int) (Math.random() * 50) + 1;
            char operation = OPERATIONS[(int) (Math.random() * OPERATIONS.length)];

            String question = num1 + " " + operation + " " + num2;
            String correctAnswer = String.valueOf(calculate(num1, num2, operation));

            roundsData[i][0] = question;
            roundsData[i][1] = correctAnswer;
        }

        Engine.run(GAME_DESCRIPTION, roundsData);
    }

    private static int calculate(int a, int b, char operation) {
        switch (operation) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
}
