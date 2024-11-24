// Problem URL: https://codeforces.com/problemset/problem/630/A

import java.util.Scanner;

public class AgainTwentyFive {
    private static final int BASE = 5;
    private static final int MODULO = 100;

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        long exponent = inputReader.nextLong();
        long answer = optimalSolution(exponent);

        System.out.println(answer);
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    private static long exponentiation(long exponent) {
        long power = 1;

        while (exponent-- > 0) {
            power *= BASE;
        }

        return (power % MODULO);
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    private static long modularExponentiation(long exponent) {
        long power = 1;

        while (exponent-- > 0) {
            power = (power * BASE) % MODULO;
        }

        return power;
    }

    // Time complexity: O(lg(n))
    // Space complexity: O(1)
    private static long exponentiationBySquaring(long exponent) {
        // Following recursive approach uses O(lg(n)) additional space due to the call stack.
        // Each recursive call pushes a function state onto the stack, and the recursion depth is proportional to lg(n).
        // if (exponent == 0) {
            // return 1;
        // } else if (exponent == 1) {
            // return BASE % MODULO;
        // }

        // long halfExponent = exponent / 2;
        // long halfPower =  exponentiationBySquaring(halfExponent);
        // long power = (halfPower * halfPower) % MODULO;

        // if ((exponent & 1) == 1) {
            // power = (power * BASE) % MODULO;
        // }

        // return power;

        long base = BASE;
        long power = 1;
        long modulo = MODULO;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                power = (power * base) % modulo;
            }

            base = (base * base) % modulo;
            exponent >>= 1;
        }

        return power;
    }

    // Time complexity: O(1)
    // Space complexity: O(1)
    private static long optimalSolution(long exponent) {
        if (exponent == 1) {
            return BASE;
        }

        return 25;
    }
}
