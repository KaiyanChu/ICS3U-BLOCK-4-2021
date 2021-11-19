package week11;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {43, 12, 533, 53, 123, 11};
      //  selectionSort(arr);
      inserstionSort(arr);
     // int index = LinearSearch(arr, 35);
      //index = LinearSearch(arr, 36);

     // index = binary
    }
/* 
    private static int LinearSearch(int[] arr, int findme) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == findme){
                return i;
            }
        }
        return -1;
    } */

    private static void inserstionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { //sort the next element
            int temp = arr[i];
            int j;
            for(j = i; j> 0 && temp < arr[j - 1]; j--){ //shifting is done 
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }   

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestIndex = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[smallestIndex]){
                    smallestIndex = j;
                }
                
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
            
        }
    }
}
