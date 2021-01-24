import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int test = inp.nextInt();

        for (int i = 0; i < test; i++) {
            String number = inp.next();
            int leds = 0;
            for (int t = 0; t < number.length(); t++) {
                if (number.charAt(t) == '0' || number.charAt(t) == '9' || number.charAt(t) == '6') {
                    leds += 6;
                } else if (number.charAt(t) == '1') {
                    leds += 2;
                } else if (number.charAt(t) == '2' || number.charAt(t) == '3' || number.charAt(t) == '5') {
                    leds += 5;
                } else if (number.charAt(t) == '4') {
                    leds += 4;
                } else if (number.charAt(t) == '7') {
                    leds += 3;
                } else {
                    leds += 7;
                }
            }
            System.out.println(leds + " leds");
        }
    }
}

