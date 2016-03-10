import java.util.Random;

public class Quick {

    public static int[] data;

    private static int partition(int[] data, int left, int right) {
        int index = (int)(Math.random() * (right - left + 1)) + left;

        int start = left + 1;
        int end = right;

        swap(data, index, left);

        while (start < end) {

            if (data[start] > data[left]) {
                swap(data, start, end);
                end--;
            } else {
                start++;
            }

        }

        if (data[start] > data[left]) {
            swap(data, left, start - 1);
            return start - 1;
        } else {
            swap(data, left, start);
        }

        return start;
    }

    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public static int quickSelect(int[] data, int k) {

        return quickSelect(data, k - 1, 0, data.length - 1);
    }

    private static int quickSelect(int[] data, int k, int left, int right) {
        int index =  partition(data, left, right);

        if (index == k) {
            return data[index];
        } else if (index > k) {
            return quickSelect(data, k, left, index - 1);
        } else if (index < k) {
            return quickSelect(data, k, index + 1, right);
        }

        return 0;

    }

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int index = partition(data, left, right);
            quickSort(data, left, index - 1);
            quickSort(data, index + 1, right);
        }
    }

    public static String name() {
        return ("7,Zeng,Anthony");
    }

    public static void printArray(int[] data) {
        String output = "";

        for (int i = 0; i < data.length; i++) {

            if (i == 0) {
                output += "[" + data[i] + ",";
            } else {
                output += data[i] + ",";
            }

        }

        System.out.println(output + "]");
    }

    public static boolean isSorted(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                return false;
            }
        }
        return true;

    }

    public static void fillRandom(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }

    }


    public static void main(String[] args) {
        int[] d1 = {1, 7 , 4, 6, 2 , 3, 19, 86};
        printArray(d1);
        quickSort(d1);
        printArray(d1);
        ;

    }

}