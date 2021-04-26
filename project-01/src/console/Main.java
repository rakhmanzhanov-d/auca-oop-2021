package console;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = null;

        Scanner inp = new Scanner(System.in);
        game = parseArguments(args, usage());

        // starter minesweeper
        System.out.println(game);

        // reading input commands
        while (true) {
            System.out.print("Command: ");
            String cmd = inp.nextLine();
            Scanner strCmd = new Scanner(cmd);

            String command = strCmd.next();
            int row, col;
            switch (command) {
                case "quit":
                    System.out.println("You stopped game");
                    System.exit(0);
                    break;
                case "show":
                    System.out.println("The game will be mined after first left click");
                    System.out.println();
                    System.out.println(game.show());
                    break;
                case "left":
                    row = strCmd.nextInt();
                    col = strCmd.nextInt();
                    game.left(row, col);
                    System.out.println(game);
                    if (!game.chekValidness()) {
                        System.out.println("GAME OVER");
                        System.out.println("I believe you can do it next time, Keep trying");
                        System.exit(0);
                    }
                    break;
                case "right":
                    row = strCmd.nextInt();
                    col = strCmd.nextInt();
                    game.right(row, col);
                    System.out.println(game);
                    if (game.wonGame()) {
                        System.out.println("CONGRATULATIONS YOU WON!!!!!");
                        System.out.println("YOOOOHOOOOOO");
                        System.exit(1);
                    }
                    break;
            }
        }
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

    private static Game parseArguments(String[] args, String usage) {
        int row = 9, col = 9, mines = 10;

        if (args.length == 3) {
            row = Integer.parseInt(args[0]);
            col = Integer.parseInt(args[1]);
            mines = Integer.parseInt(args[2]);

            if (mines >= row * col) {
                System.out.println("Incorrect mode mines >= row * col");
                System.out.println(usage);
                System.exit(0);
            }
            return new Game(row, col, mines, "CUSTOM");
        } else if (args.length == 1) {
            String level = args[0];
            if (level.equals("beginner")) {
                return new Game(9, 9, 10, "BEGINNER");
            } else if (level.equals("medium")) {
                return new Game(16, 16, 40, "MEDIUM");
            } else if (level.equals("expert")) {
                return new Game(30, 16, 99, "EXPERT");
            } else {
                System.out.println(usage);
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
            System.out.println(usage);
            System.exit(0);
        }
        return new Game(0, 0, 0, "");
    }
}
