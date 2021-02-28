import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for (int i = 0; i < n; i++){
            int a = inp.nextInt();
            int b = inp.nextInt();
            StringBuilder res = new StringBuilder();
            for(int k = a; k <= b; k++){
                res.append(k);
            }
            System.out.print(res);
            System.out.println(res.reverse());
        }
    }
}
