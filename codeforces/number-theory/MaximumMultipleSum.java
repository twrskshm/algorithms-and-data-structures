// Problem URL: https://codeforces.com/problemset/problem/1985/B

import java.util.Scanner;

public class MaximumMultipleSum {
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int totalCases = inputReader.nextInt();

        while (totalCases-- > 0) {
            int limit = inputReader.nextInt();
            int numberWithMaximumMultipleSum = optimalSolution(limit);

            System.out.println(numberWithMaximumMultipleSum);
        }
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static int bruteForce(int limit) {
        int numberWithMaximumMultipleSum = -1;
        int maximumMultipleSum = Integer.MIN_VALUE;

        for (int number = 2; number <= limit; number++) {
            int multipleSum = 0;

            for (int multiple = number; multiple <= limit; multiple += number) {
                multipleSum += multiple;
            }

            if (maximumMultipleSum < multipleSum) {
                maximumMultipleSum = multipleSum;
                numberWithMaximumMultipleSum = number;
            }
        }

        return numberWithMaximumMultipleSum;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static int optimalSolution(int limit) {
        if (limit == 3) {
            return limit;
        }

        return 2;
    }
}