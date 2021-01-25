import java.util.Scanner;
//////////////////////////////
//   COMBINER
//////////////////////////////

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for (int i = 0; i < n; i++) {
            String word1 = inp.next();
            String word2 = inp.next();
            char[] arr1 = word1.toCharArray();
            char[] arr2 = word2.toCharArray();
            int length = Math.min(word1.length(), word2.length());
            String answer = "";

            for (int t = 0; t < length; t++) {
                answer += Character.toString(arr1[t]) + Character.toString(arr2[t]);
            }

            if (length < word1.length()){
                for (int t = length; t < word1.length(); t++){
                    answer += arr1[t];
                }
            }else {
                for (int t = length; t < word2.length(); t++){
                    answer += arr2[t];
                }
            }

            System.out.println(answer);
        }
    }
}

// aaaaa
// bbb
// abababaa