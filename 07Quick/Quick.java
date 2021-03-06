import java.util.Random;
import java.util.Arrays;

public class Quick {

    public static int[] data;

    private static int partitionOld(int[] data, int left, int right) {
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
     
    private static int[] partition(int[] data, int left, int right) {
	int index = (int)(Math.random() * (right - (left + 1)) + left);
	int pivot = data[index];
        int dataIndex = left;
	int[] tempArray = new int[right - left + 1];
	int start = 0;
        int end = right - left;
	
        while (dataIndex <= right) {
	    
            if (data[dataIndex] > pivot) {
                tempArray[end] = data[dataIndex];
                end--;
	    } else if (data[dataIndex] < pivot) {
                tempArray[start] = data[dataIndex];
		start++;
            }
	    dataIndex++;
	}


	for (int i = start; i <= end; i++) {
	    tempArray[i] = pivot;
	}

	int tempIndex = left;

	for (int i = 0; i < tempArray.length; i++) {
	    data[tempIndex] = tempArray[i];
	    tempIndex++;
	}

	
	return new int[]{start + left, end + left};

    }
	/*
        if (data[start] > data[left]) {
            swap(data, left, start - 1);
            return start - 1;
        } else {
            swap(data, left, start);
        }

        return start;
    }
	*/
    
    private static void swap(int[] data, int a, int b) {
	int temp = data[a];
	data[a] = data[b];
        data[b] = temp;
    }

    
    public static int quickSelect(int[] data, int k) {

        return quickSelect(data, k - 1, 0, data.length - 1);
    }
    
    private static int quickSelect(int[] data, int k, int left, int right) {
	int[] indices =  partition(data, left, right);
	int startIndex = indices[0];
	int endIndex = indices[1];

        if (k >= startIndex && k <= endIndex) {
            return data[startIndex];
        } else if (startIndex> k) {
            return quickSelect(data, k, left, startIndex - 1);
        } else if (endIndex < k) {
            return quickSelect(data, k, endIndex + 1, right);
        }
	
        return 0;

    }
    
    /*
    public static int quickSelectOld(int[] data, int k) {

        return quickSelectOld(data, k - 1, 0, data.length - 1);
    }
    
    
    private static int quickSelectOld(int[] data, int k, int left, int right) {
        int index =  partitionOld(data, left, right);

        if (index == k) {
            return data[index];
        } else if (index > k) {
            return quickSelectOld(data, k, left, index - 1);
        } else if (index < k) {
            return quickSelectOld(data, k, index + 1, right);
        }
	
        return 0;

    }
    */
    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int left, int right) {
	int[] indices = partition(data, left, right);
	int startIndex = indices[0];
	int endIndex = indices[1];
	if (left < right) {
	    if (startIndex - 1 > left) {
		quickSort(data, left, startIndex - 1);
            } 
	    if (endIndex + 1  < right) {
		quickSort(data, endIndex + 1, right);
	    }
	} 
    }
    
    public static void quickSortOld(int[] data) {
	quickSortOld(data, 0, data.length - 1);
    }
    
    private static void quickSortOld(int[] data, int left, int right) {
        if (left < right) {
            int index = partitionOld(data, left, right);
            quickSortOld(data, left, index - 1);
            quickSortOld(data, index + 1, right);
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
            //data[i] = (int) (Math.random() * Integer.MAX_VALUE);
	    Random r = new Random();
	    data[i] = r.nextInt(4);
	}

    }

    
    public static void main(String[] args) {
        int[] d1 = {1, 7, 2, 2, 4, 6, 2 , 3, 2, 13, 19, 86};
	int[] data = new int[4000000];

	fillRandom(data);
	//partition(d1, 0, d1.length);
	//System.out.println(quickSelect(d1,8));
	quickSort(data);
	//	System.out.println(isSorted(data));    
    }
    
}

    
