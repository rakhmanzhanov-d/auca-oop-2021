import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int test = inp.nextInt();
        for (int t = 0; t < test; t++) {
            int n = inp.nextInt();
            int cnt = 0;
            String[] languages = new String[n];

            for (int i = 0; i < n; i++) {
                String lang = inp.next();
                languages[i] = lang;
            }

            for (int i = 1; i < n; i++){
                if(languages[0].equals(languages[i])){
                    cnt++;
                }
            }

            if(cnt >= n - 1){
                System.out.println(languages[0]);
            }else{
                System.out.println("ingles");
            }
        }
    }
}
