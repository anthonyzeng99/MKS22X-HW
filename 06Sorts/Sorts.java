import java.util.Arrays;

public class Sorts {

    public static int[] data;

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

    public static void swap(int[] data, int index) {

    }

    public static void insertionSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (data[j] >= data[j + 1]) {
                    int k = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = k;
                }
            }
        }
    }

    public static void selectionSort(int[] data) {
        int minIndex;
        int swap;
        minIndex = 0;
        for (int sortedIndex = 0; sortedIndex < data.length; sortedIndex++) {
            minIndex = sortedIndex;
            for (int index = sortedIndex + 1; index < data.length; index++) {
                if (data[index] < data[minIndex]) {
                    minIndex = index;
                }
            }
            swap = data[minIndex];
            data[minIndex] = data[sortedIndex];
            data[sortedIndex] = swap;
        }
    }

    public static void bubbleSort(int[] data) {
        int hold;
        for (int sortedIndex = data.length; sortedIndex > 0; sortedIndex--) {
            for (int swapIndex = 0; swapIndex < sortedIndex - 1; swapIndex++) {
                if (data[swapIndex] > data[swapIndex + 1]) {
                    hold = data[swapIndex];
                    data[swapIndex] = data[swapIndex + 1];
                    data[swapIndex + 1] = hold;
                }
            }
        }
    }

    public static void mergeSort(int[] data) {
        mergeSortH(data, 0, data.length);
    }

    public static void mergeSortH(int[] data, int start, int end) {
        int midpoint = end - ((end - start) / 2);
        if (end - start > 1 ) {
            mergeSortH(data, start, midpoint);
            mergeSortH(data, midpoint,end);
        }
            int[] a = Arrays.copyOfRange(data, start, midpoint);
            int[] b = Arrays.copyOfRange(data, midpoint, end);

            int[] merged = merge(a, b);
            int dataIndex = start;


            for (int i = 0; i < merged.length; i++) {
                data[dataIndex] = merged[i];
                dataIndex++;
            }

    }


    public static int[] merge(int[] a, int[] b) {
        int[] resultArray = new int[a.length + b.length];
        int resultArrayIndex = 0;
        int aArrayIndex = 0;
        int bArrayIndex = 0;

        while (aArrayIndex < a.length || bArrayIndex < b.length) {
            if (aArrayIndex == a.length) {
                while (bArrayIndex < b.length) {
                    resultArray[resultArrayIndex] = b[bArrayIndex];
                    bArrayIndex++;
                    resultArrayIndex++;
                }
            } else if (bArrayIndex == b.length) {
                while (aArrayIndex < a.length) {
                    resultArray[resultArrayIndex] = a[aArrayIndex];
                    aArrayIndex++;
                    resultArrayIndex++;
                }
            } else {

                if (a[aArrayIndex] < b[bArrayIndex]) {
                    resultArray[resultArrayIndex] = a[aArrayIndex];
                    resultArrayIndex++;
                    aArrayIndex++;
                } else {
                    resultArray[resultArrayIndex] = b[bArrayIndex];
                    resultArrayIndex++;
                    bArrayIndex++;
                }
            }
        }

        return resultArray;

    }


    public static void main(String[] args) {
        int[] a1 = {8, 6, 7, 5, 3, 0, 9, 1};
        //Sorts.printArray(a1);
        //Sorts.insertionSort(a1);
        //Sorts.printArray(a1);

        int[] a2 = {8, 6, 7, 5, 3, 0, 9, 1};
        //Sorts.printArray(a2);
        //Sorts.selectionSort(a2);
        //Sorts.printArray(a2);

        int[] m1 = {11, 19, 27, 52, 78, 423};
        int[] m2 = {5, 8, 13, 34, 99, 112, 523};


        data = new int[100000];
        fillRandom(data);
        mergeSort(data);
        System.out.println(isSorted(data));

    }

}
