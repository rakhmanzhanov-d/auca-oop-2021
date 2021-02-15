import java.util.Scanner;
//////////////////////////////
//   HIDDEN MESSAGE
//////////////////////////////

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        inp.nextLine();
        for (int k = 0; k < n; k++){
            boolean isNew = true;
            String sentence = inp.nextLine();
            StringBuilder answer = new StringBuilder();
            char[] arr = sentence.toCharArray();
            for(int i = 0; i < sentence.length(); i++){
                if(isNew && arr[i] != ' '){
                    answer.append(arr[i]);
                    isNew = false;
                }else if(arr[i] == ' '){
                    isNew = true;
                }
            }
            System.out.println(answer);
        }

    }
}
