public class StringVsStringBuilder {
    static final int N = 100000;

    public static void main(String[] args) {
        expWithStringBuilder();
        expWithString();
    }

    private static void expWithString() {
        long begin = System.nanoTime();
        String res = "";
        for (int i = 0; i < N; i++) {
            res += "Hello".charAt(i % 5);
        }
        long end = System.nanoTime();
        System.out.println(res.length());
        System.out.println(end - begin);
    }

    private static void expWithStringBuilder() {
        long begin = System.nanoTime();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            res.append("Hello".charAt(1 % 5));
        }
        long end = System.nanoTime();
        System.out.println(res.length());
        System.out.println(end - begin);
    }
}
