public class ArrayListInt {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] data = new int[DEFAULT_CAPACITY];
    private int size;

    void add(int x) {
        if (size == data.length) {
            grow();
        }
        data[size] = x;
        size++;
    }

    public void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("ArrayListInt: incorrect index: " + index);
        }
    }

    public int size(){
        return size;
    }

    public void set(int index, int value) {
        rangeCheck(index);
        data[index] = value;
    }

    public int get(int index) {
        rangeCheck(index);
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            if (i != 0) {
                result.append(", ");
            }
            result.append(data[i]);
        }

        result.append("]");

        return result.toString();
    }

    private void grow() {
        int newCapacity = data.length + data.length / 2;
        int[] newData = new int[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
