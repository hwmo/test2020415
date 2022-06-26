package com.hwmo.test.排序;


public class QuickSort {

    public static void main(String[] args) {
        int[] array = {6,1,2,7,9,3,2,2,2,888,4,5,10,8,1,1};

        quickSort(array, 0, array.length - 1);


        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] array, int left, int right){

        if(left > right){
            return;
        }

        int i = left, j = right;
        int temp = array[left];
        int t;


        while(i < j){
            while(array[j] >= temp && i < j){
                j--;
            }
            while(array[i] <= temp && i < j){
                i++;
            }
            if(i < j){
                t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        array[left] = array[i];
        array[i] = temp;

        quickSort(array, left, i-1);
        quickSort(array, i+1, right);
    }
}
