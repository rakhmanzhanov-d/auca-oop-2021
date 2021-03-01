import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String word1, word2;
        while(inp.hasNext()){
            word1 = inp.nextLine();
            word2 = inp.nextLine();
            if(word1.contains(word2)){
                System.out.println("Resistente");
            }else{
                System.out.println("Nao resistente");
            }
        }
    }
}
