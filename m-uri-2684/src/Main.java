import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for (int i = 0; i < n; i++) {
            String readLine = "";
            String s = inp.next();
            for (int l = 0; l < s.length(); l++) {
                if (s.charAt(l) > 47 && s.charAt(l) < 58) {
                    readLine += s.charAt(l);
                } else {
                    readLine += " ";
                }
            }
            Scanner read = new Scanner(readLine);
            int num, res = 0;
            while (read.hasNextInt()) {
                num = read.nextInt();
                res += num;
            }
            System.out.println(res);
        }
    }
}
