import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while(inp.hasNext()){
            String word = inp.nextLine();
            int lowerCase = 0;
            int upperCase = 0;
            int digit = 0;
            int cnt = 0;
            boolean isValid = false;
            if(word.length() < 6 || word.length() > 32){
                System.out.println("Senha invalida.");
            }else {
                for (int i = 0; i < word.length(); i++){
                    if(word.charAt(i) > 47 && word.charAt(i) < 58) {
                        digit++;
                        cnt++;
                    }else if(word.charAt(i) > 64 && word.charAt(i) < 91){
                        upperCase++;
                        cnt++;
                    } else if(word.charAt(i) > 96 && word.charAt(i) < 123){
                        lowerCase++;
                        cnt++;
                    }
                }
                if(digit > 0 && upperCase > 0 && lowerCase > 0 && cnt == word.length()){
                    System.out.println("Senha valida.");
                }else {
                    System.out.println("Senha invalida.");
                }
            }
        }
    }
}
