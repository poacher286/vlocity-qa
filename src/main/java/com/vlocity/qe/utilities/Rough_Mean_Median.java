package com.vlocity.qe.utilities;

//------Mean-Median

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rough_Mean_Median {

    private static int[] subsequences(int[] arr, int n) {
        if (n < 3) {
            return arr;//Original Array
        }

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        double old = Integer.MIN_VALUE;

        for (int i = 0; i < (1 << n); i++) {
            double diff;
            for (int j = 0; j < n; j++) {
                if (BigInteger.valueOf(i).testBit(j)) {
                    a.add(arr[j]);
                }
            }

            if (a.size() > 0) {
                diff = getMean(a) - getMedian(a);

                if (diff >= old) {
                    old = diff;
                    ans.clear();
                    ans.addAll(a);
                }

                a.clear();
            }
        }

        int[] finalResult = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            finalResult[i] = ans.get(i);

        return finalResult;
    }

    private static double getMean(List<Integer> arr) {
        return arr.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    private static double getMedian(List<Integer> arr) {
        Collections.sort(arr);
        if (arr.size() % 2 == 0)
            return (arr.get(arr.size() / 2) + arr.get((arr.size() / 2) - 1)) / 2.0;
        else
            return arr.get(arr.size() / 2);
    }

    public static void main(String[] args) {
        System.out.println("All Non-empty subsequences");
        int[] arr = {1, 2, 2,3, 3};
        int[] a = subsequences(arr, arr.length); // a contains the subset
        System.out.print(Arrays.toString(a));

    }

}