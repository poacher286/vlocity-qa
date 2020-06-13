package com.vlocity.qe.utilities;

import java.math.BigInteger;
import java.util.ArrayList;

public class Rough_Dishes {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 4};
        int a = dishes(arr, arr.length);
        System.out.println(a);
    }

    private static int dishes(int[] arr, int n) {
        ArrayList<Integer> a = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (BigInteger.valueOf(i).testBit(j)) {
                    a.add(arr[j]);
                }
            }

            int ans = getLikeToTimeCoefficient(a);
            if (ans > max) {
                max = ans;
            }

            a.clear();
        }
        return max;
    }

    private static int getLikeToTimeCoefficient(ArrayList<Integer> a) {
        return a.stream().map(x -> x * (a.indexOf(x) + 1)).reduce(0, Integer::sum);
    }

}
