package com.hwmo.test.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 给定数组，求子集和相加等于某个给定的数
 */
public class SubSet {

    private static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> getSubset(int[] a, int m, int i) {
        System.out.println(list);
        List<List<Integer>> resList = new ArrayList<>();
        while (i < a.length) {
            list.add(a[i]);
            if (getsum(list) == m) {
                resList.add(list);
                return resList;
            }
            i++;
            getSubset(a, m, i);
            list.remove(list.size() - 1);
        }
        return resList;
    }

    private static int getsum(List<Integer> list) {
        int sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            sum += iterator.next();
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        //System.out.println(Arrays.toString(arr));
        System.out.println(SubSet.getSubset(arr, 0, 0));
    }

}
