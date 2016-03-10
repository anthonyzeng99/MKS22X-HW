import java.util.Random;

public class Quick {

    public static int[] data;

    private static int partition(int[] data, int left, int right) {

        Random r = new Random();
        int randIndex = r.nextInt(data.length);
        int randNum = data[randIndex];
        System.out.println(randNum);
        int temp;

        data[randIndex] = data[data.length - 1];
        data[data.length - 1] = randNum;

        while (left != right) {

            if (data[left] < randNum) {
                left++;
            } else if (data[right] > randNum) {
                right--;
            } else {
                temp = data[right];
                data[right] = data[left];
                data[left] = temp;
                left++;
                right--;
            }
            printArray(data);
        }

        temp = data[randIndex];
        data[randIndex] = randNum;
        data[data.length - 1] = temp;
        printArray(data);

        return randIndex;
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

        int[] d1 = {1, 7 , 4, 6, 2 ,5, 19, 86, 11};
        partition(d1, 0, d1.length - 2);

    }

}