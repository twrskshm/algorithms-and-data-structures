// Problem URL: https://codeforces.com/problemset/problem/1520/B

import java.util.Scanner;

public class OrdinaryNumbers {
    // Time Complexity: O(t * lg(n))
    // Space Complexity: O(1)
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int totalCases = inputReader.nextInt();

        while (totalCases-- > 0) {
            int limit = inputReader.nextInt();
            int totalOrdinaryNumbers = optimalSolution(limit);

            System.out.println(totalOrdinaryNumbers);
        }
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static int bruteForce(int limit) {
        int totalOrdinaryNumbers = 0;

        for (int number = 1; number <= limit; number++) {
            boolean isNumberOrdinary = isNumberOrdinary(number);

            if (isNumberOrdinary) {
                totalOrdinaryNumbers++;
            }
        }

        return totalOrdinaryNumbers;
    }

    // Time Complexity: O(max(n) * lg(max(n)))
    // Space Complexity: O(max(n))
    private static int[] getOrdinaryNumberCountList() {
        int maximumLimit = 1000000001;
        int[] ordinaryNumberCountList = new int[maximumLimit];

        for (int limit = 1; limit < maximumLimit; limit++) {
            boolean isLimitOrdinary = isNumberOrdinary(limit);

            ordinaryNumberCountList[limit] += ordinaryNumberCountList[limit - 1];

            if (isLimitOrdinary) {
                ordinaryNumberCountList[limit]++;
            }
        }

        return ordinaryNumberCountList;
    }

    // Time Complexity: O(lg(n))
    // Space Complexity: O(1)
    private static boolean isNumberOrdinary(int number) {
        int previousDigit = -1;

        while (number > 0) {
            int currentDigit = number % 10;

            if (previousDigit != -1 && previousDigit != currentDigit) {
                return false;
            }

            previousDigit = currentDigit;
            number /= 10;
        }

        return true;
    }

    // Time Complexity: O(lg(n))
    // Space Complexity: O(1)
    private static int optimalSolution(int limit) {
        int totalOrdinaryNumbers = 0;

        for (int digit = 1; digit <= 9; digit++) {
            for (long ordinaryNumber = digit; ordinaryNumber <= limit; ordinaryNumber = ordinaryNumber * 10 + digit) {
                totalOrdinaryNumbers++;
            }
        }

        return totalOrdinaryNumbers;
    }
}