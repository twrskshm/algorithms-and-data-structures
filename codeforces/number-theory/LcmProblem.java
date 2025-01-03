// Problem URL: https://codeforces.com/problemset/problem/1389/A

import java.util.Scanner;

public class LcmProblem {
    // Time Complexity: O(t)
    // Space Complexity: O(1)
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int totalCases = inputReader.nextInt();

        while (totalCases-- > 0) {
            long leftBound = inputReader.nextLong();
            long rightBound = inputReader.nextLong();

            optimalSolution(leftBound, rightBound);
        }
    }

    // Time Complexity: O((m - n)^2 * log(min(m, n)))
    // Space Complexity: O(1)
    private static void bruteForce(long leftBound, long rightBound) {
        for (long numberOne = leftBound; numberOne < rightBound; numberOne++) {
            for (long numberTwo = numberOne + 1; numberTwo <= rightBound; numberTwo++) {
                long leastCommonMultiple = leastCommonMultiple(numberOne, numberTwo);

                if (leftBound <= leastCommonMultiple && leastCommonMultiple <= rightBound) {
                    System.out.println(numberOne + " " + numberTwo);
                    return;
                }
            }
        }

        System.out.println(-1 + " " + -1);
    }

    // Time Complexity: O(log(min(m, n)))
    // Space Complexity: O(1)
    private static long leastCommonMultiple(long numberOne, long numberTwo) {
        long numberOneMultiple = numberOne;
        long numberTwoMultiple = numberTwo;

        while (numberOneMultiple != numberTwoMultiple) {
            if (numberOneMultiple < numberTwoMultiple) {
                numberOneMultiple += numberOne;
            } else {
                numberTwoMultiple += numberTwo;
            }
        }

        return numberOneMultiple;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static void optimalSolution(long leftBound, long rightBound) {
        long numberTwo = leftBound * 2;

        if (numberTwo <= rightBound) {
            System.out.println(leftBound + " " + numberTwo);
            return;
        }

        System.out.println(-1 + " " + -1);
    }
}