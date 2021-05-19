package easy;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameModel {
    private int curLevel;
    public char[][][] levels;
    public Maze maze;  // current level puzzle
    String[][] curPuzzle;


    public GameModel() {
        this.curLevel = 0;
        levels = parseLevels();
        maze = new Maze(levels[curLevel]);
    }

    private char[][][] parseLevels() {
        char[][][] mainArray = new char[40][][];
        ArrayList<String> list = new ArrayList<>();
        StringBuilder curPuzzle = new StringBuilder();
        try (Scanner inp = new Scanner(new File("levels/Minicosmos.txt"))) {
            while (inp.hasNextLine()) {
                String line = inp.nextLine();
                if (line.length() == 0) {
                    continue;
                }
                if (line.startsWith(";")) {
                    list.add(curPuzzle.toString());
                    curPuzzle = new StringBuilder();
                } else {
                    curPuzzle.append(line).append("\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int index = 0;
        for (String str : list) {
            int maxLength = 0;
            Scanner inp = new Scanner(str);
            while (inp.hasNextLine()) {
                String line = inp.nextLine();
                maxLength = Math.max(maxLength, line.length());
            }


            char[][] newLevelsList = new char[8][maxLength];
            Scanner input = new Scanner(str);
            int col = 0;
            while (input.hasNextLine() && col < 8) {
                char[] arr = new char[maxLength];
                String line = input.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    arr[i] = line.charAt(i);
                }
                if (line.length() < maxLength) {
                    for (int i = line.length(); i < maxLength; i++) {
                        arr[i] = ' ';
                    }
                }
                newLevelsList[col] = arr;
                col++;
            }
            mainArray[index] = newLevelsList;
            index++;
        }
        return mainArray;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(levels[39]);
    }

    public void nextLevel() {
        curLevel++;
        if (curLevel == levels.length) {
            curLevel = 0;
        }

        maze = new Maze(levels[curLevel]);
    }

    public int getCurLevel() {
        return curLevel + 1;
    }

    public void reset() {
        System.out.println(maze);
        maze = new Maze(parseLevels()[curLevel]);
    }

    public void prevLevel() {
        curLevel--;
        if (curLevel < 0) {
            curLevel = 39;
        }

        maze = new Maze(levels[curLevel]);
    }
}

