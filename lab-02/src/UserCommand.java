import java.util.Scanner;

public class UserCommand {
    private String command;
    public static final String PEN_UP = "PenUp";
    public static final String PEN_DOWN = "PenDown";
    public static final String TURN_LEFT = "TurnLeft";
    public static final String TURN_RIGHT = "TurnRight";
    public static final String MOVE = "Move";
    public static final String PRINT = "Print";
    public static final String EXIT = "Exit";

    static int numberOfSteps;
    static int numOfLine = 0;

    public UserCommand(String line) {
        line = line.trim();
        numOfLine++;
        switch (line) {
            case PEN_UP:
            case PEN_DOWN:
            case PRINT:
            case TURN_LEFT:
            case TURN_RIGHT:
            case EXIT:
                command = line;
                numberOfSteps = 0;
                return;
        }
        Scanner inpLine = new Scanner(line);
        if (!inpLine.hasNext()) {
            throw new RuntimeException("Wrong command: '" + line + "'");
        }
        String tmpCmd = inpLine.next();
        if (!tmpCmd.equals("Move")) {
            throw new RuntimeException("Unknown command: '" + line + "'");
        }
        if (!inpLine.hasNextInt()) {
            throw new RuntimeException("No integer in command 'Move': '" + line + "'");
        }
        int tmpNumberOfSteps = inpLine.nextInt();
        if (tmpNumberOfSteps < 0) {
            throw new RuntimeException("Negative integer in command 'Move': '" + line + "'");
        }
        if (inpLine.hasNext()) {
            throw new RuntimeException("Too many parameters in command 'Move' : '" + line + "'");
        }

        command = tmpCmd;
        numberOfSteps = tmpNumberOfSteps;

    }

    //    getter
    public String getCommand() {
//        if(!command.equals(MOVE)){
//            throw new RuntimeException("Error in inserting number of command " + command);
//        }
        return command;
    }

    //    getter
    public int getNumOfSteps() {
        return numberOfSteps;
    }

}
