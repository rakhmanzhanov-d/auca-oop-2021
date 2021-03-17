import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n;
        while (inp.hasNext()){
            n = inp.nextInt();
            if (n == 0){
                break;
            }
            int[] letters = new int[26];
            Arrays.fill(letters, 0);
            int index;
            int time;
            int problems = 0;
            long sum = 0;

            for (int i = 0; i<n; i++){
                index = inp.next().charAt(0)-'A';
                time = inp.nextInt();
                if (inp.next().equals("correct")){
                    letters[index] += time;
                    ++problems;
                    sum += letters[index];
                } else {
                    letters[index] += 20;
                }
            }
            System.out.println(problems + " " + sum);
        }
    }
}
