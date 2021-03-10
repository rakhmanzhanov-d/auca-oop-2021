import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayListInt list = new ArrayListInt();

        while (inp.hasNextInt()) {
            int x = inp.nextInt();
            list.add(x);
        }

        System.out.println(list.toString());
    }
}
