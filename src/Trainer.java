import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by YeKuz20 on 12/13/2016.
 */
public class Trainer {
    private int[][][] trainingData; // game, move, location
    private int[] winners;

    public Trainer() {
        trainingData = readTrainingData();

        winners = new int[trainingData.length];

        for (int game = 0; game < trainingData.length; game++) {
            winners[game] = getWinner(trainingData[game][8]);
        }
    }

    public int[][][] getTrainingData() {
        return trainingData;
    }

    private int getWinner(int[] board) {
        if (board[0] == board[1] && board[1] == board[2] && board[0] != 0) return board[0];
        if (board[3] == board[4] && board[4] == board[5] && board[3] != 0) return board[3];
        if (board[6] == board[7] && board[7] == board[8] && board[6] != 0) return board[6];

        if (board[0] == board[3] && board[3] == board[6] && board[0] != 0) return board[0];
        if (board[1] == board[4] && board[4] == board[7] && board[1] != 0) return board[1];
        if (board[2] == board[5] && board[5] == board[8] && board[2] != 0) return board[2];

        if (board[0] == board[4] && board[4] == board[8] && board[0] != 0) return board[4];
        if (board[2] == board[4] && board[4] == board[6] && board[0] != 0) return board[4];

        return 0;
    }

    private int[][][] readTrainingData() {
        String[] lines = readTrainingData("trainingData.txt");

        int gamesCount = 1;

        for (String line : lines) {
            if (line.equals("\n")) gamesCount++;
        }

        String[][] games = new String[gamesCount][9];

        int[][][] out = new int[gamesCount][9][9];

        for (int game = 0; game < gamesCount; game++) {
            for (int line = 0; line < 9; line++) {
                String[] numbers = games[game][line].split(" ");
                for (int number = 0; number < 9; number++) {
                    out[game][line][number] = Integer.parseInt(numbers[number]);
                }
            }
        }

        return out;
    }

    private String[] readTrainingData(String path) {
        Scanner in = null;
        try {
            in = new Scanner(new File("trainingData.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lineCount = 1;
        while (in.hasNextLine())
            lineCount++;

        in.reset();

        String[] lines = new String[lineCount];

        for (int i = 0; i < lineCount; i++) {
            lines[i] = in.nextLine();
        }

        return lines;
    }
}
