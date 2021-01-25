import java.util.Scanner;
//////////////////////////////
//   DANCING SENTENCE
//////////////////////////////

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNext()) {
            String word = inp.nextLine();
            String answer = "";
            int cnt = 0;
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetter(arr[i])) {
                    if (cnt % 2 == 0) {
                        arr[i] = Character.toUpperCase(arr[i]);
                        answer += arr[i];
                        cnt++;
                    } else {
                        arr[i] = Character.toLowerCase(arr[i]);
                        answer += arr[i];
                        cnt++;
                    }
                }else{
                    answer += arr[i];
                }
            }
            System.out.println(answer);
        }
    }
}
