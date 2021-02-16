import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int test = inp.nextInt();
        for (int t = 0; t < test; t++) {
            String[] arr = new String[2];
            arr[0] = inp.next();
            arr[1] = inp.next();
            if (arr[0].equals(arr[1])) {
                System.out.println("empate");
            } else if (arr[0].equals("pedra") && (arr[1].equals("tesoura") || arr[1].equals("lagarto"))) {
                System.out.println("rajesh");
            } else if (arr[0].equals("tesoura") && (arr[1].equals("papel") || arr[1].equals("lagarto"))) {
                System.out.println("rajesh");
            } else if (arr[0].equals("spock") && (arr[1].equals("tesoura") || arr[1].equals("pedra"))) {
                System.out.println("rajesh");
            } else if (arr[0].equals("lagarto") && (arr[1].equals("papel") || arr[1].equals("spock"))) {
                System.out.println("rajesh");
            } else if (arr[0].equals("papel") && (arr[1].equals("pedra") || arr[1].equals("spock"))) {
                System.out.println("rajesh");
            } else {
                System.out.println("sheldon");
            }
        }
    }
}
