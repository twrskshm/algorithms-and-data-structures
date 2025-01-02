// Problem URL: https://codeforces.com/problemset/problem/749/A

import java.util.Scanner;

public class BachgoldProblem {
    // Time Complexity: O(t)
    // Space Complexity: O(1)
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int number = inputReader.nextInt();

        optimalSolution(number);
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static void optimalSolution(int number) {
        int maximumPrimeDivisors = number / 2;

        System.out.println(maximumPrimeDivisors);

        while (maximumPrimeDivisors-- > 1) {
            System.out.print(2 + " ");
        }

        if (number % 2 == 0) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}