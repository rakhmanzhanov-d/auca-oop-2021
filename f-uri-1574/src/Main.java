import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();

        inp.nextLine();
        while (n-- > 0){
            int cnt = 0;
            int m = inp.nextInt();
            int[] arr = new int[m];

            inp.nextLine();
            for (int i = 0; i < m; i++) {
                String s = inp.nextLine();
                if (s.equals("LEFT")) {
                    arr[i] = -1;
                } else if (s.equals("RIGHT")) {
                    arr[i] = 1;
                } else {
                    Scanner newInp = new Scanner(s);
                    String a = newInp.next();
                    String b = newInp.next();

                    int index = newInp.nextInt() - 1;

                    arr[i] = arr[index];
                }
            }

            for (int i = 0; i < m; i++) {
                cnt += arr[i];
            }

            System.out.println(cnt);
        }
    }
}
