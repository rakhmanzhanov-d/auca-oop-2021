import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for(int i = 0; i < n; i++){
            String s = inp.next();
            int combinations = 1;
            s = s.toLowerCase();
            for(int l = 0; l < s.length(); l++){
                int variants = 2;
                if(Character.isLetter(s.charAt(l))){
                    if(s.charAt(l) == 'a' ||  s.charAt(l) == 'e' || s.charAt(l) == 'i' || s.charAt(l) == 's' || s.charAt(l) == 'o'){
                        variants++;
                    }
                }else{
                    variants = 1;
                }
                combinations *= variants;
            }
            System.out.println(combinations);
        }
    }
}
