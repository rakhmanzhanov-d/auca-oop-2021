import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        inp.nextLine();
        for (int i=0; i<t; i++){
            int res = 0;
            int[] alphabet = new int[26];
            Arrays.fill(alphabet, 0);
            String s = inp.nextLine();
            for (int j=0; j<s.length(); j++){
                if (Character.isLowerCase(s.charAt(j))){
                    alphabet[s.charAt(j)-'a']++;
                }
            }
            for (int j=0; j<26; j++){
                if (alphabet[j] != 0){
                    res++;
                }
            }
            if (res == 26){
                System.out.println("frase completa");
            } else if (res >= 13){
                System.out.println("frase quase completa");
            } else {
                System.out.println("frase mal elaborada");
            }
        }
    }
}
