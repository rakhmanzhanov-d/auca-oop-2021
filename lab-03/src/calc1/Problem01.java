package calc1;

import java.util.Scanner;

public class Problem01 {
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                readAndCompute();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void readAndCompute() {
        Rational r1 = readRational("Enter 1st rational (EOF for exit): ");
        String operator = readOperator("Enter operator (EOF for exit): ");
        Rational r2 = readRational("Enter 2nd rational (EOF for exit): ");

        switch (operator) {
            case "+" -> System.out.printf("%s + %s = %s%n", r1, r2, r1.add(r2));
            case "-" -> System.out.printf("%s - %s = %s%n", r1, r2, r1.subtract(r2));
            case "*" -> System.out.printf("%s * %s = %s%n", r1, r2, r1.multiply(r2));
            case "/" -> System.out.printf("%s / %s = %s%n", r1, r2, r1.divide(r2));
            case "=" -> System.out.printf("%s = %s = %s%n", r1, r2, r1.compareTo(r2) == 0);
            case "!=" -> System.out.printf("%s != %s = %s%n", r1, r2, r1.compareTo(r2) != 0);
            case "<" -> System.out.printf("%s < %s = %s%n", r1, r2, r1.compareTo(r2) < 0);
            case ">" -> System.out.printf("%s > %s = %s%n", r1, r2, r1.compareTo(r2) > 0);
            case "<=" -> System.out.printf("%s <= %s = %s%n", r1, r2, r1.compareTo(r2) <= 0);
            case ">=" -> System.out.printf("%s >= %s = %s%n", r1, r2, r1.compareTo(r2) >= 0);
        }
    }

    private static String readOperator(String msg) {
        while (true) {
            System.out.print(msg);
            if (!inp.hasNextLine()) {
                System.exit(0);
            }
            String res = inp.nextLine().trim();
            switch (res) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "=":
                case "!=":
                case ">":
                case ">=":
                case "<":
                case "<=":
                    return res;
                default:
                    System.out.println("Incorrect operation: " + res);
            }
        }
    }

    private static Rational readRational(String msg) {
        while (true) {
            System.out.print(msg);
            if (!inp.hasNextLine()) {
                System.exit(0);
            }
            String s = inp.nextLine();
            try {
                return Rational.parse(s);
            } catch (RuntimeException e) {
                System.out.println("calc1.Rational num is not correct");
                System.out.println(e.getMessage());
            }
        }
    }
}
