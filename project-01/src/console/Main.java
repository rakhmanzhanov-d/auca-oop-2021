package console;

import java.util.Scanner;

public class Main {
    private static Data data;
    protected static int[][] mines;
    protected static boolean[][] reveals;
    protected static boolean[][] flags;
    public static boolean firstClick;
    protected static int row, col, numMines, numFlags, curState, minesLeft;

    public Main() {
        firstClick = true;
        curState = 0;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        // 1. init game
        data = parseArguments(args);
        mines = data.getMinesData();
        flags = data.getFlagsData();
        reveals = data.getRevealsData();
        curState = 0;
        firstClick = true;


        // showing starter data
        System.out.println(String.format("Game (row: %d,  col: %d,  mines: %d)", row, col, numMines));
        System.out.println(data);

        while (true) {
            System.out.print("Command: ");
            String cmd = inp.nextLine();
            Scanner strCmd = new Scanner(cmd);

            String command = strCmd.next();

            switch (command) {
                case "quit" -> {
                    System.out.println("You stopped game");
                    System.exit(0);
                }
                case "show" -> {
                    System.out.println("Game starts after first left click");
                    System.out.println();
                    System.out.println(data);
                }
                case "left" -> {
                    int r = strCmd.nextInt() - 1;
                    int c = strCmd.nextInt() - 1;
                    if (flags[r][c]) break; // do nothing if it is flag

                    if (strCmd.hasNext()) {
                        System.out.printf("Too many arguments %d %d %s\n", row, col, strCmd.nextLine());

                        break;
                    }
                    if (firstClick) {
                        firstClick = false;

                        do {
                            data.clearMines();
                            data.placeMines();
                        } while (data.calcNear(r, c) > 0);

                    }

                    if (mines[r][c] > 0) {
                        System.out.println("Game over");
                        System.out.println(data.show());
                        System.exit(0);
                    } else {
                        data.reveal(r, c);
                        if (minesLeft == 0) {
                            System.out.println("CONGRATULATIONS!!! YOU WON GAME");
                        }
                    }
                }
                case "right" -> {
                    int r = strCmd.nextInt() - 1;
                    int c = strCmd.nextInt() - 1;

                    if (reveals[r][c]) break; // do nothing if it is revealed

                    flags[r][c] = !flags[r][c];

                    if (flags[r][c] && mines[r][c] != 0) {
                        numFlags++;
                        minesLeft--;
                        if (numFlags == numMines) {
                            System.out.println(data);
                            System.out.println("CONGRATULATIONS!!! YOU WON GAME");
                            System.exit(1);
                        }
                    } else if (!flags[r][c] && mines[r][c] != 0) {
                        minesLeft++;
                    }

                    System.out.println(data);
                }
            }
        }
    }

    private static Data parseArguments(String[] args) {

        // User chooses manually the number of mines, rows and cols
        if (args.length == 3) {
            row = Integer.parseInt(args[0]);
            col = Integer.parseInt(args[1]);
            numMines = Integer.parseInt(args[2]);
            minesLeft = numMines;

            // Error handling
            if (numMines >= row * col) {
                System.out.println("Incorrect mode mines >= row * col");
                System.out.println(usage());
                System.exit(0);
            }

            return new Data(row, col, numMines);
        } else if (args.length == 1) {
            String level = args[0];
            if (level.equals("beginner")) {
                row = 9;
                col = 9;
                numMines = 10;
                minesLeft = numMines;
                return new Data(row, col, numMines);
            } else if (level.equals("medium")) {
                row = 16;
                col = 16;
                minesLeft = numMines;
                numMines = 40;
                return new Data(row, col, numMines);
            } else if (level.equals("expert")) {
                row = 30;
                col = 16;
                minesLeft = numMines;
                numMines = 99;
                return new Data(row, col, numMines);
            } else {
                System.out.println(usage());
                System.exit(0);
            }
        } else {
            System.out.print("Incorrect app args: ");
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println(usage());
            System.exit(0);
        }
        return null;
    }

    public static String usage() {

        String usg = "-java -jar Minesweeper.jar beginner\n" +
                "      - game in the beginner mode row=9, col=9, mines=10\n" +
                "-java -jar Minesweeper.jar medium\n" +
                "      - game in the medium mode row=16, col=16, mines=40\n" +
                "-java -jar Minesweeper.jar expert\n" +
                "      - game in the expert mode row=30, col=16, mines=99\n";
        return usg;
    }
}
