import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
   private int size;
   private T[] data;

   public MyHeap() {
       data = (T[]) new Comparable[100];
       data[0] == null;
   }

   public MyHeap(T[] array) {
       data = new T[array.length + 1];
       for (int i = 1; i < data.length; i++) {
	   data[i] = array[i - 1];
       }
       heapify();
   }

   private void pushDown(int index) {
       int leftValue = data[index * 2];
       int rightValue = data[(index * 2) + 1];
       if (data[index] < leftValue && data[index] < rightValue) {
	   return;
       } else if (data[index] < leftValue
   }

   

   private void pushUp(int index) {
       int parent = index / 2;
       if (data[index] > data[parent]) {
	   return;
       } 
       int temp = data[index];
       data[index] = data[parent];
       data[parent] = temp;
       pushUp(parent);
   }

   private void heapify() {
       
   }

   public T delete() {
       T a;
       return a;
   }

   public void add(T x) {
       for  
   }

   private void doubleSize() {
       data = Arrays.copyOf(data, size * size);
       
   }

   public String toString() {
       return "";
   }

   //do this last
   public MyHeap(boolean isMax) {

   }

   public MyHeap(T[] array, boolean isMax) {

   }


}
