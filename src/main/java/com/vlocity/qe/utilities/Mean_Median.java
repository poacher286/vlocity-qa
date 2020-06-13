package com.vlocity.qe.utilities;

import java.util.*;

/**
 * @Author - Krishna
 */
// Using Double.
// Replace All 'D'ouble To Integer, If Dealing Only With Integers.
public class Mean_Median {

    public static double[] meanMedian(int n, double[] arr){

        List<List<Double>> listOfAllSubsets = new ArrayList<>();

    for (int i = 0; i < (1 << n); i++) {// 1 * Math.pow(2, n) -> 11100
        List<Double> eachSet = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if((i & (1 << j)) > 0){
                eachSet.add(arr[j]); // Here, j Only
            }
                listOfAllSubsets.add(eachSet);
            }
        }

        double max = Double.MIN_VALUE;
        Map<Double, List<Double>> mapping = new HashMap<>();

        for (List<Double> eachList : listOfAllSubsets){

            double mean = 0; // In All Cases, It Will Be Double
            double median = 0; // In All Case, It Will Be Double

            if (eachList.size() > 0){

                mean = eachList.stream().mapToDouble(Double::doubleValue).average().getAsDouble(); // Don't Forget getAsDouble
                int sizeOfArray = eachList.size();
                if(sizeOfArray % 2 == 0){// Equal Means Even No. Complex
                    median = (eachList.get(sizeOfArray/2) + eachList.get((sizeOfArray/2)-1))/2.0; // Always 2.0. In All Cases.
                }
                else {
                    List<Double> sortedList = new ArrayList<>(eachList);
                    Collections.sort(sortedList);
                    median = sortedList.get(sizeOfArray/2);
                }

                double difference = mean-median; // Not Absolute Value.

                if (max < difference){
                    max = difference;
                }
//				System.out.println("Mean - "+mean+", Median - "+median+", Difference - "+difference+", List - "+eachList);
                mapping.put(difference, eachList);
            }
        }

//		System.out.println(mapping);
        List<Double> result = null;
        for (Double d : mapping.keySet()){
            if(d == max){
                result = mapping.get(d);
            }
        }

        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public static void main(String[] args) {
        double[] result = meanMedian(4, new double[]{1, 2, 2, 3, 3});
        System.out.println(Arrays.toString(result));
        // 2.5, 1.5
    }
}
