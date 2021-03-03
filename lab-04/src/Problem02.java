import java.util.ArrayList;
import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        while (inp.hasNextInt()) {
            int x = inp.nextInt();
            arr.add(x);
        }

        for (int i = 0; i < arr.size(); ) {
            if (arr.get(i) % 2 == 0) {
                arr.add(i, 0);
                i += 2;
            } else {
                i++;
            }
        }
        System.out.println("After insertions: ");
        System.out.println(arr);

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 != 0) {
                arr.remove(arr.get(i));
            }
        }

        System.out.println("After removing: ");
        System.out.println(arr);


    }
}
