import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        final int MAX_VALUE = 2000;
        int n = inp.nextInt();

        int[] counters = new int[MAX_VALUE + 1];
        for(int i = 0; i < n; i++){
            int x = inp.nextInt();
            ++counters[x];
        }

        for(int i = 1; i < counters.length; i++){
            if(counters[i] > 0){
                System.out.printf("%d aparece %d vez(es)\n", i, counters[i]);
            }
        }
    }
}
