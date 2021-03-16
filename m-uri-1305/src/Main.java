import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String num, cutoff;
        int res;
        while(inp.hasNext()){
            num = inp.nextLine();
            cutoff = inp.nextLine();

            float num1 = Float.parseFloat(num);
            float cutoff1 = Float.parseFloat(cutoff);

            if(num1 - cutoff1 >= Math.floor(num1)){
                res = (int) Math.ceil(num1);
            }else{
                res = (int) Math.floor(num1);
            }

            System.out.println(res);
        }
    }
}
