package com.javaconcepts.other;

import java.util.Arrays;

public class Sorts {
    private int[] theArray = new int[]{60, 50, 40, 30, 20, 10};

    private int arraySize = theArray.length;

    private int countOfIterations = 0;

    public void generateRandomArray(){

        for(int i = 0; i < arraySize; i++){

            theArray[i] = (int)(Math.random()*10)+10;

        }

    }

    public int[] get() {
        return this.theArray;
    }

    public void printArray(){

        System.out.println("----------");
        for (int num: theArray) System.out.print(num + " ");
        System.out.println();
    }

    public void printHorzArray(int i, int j){

        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < arraySize; n++){

            System.out.print("| " + n + "  ");

        }

        System.out.println("|");

        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < arraySize; n++){

            System.out.print("| " + theArray[n] + " ");

        }

        System.out.println("|");

        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        // END OF FIRST PART


        // ADDED FOR BUBBLE SORT

        if(j != -1){

            // ADD THE +2 TO FIX SPACING

            for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");

            System.out.print(j);

        }


        // THEN ADD THIS CODE

        if(i != -1){

            // ADD THE -1 TO FIX SPACING

            for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");

            System.out.print(i);

        }

        System.out.println();

    }

    public void bubbleSort(){
        countOfIterations = 0;

        // i starts at the end of the Array
        // As it is decremented all indexes greater
        // then it are sorted

        for(int i = 0; i < arraySize; i++){

            countOfIterations++;

            System.out.println("------------NEXT IERATION--------------");

            // The inner loop starts at the beginning of
            // the array and compares each value next to each
            // other. If the value is greater then they are
            // swapped

            for(int j = 0; j < arraySize-1; j++){

                countOfIterations++;

                // To change sort to Descending change to <

                if(theArray[j] > theArray[j + 1]){
                    swapValues(j, j+1);
                }

//                for(int num: theArray) System.out.print(num + " ");
//                System.out.println();
                printHorzArray(i, j);
            }
        }
        System.out.println("Total iterations - "+ countOfIterations);
    }

    public void selectionSort() {

        int max_value_index = 0;
        int last_index = 0;
        int max_value = theArray[0];

        for(int i = 0; i < theArray.length; i++) {

            for(int j = 0; j < theArray.length - i; j++) {
                if (max_value < theArray[j]) {
                    max_value_index = j;
                    max_value = theArray[j];
                    System.out.println(theArray[j] + " new max value found at "+max_value_index);
                }
            }

            last_index = theArray.length - 1 - i;

            swapValues(last_index, max_value_index);

            max_value_index = 0;
            max_value = theArray[0];

        }

        printArray();
        System.out.println("Total iterations - "+ countOfIterations);
    }

    public void insertionSort() {
        int i = 1;
        int j = 0;
        int key = 0;
        countOfIterations = 0;

        while (i < arraySize) {
            j = i-1;
            key = theArray[i];

            while (j >= 0 && theArray[j] > key) {
                theArray[j+1] = theArray[j];
                j--;
            }

            theArray[j+1] = key;

            i++;
        }

        printArray();
        System.out.println("Total iterations - "+ countOfIterations);
    }

    public void swapValues(int indexOne, int indexTwo){

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, (mid+1), r);
            merge(arr, l, r, mid);
        }
        System.out.println(Arrays.toString(arr));
    }

    public void merge(int arr[], int l, int r, int mid) {

        int l_arr_size = (mid - l + 1);
        int r_arr_size = r - mid;

        int[] lArr = new int[l_arr_size];
        int[] rArr = new int[r_arr_size];

        for (int c = 0; c < l_arr_size; c++) {
            lArr[c] = arr[l + c];
        }

        for (int c = 0; c < r_arr_size; c++) {
            rArr[c] = arr[mid + 1 + c];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < l_arr_size && j < r_arr_size) {

            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }

            k++;
        }

        while (i < l_arr_size) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        while (j < r_arr_size) {
            arr[k] = rArr[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args){

        Sorts sorts = new Sorts();

//        sorts.generateRandomArray();

        sorts.printArray();

//        sorts.bubbleSort();

//        sorts.selectionSort();

//        sorts.insertionSort();

        int[] arr = new int[]{9,5,8,1,6,7};

        sorts.mergeSort(arr, 0, (arr.length - 1));
    }

}
