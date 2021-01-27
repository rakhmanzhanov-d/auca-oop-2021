import java.util.Scanner;
//////////////////////////////
//   CONTRACT REVISION
//////////////////////////////

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String line;
        while (!(line = inp.nextLine()).equals("0 0")) {
            String result = "";
            String[] arr = line.split(" ");
            String word1 = arr[0];
            String word2 = arr[1];
            int iterator = 0;
            for (int i = 0; i < arr[1].length(); i++) {
                if (word1.charAt(0) != word2.charAt(i)) {
                    if (word2.charAt(i) == '0' && iterator > 0) {
                        result += word2.charAt(i);
                    } else if (word2.charAt(i) != '0') {
                        result += word2.charAt(i);
                        iterator++;
                    }
                }
            }
            if (result == "") {
                result = "0";
            }
            System.out.println(result);
        }
    }
}
