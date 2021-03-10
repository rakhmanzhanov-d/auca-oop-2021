import java.util.ArrayList;
import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayListInt arr = new ArrayListInt();

        while (inp.hasNextInt()) {
            int x = inp.nextInt();
            arr.add(x); // Autoboxing
        }
        System.out.println("Before swapping: ");
        System.out.println(arr);

        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            Integer x = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, x);
            left++;
            right--;
        }
        System.out.println();
        System.out.println("After swapping: ");
        System.out.println(arr);
    }
}