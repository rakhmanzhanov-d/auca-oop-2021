package calc2;

//import calc1.Rational;

import java.math.BigInteger;

public class BigRational {
    private BigInteger numerator;
    private BigInteger denominator;

    public BigRational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new RuntimeException("calc2.BigRational number equal to zero");
        }
        if (denominator.signum() < 0) {
            denominator = denominator.negate();
            numerator = numerator.negate();
        }

        BigInteger d = numerator.gcd(denominator);

        this.numerator = numerator.divide(d);
        this.denominator = denominator.divide(d);
    }

    public static BigRational parse(String s) {
        s = s.trim();
        int indexSlash = s.indexOf("/");
        if (indexSlash == -1) {
            return new BigRational(new BigInteger(s), BigInteger.ONE);
        }
        String n = s.substring(0, indexSlash);
        String d = s.substring(indexSlash + 1);
        return new BigRational(new BigInteger(n), new BigInteger(d));
    }

    // Overwriting some inherited methods called "POLYMORPHISM" means == many forms
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public BigRational add(BigRational other) {
        BigInteger rNum = numerator.multiply(other.denominator).add(denominator.multiply(other.numerator));
        BigInteger rDen = denominator.multiply(other.denominator);
        return new BigRational(rNum, rDen);
    }

    public BigRational subtract(BigRational other) {
        BigInteger rNum = numerator.multiply(other.denominator).add(denominator.multiply(other.numerator));
        BigInteger rDen = denominator.multiply(other.denominator);
        return new BigRational(rNum, rDen);
    }

    public BigRational multiply(BigRational other) {
        return new BigRational(numerator.multiply(other.numerator), denominator.multiply(other.denominator));
    }

    public BigRational divide(BigRational other) {
        if (other.numerator.equals(BigInteger.ZERO)) {
            throw new RuntimeException("calc1.Rational : division by zero");
        }
        return new BigRational(numerator.multiply(other.denominator), denominator.multiply(other.numerator));
    }

    public int compareTo(BigRational other) {
        return numerator.multiply(other.denominator).compareTo(denominator.multiply(other.numerator));
    }
}
