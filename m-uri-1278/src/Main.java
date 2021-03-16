import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n;
        while((n = inp.nextInt()) != 0){
            int maxSize = 0;
            String[] arr = new String[n + 1];
            for(int i = 0; i <= n; i++){
                String s = inp.nextLine();
                Scanner input = new Scanner(s);
                String newString = "";
                while(input.hasNext()){
                    String ss = input.next();
                    if(newString.length() > 0){
                        newString += " " + ss;
                    }else{
                        newString += ss;
                    }
                }
                arr[i] = newString;
                if(newString.length() > maxSize){
                    maxSize = newString.length();
                }
            }

            for(int i = 0; i < arr.length; i++){
                int startString = maxSize - arr[i].length();
                for(int k = 0; k < startString; k++){
                    System.out.print(" ");
                }
                System.out.println(arr[i]);
            }
            System.out.println();
        }
    }
}