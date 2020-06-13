package com.vlocity.qe.utilities;

public class Rough_PNP {
    public static void main(String[] args) {
        int[] input1 = {1, 1, 1, 1};
        String input2 = "NPNN";
        int sum = calculatePNP(input1, input2, input2.length());
        System.out.println(sum);
    }

    private static int calculatePNP(int[] a, String input2, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (input2.charAt(i) == 'P')
                sum = sum + a[i];
            else
                sum = sum - a[i];
        }

        sum = Math.abs(sum);
        return sum * 100;
    }


}
