import java.util.Arrays;
import java.util.Scanner;
//
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNext()) {
            int test = inp.nextInt();
            String[] arr = new String[test];
            String[] arrResult = new String[test];
            int[] arrNums = new int[test];
            for (int t = 0; t < test; t++) {
                arr[t] = inp.next();
                arrNums[t] = Integer.parseInt(arr[t]);
            }
            Arrays.sort(arrNums);
            for (int i = 0; i < arrNums.length; i++){
                for (int t = 0; t < arr.length; t++){
                    if(arrNums[i] == Integer.parseInt(arr[t])){
                        arrResult[i] = arr[t];
                    }
                }
            }
            for (int i = 0; i < arrResult.length; i++){
                System.out.println(arrResult[i]);
            }

        }
    }
}
