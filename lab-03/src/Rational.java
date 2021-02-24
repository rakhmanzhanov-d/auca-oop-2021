public class Rational extends Object {
    private int numerator, denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("Rational number equal to zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Rational add(Rational other) {
        int rNum = numerator * other.denominator + denominator * other.numerator;
        int rDen = denominator * other.denominator;
        return new Rational(rNum, rDen);
    }
}

