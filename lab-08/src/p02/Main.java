package p02;

public class Main {
    public static void main(String[] args) {
        try {
            CircleWithException c1 = new CircleWithException(5);
            CircleWithException c2 = new CircleWithException(-5);
            CircleWithException c3 = new CircleWithException(0);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        System.out.println("Number of objects created: " + CircleWithException.getNumOfObjects());
    }
}


class CircleWithException {
    private double radius;
    private static int numOfObjects = 0;

    public CircleWithException() {// construct the circle with radius 1.0
        this(1.0);
    }

    public CircleWithException(double newRadius) {
        setRadius(newRadius);
        numOfObjects++;
    }

    private void setRadius(double newRadius) {
            if (newRadius >= 0) {
                radius = newRadius;
            } else {
                throw new IllegalArgumentException("Radius can not be negative");
            }
    }

    public static int getNumOfObjects() {
        return numOfObjects;
    }
}
