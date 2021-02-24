import java.math.BigInteger;

public class Problem02 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("1111111111111111111111111");
        BigInteger b = new BigInteger("999999999999999999999999999999999999999999999999");
        System.out.println(a.multiply(b));
    }
}
