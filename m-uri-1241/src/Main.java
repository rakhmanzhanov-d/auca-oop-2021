import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        inp.nextLine();
        for (int i=0; i<t; i++){
            boolean isEncaixa = false;
            String a = inp.next();
            String b = inp.next();
            if (a.length() >= b.length()){
                for (int j=a.length()-1; j>a.length()-b.length()-1; j--){
                    if (a.charAt(j) == b.charAt(j-a.length()+b.length())){
                        isEncaixa = true;
                    } else {
                        isEncaixa = false;
                        break;
                    }
                }
            }
            if (isEncaixa){
                System.out.println("encaixa");
            } else {
                System.out.println("nao encaixa");
            }
        }
    }
}