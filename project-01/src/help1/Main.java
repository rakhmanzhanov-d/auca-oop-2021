package help1;

public class Main {
    static String[] input = {
            ".........",
            "..*......",
            ".........",
            "..*......",
            ".........",
            ".........",
            "...**....",
            ".........",
            ".*.......",
    };
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        int h = input.length;
        int w = input[0].length();
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[row].length(); col++) {
                if (input[row].charAt(col) == '*') {
                    System.out.print("*");
                } else {
                    int nMines = 0;
                    for (int i = 0; i < dr.length; i++) {
                        int tr = row * dr[i];
                        int tc = col * dc[i];
                        if (0 <= tr && tr < h && 0 <= tc && tc < w && input[tr].charAt(tc) == '*') {
                            nMines++;
                        }
                    }
                    System.out.print(nMines);
                }
            }
            System.out.println();
        }
    }
}
