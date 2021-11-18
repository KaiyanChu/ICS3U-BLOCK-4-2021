package week11;

import java.util.Arrays;

public class SearchingAlgorithms {

    public static void main(String[] args) {

        int[] arr = {80,95,10,60,35,10,25};

        int index = linearSearch(arr,35);

        index = linearSearch(arr,36);

        Arrays.sort(arr);
        index = binarySearch(arr,35);
      

    }



    private static int binarySearch(int[] arr, int findme) {
        int upper = 0;
        int lower = arr.length - 1;
        while(upper >= lower){
            int mid = (upper + lower)/2;

            if(arr[mid] == findme){
                return mid;
            }else if(arr[mid] > findme){
                upper = mid - 1;
            }else{
                lower = mid + 1;
            }
        }
        return -1;
    }



    private static int linearSearch(int[] arr, int element) {

        for (int i = 0; i <arr.length; i++){

            if (arr[i]==element){

                return i;

            }

        }

        return -1;



           

        }

    }