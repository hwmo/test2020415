package com.hwmo.test.排序;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {6,1,2,7,9,3,2,2,2,888,4,5,10,8,1,1};

        bubbleSort(array);


        for(int i : array){
            System.out.print(i + " ");
        }

    }

    public static void bubbleSort(int[] a){

        for(int i = 0; i < a.length; i++){

            for(int j = 1; j< a.length-i; j++){
                if(a[j] < a[j - 1]){
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }
}
