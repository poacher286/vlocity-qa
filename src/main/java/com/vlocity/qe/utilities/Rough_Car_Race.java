package com.vlocity.qe.utilities;

public class Rough_Car_Race {
    //--------Race
    private static int fun(int[][] matrix, int n, int m) {
        int[] points = new int[n * m];
        int last_stop = 0, k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                points[k++] = matrix[i][j];
                if (last_stop < matrix[i][j])
                    last_stop = matrix[i][j];
            }
        }
        System.out.println("last_stop \n" + last_stop);
        int max_stops = 0, count;
        for (int i = 1; i < last_stop; i++) {
            count = 0;
            for (int j = 0; j < m * n; j = j + 2) {
                if (i >= points[j] && i < points[j + 1]) {
                    count++;
                }
            }
            System.out.println(count);
            if (max_stops < count) {
                max_stops = count;
            }
        }
        return max_stops;
    }

    public static void main(String[] args) {
        int n = 5, m = 2;
        int[][] matrix = {
                {1, 7},
                {2, 4},
                {6, 9},
                {3, 8},
                {5, 10}
        };

        int max_stops = fun(matrix, n, m);
        System.out.println("Max stops " + max_stops);
    }

}
