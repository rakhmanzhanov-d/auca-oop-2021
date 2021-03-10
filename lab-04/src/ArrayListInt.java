public class ArrayListInt {
    private int[] data = new int[0];

    void add(int x) {
        int[] newData = new int[data.length + 1];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        newData[newData.length - 1] = x;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < data.length; i++) {
            if (i != 0) {
                result.append(", ");
            }
            result.append(data[i]);
        }

        result.append("]");

        return result.toString();
    }
}
