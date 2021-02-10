import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int test = inp.nextInt();

        for (int t = 0; t < test; t++){
            int quantityOfLine = inp.nextInt();
            int cnt = 0;
            for (int q = 0; q < quantityOfLine; q++){
                String letters = inp.next();
                for (int i = 0; i < letters.length(); i++){
                    char ch = letters.charAt(i);
                    int index = ch - 65;
                    cnt += q + i + index;
                }
            }
            System.out.println(cnt);
        }
    }
}
