// Problem URL: https://codeforces.com/problemset/problem/1968/A

import java.util.Scanner;

public class Maximize {
    // Time Complexity: O(t)
    // Space Complexity: O(1)
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int totalCases = inputReader.nextInt();

        while (totalCases-- > 0) {
            int number = inputReader.nextInt();

            optimalSolution(number);
        }
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    private static void bruteForce(int numberOne) {
        int maximumResult = Integer.MIN_VALUE;
        int maximumResultYieldingNumberTwo = -1;

        for (int numberTwo = numberOne - 1; 1 <= numberTwo; numberTwo--) {
            int currentResult = greatestCommonDivisor(numberOne, numberTwo) + numberTwo;

            if (maximumResult < currentResult) {
                maximumResult = currentResult;
                maximumResultYieldingNumberTwo = numberTwo;
            }
        }

        System.out.println(maximumResultYieldingNumberTwo);
    }

    // Time Complexity: O(min(m, n))
    // Space Complexity: O(1)
    private static int greatestCommonDivisor(int numberOne, int numberTwo) {
        numberOne = Math.abs(numberOne);
        numberTwo = Math.abs(numberTwo);

        int greatestCommonDivisor = Math.min(numberOne, numberTwo);

        while (numberOne % greatestCommonDivisor != 0 || numberTwo % greatestCommonDivisor != 0) {
            greatestCommonDivisor--;
        }

        return greatestCommonDivisor;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static void optimalSolution(int number) {
        int previousNumber = number - 1;

        System.out.println(previousNumber);
    }
}