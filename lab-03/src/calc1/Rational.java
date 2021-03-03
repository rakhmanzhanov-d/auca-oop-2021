package calc1;

public class Rational extends Object {
    private int numerator, denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("calc1.Rational number equal to zero");
        }
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }

        int a = Math.abs(numerator);
        int b = Math.abs(denominator);
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        this.numerator = numerator / a;
        this.denominator = denominator / a;
    }

    public static Rational parse(String s) {
        s = s.trim();
        int indexSlash = s.indexOf("/");
        if (indexSlash == -1) {
            return new Rational(Integer.parseInt(s), 1);
        }
        String n = s.substring(0, indexSlash);
        String d = s.substring(indexSlash + 1);
        return new Rational(Integer.parseInt(n), Integer.parseInt(d));
    }

    // Overwriting some inherited methods called "POLYMORPHISM" means == many forms
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Rational add(Rational other) {
        int rNum = numerator * other.denominator + denominator * other.numerator;
        int rDen = denominator * other.denominator;
        return new Rational(rNum, rDen);
    }

    public Rational subtract(Rational other) {
        int rNum = numerator * other.denominator - denominator * other.numerator;
        int rDen = denominator * other.denominator;
        return new Rational(rNum, rDen);
    }

    public Rational multiply(Rational other) {
        return new Rational(numerator * other.numerator, denominator * other.denominator);
    }

    public Rational divide(Rational other) {
        if (other.numerator == 0) {
            throw new RuntimeException("calc1.Rational : division by zero");
        }
        return new Rational(numerator * other.denominator, denominator * other.numerator);
    }

    public int compareTo(Rational other) {
        int lhs = numerator * other.denominator;
        int rhs = denominator * other.numerator;
//        if (lhs < rhs) {
//            return -1;
//        } else if (lhs > rhs) {
//            return 1;
//        } else {
//            return 0;
//        }
        return Integer.compare(lhs, rhs);
    }
}

