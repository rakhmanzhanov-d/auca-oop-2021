import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 10);

        System.out.printf("%s + %s = %s%n", a, b, a.add(b));
    }
}
