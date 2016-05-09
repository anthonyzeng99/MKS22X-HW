import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
   private int size;
   private T[] data;
   private boolean isMax;

   public MyHeap() {
       data = (T[]) new Comparable[100];
       isMax = true;
   }

   public MyHeap(T[] array) {
       data = (T[]) new Comparable[array.length + 1];
       for (int i = 1; i < data.length; i++) {
	   data[i] = array[i - 1];
       }
       size = array.length;
       isMax = true;
       heapify();
   }

      //do this last
   public MyHeap(boolean isMax) {
       data = (T[]) new Comparable[100];
       this.isMax = isMax;
   }
   
   public MyHeap(T[] array, boolean isMax) {
       data = (T[]) new Comparable[array.length + 1];
       for (int i = 1; i < data.length; i++) {
	   data[i] = array[i - 1];
       }
       size = array.length;
       this.isMax = isMax;
       heapify();
   }



   private void pushDown(int index) {
       T leftValue = null;
       T rightValue = null;
       T temp = data[index];
       //Checks if parent has left or right child assigns the variable their value
       if (size + 1 > index * 2) {
	   leftValue = data[index * 2];
       }
       if (size + 1 > (index * 2) + 1) {
	   rightValue = data[(index * 2) + 1];
       }

       if(leftValue == null || rightValue == null) {
	   if (leftValue == null) {
	       if (rightValue != null && data[index].compareTo(rightValue) > 0) {
		   data[index] = data[(index * 2) + 1];
		   data[(index * 2) + 1] = temp;
		   pushDown( (index * 2) + 1);
	       } 
	   }else if (rightValue == null) {
	       if (leftValue != null && data[index].compareTo(leftValue) > 0) {
		   data[index] = data[index * 2];
		   data[index * 2] = temp;
		   pushDown( index * 2);
	       } 
	   }
	   return;
       }
       
       int difference = leftValue.compareTo(rightValue);
       
       if (difference < 0) {
	   
	   if (leftValue != null && data[index].compareTo(leftValue) > 0) {
	       data[index] = data[index * 2];
	       data[index * 2] = temp;
	       pushDown(index * 2);
	   } else if (rightValue != null && data[index].compareTo(rightValue) > 0) {
	       data[index] = data[(index * 2) + 1];
	   data[(index * 2) + 1] = temp;
	   pushDown( (index * 2) + 1);
	   }	   
       }

       if (rightValue != null && data[index].compareTo(rightValue) > 0) {
	   data[index] = data[(index * 2) + 1];
	   data[(index * 2) + 1] = temp;
	   pushDown( (index * 2) + 1);

       } else if (leftValue != null && data[index].compareTo(leftValue) > 0) {
	   data[index] = data[index * 2];
	   data[index * 2] = temp;
	   pushDown(index * 2);
       }
       
       return;
   }

   

   private void pushUp(int index) {
       int parent = index / 2;
       if (data[index].compareTo(data[parent]) > 0) {
	   return;
       } 
       T temp = data[index];
       data[index] = data[parent];
       data[parent] = temp;
       pushUp(parent);
   }

   private void heapify() {
       for (int i = 1; i < size + 1/ 2; i++) {
	   pushDown(i);
       }
   }

   public T delete() {
       if (data.length == 0) {
	   throw new NoSuchElementException();
       }
       T deletedValue = data[1];
       T[] newData = (T[]) new Comparable[data.length - 1];
       for (int i = 2; i < data.length; i++) {
	   newData[i - 1] = data[i];
       }
       data = newData;
       size--;
       return deletedValue;
       
   }

   public void add(T x) {
       if (size + 1 >= data.length - 1) {
	   doubleSize();
       }
       data[size + 1] = x;
       size++;
       heapify();
   }

   private void doubleSize() {
       data = Arrays.copyOf(data, size * size);
       
   }

   public String toString() {
       String output = "[";
       for (int i = 1; i < size + 1; i++) {
	   output += data[i] + ", ";
       }
       output = output.substring(0, output.length() - 2);
       return output + "]";
   }

   public static void main(String[] args) {
       Integer[] i = {5, 30, 17, 6, 8, 23, 1};
       MyHeap m = new MyHeap(i);
       m.add(2);
       System.out.println(m);

   }

}
