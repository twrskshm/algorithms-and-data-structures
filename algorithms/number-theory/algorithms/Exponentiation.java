public class Exponentiation {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public static long exponentiation(long base, long exponent) {
        long power = 1;

        while (exponent-- > 0) {
            power *= base;
        }

        return power;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static long modularExponentiation(long base, long exponent, int modulo) {
        long power = 1;

        while (exponent-- > 0) {
            power = (power * base) % modulo;
        }

        return power;
    }

    // Time complexity: O(lg(n))
    // Space complexity: O(1)
    private static long exponentiationBySquaring(long base, long exponent) {
        // Following recursive approach uses O(lg(n)) additional space due to the call stack.
        // Each recursive call pushes a function state onto the stack, and the recursion depth is proportional to lg(n).
        // if (exponent == 0) {
            // return 1;
        // } else if (exponent == 1) {
            // return base;
        // }

        // long halfExponent = exponent / 2;
        // long halfPower =  exponentiationBySquaring(base, halfExponent);
        // long power = halfPower * halfPower;

        // if ((exponent & 1) == 1) {
            // power *= base;
        // }

        // return power;

        long power = 1;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                power *= base;
            }

            base *= base;
            exponent >>= 1;
        }

        return power;
    }

    // Time complexity: O(lg(n))
    // Space complexity: O(1)
    private static long modularExponentiationBySquaring(long base, long exponent, long modulo) {
        // Following recursive approach uses O(lg(n)) additional space due to the call stack.
        // Each recursive call pushes a function state onto the stack, and the recursion depth is proportional to lg(n).
        // if (exponent == 0) {
            // return 1;
        // } else if (exponent == 1) {
            // return base % modulo;
        // }

        // long halfExponent = exponent / 2;
        // long halfPower =  modularExponentiationBySquaring(base, halfExponent, modulo);
        // long power = (halfPower * halfPower) % modulo;

        // if ((exponent & 1) == 1) {
            // power = (power * base) % modulo;
        // }

        // return power;

        long power = 1;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                power = (power * base) % modulo;
            }

            base = (base * base) % modulo;
            exponent >>= 1;
        }

        return power;
    }
}
