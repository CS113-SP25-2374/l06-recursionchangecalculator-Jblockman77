package edu.miracosta.cs113.change;

import java.util.List;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Timer time = new Timer();
        int[] testAmounts = { 1, 5, 25, 43, 1000};

        for (int i = 0; i < testAmounts.length; i++) {
            List<String> recursiveResult = ChangeCalculatorRecursive.calculateRecursive(testAmounts[i]);
            List<String> linearResult = ChangeCalculatorLinear.calculateLinear(testAmounts[i]);

            System.out.println(" ");
            System.out.println("Testing amount " + testAmounts[i] + ": ");

            long startTime = System.nanoTime();
            for (String result : recursiveResult) {
                System.out.println(result);
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println(duration);

            long secondTimer = System.nanoTime();
            for (String result : linearResult) {
                if (!recursiveResult.contains(result)) {
                    System.out.println("Missing: " + result);
                }
            }
            long secondEndTimer = System.nanoTime();
            long secondDuration = (secondEndTimer - secondTimer);
            System.out.println(secondDuration);

            System.out.println("Total Results: " + recursiveResult.size() + "/" + linearResult.size());
        }

        System.out.println("Jobs done!");
    }
}