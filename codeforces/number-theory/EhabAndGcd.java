// Problem URL: https://codeforces.com/problemset/problem/1325/A

import java.util.Scanner;

public class EhabAndGcd {
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
    private static void bruteForce(int number) {
        int halfOfNumber = number / 2;

        for (int partOne = 1; partOne <= halfOfNumber; partOne++) {
            int partTwo = number - partOne;
            long leastCommonMultiple = leastCommonMultiple(partOne, partTwo);
            int greatestCommonDivisor = greatestCommonDivisor(partOne, partTwo);

            if (leastCommonMultiple + greatestCommonDivisor == number) {
                System.out.println(partOne + " " + partTwo);
                return;
            }
        }
    }

    // Time Complexity: O(log(min(m, n)))
    // Space Complexity: O(1)
    private static long leastCommonMultiple(int partOne, int partTwo) {
        long partOneMultiple = partOne;
        long partTwoMultiple = partTwo;

        while (partOneMultiple != partTwoMultiple) {
            if (partOneMultiple < partTwoMultiple) {
                partOneMultiple += partOne;
            } else {
                partTwoMultiple += partTwo;
            }
        }

        return partOneMultiple;
    }

    // Time Complexity: O(min(m, n))
    // Space Complexity: O(1)
    private static int greatestCommonDivisor(int partOne, int partTwo) {
        partOne = Math.abs(partOne);
        partTwo = Math.abs(partTwo);

        int greatestCommonDivisor = Math.min(partOne, partTwo);

        while (partOne % greatestCommonDivisor != 0 || partTwo % greatestCommonDivisor != 0) {
            greatestCommonDivisor--;
        }

        return greatestCommonDivisor;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static void optimalSolution(int number) {
        int partTwo = number - 1;

        System.out.println(1 + " " + partTwo);
    }
}