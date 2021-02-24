public class Canvas {
    public static final int SIZE = 20;
    public static int counter = 0;

    private char[][] data;

    //    constructor
    public Canvas() {
        data = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                data[row][col] = '.';
            }
        }
        counter++;
    }

    //regular method
    public void set(int row, int col) {
        if (row < 0 || SIZE <= row || col < 0 || SIZE <= col) {
            throw new RuntimeException("Improper row or column assigned: [" + row + "," + col + "]");
        }
        data[row][col] = '*';
    }

    public void show() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(data[row][col]);
            }
            System.out.println();
        }
    }

    public boolean isOnCanvas(int row, int col) {
        return 0 <= row && row < SIZE && 0 <= col && col < SIZE;
    }

    public static void main(String[] args) {


    }
}
