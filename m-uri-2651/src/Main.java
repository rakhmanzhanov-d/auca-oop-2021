import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String s = inp.nextLine();
        s = s.toLowerCase();
        if (s.contains("zelda")) {
            System.out.println("Link Bolado");
        } else {
            System.out.println("Link Tranquilo");
        }
    }
}
