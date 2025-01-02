// Problem URL: https://codeforces.com/problemset/problem/472/A

import java.util.Scanner;
import java.util.BitSet;

public class DesignTutorialLearnFromMath {
    // Time Complexity: O(t)
    // Space Complexity: O(1)
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int number = inputReader.nextInt();

        optimalSolution(number);
    }

    // Time Complexity: O(n * sqrt(n))
    // Space Complexity: O(1)
    private static void bruteForce(int number) {
        int halfOfNumber = number / 2;

        for (int partOne = 4; partOne <= halfOfNumber; partOne++) {
            int partTwo = number - partOne;
            boolean isPartOneComposite = trialDivision(partOne);
            boolean isPartTwoComposite = trialDivision(partTwo);

            if (isPartOneComposite && isPartTwoComposite) {
                System.out.println(partOne + " " + partTwo);
                return;
            }
        }
    }

    // Time Complexity: O(sqrt(n))
    // Space Complexity: O(1)
    private static boolean trialDivision(int number) {
        int squareRootOfNumber = (int) Math.sqrt(number);

        for (int possibleDivisor = 2; possibleDivisor <= squareRootOfNumber; possibleDivisor++) {
            if (number % possibleDivisor == 0) {
                return true;
            }
        }

        return false;
    }

    // Time Complexity: O(n * lg(lg(n)))
    // Space Complexity: O(k)
    private static void bruteForceWithSieveOfEratosthenes(int number) {
        int halfOfNumber = number / 2;
        BitSet compositeList = sieveOfEratosthenes();

        for (int partOne = 4; partOne <= halfOfNumber; partOne++) {
            int partTwo = number - partOne;
            boolean isPartOneComposite = compositeList.get(partOne);
            boolean isPartTwoComposite = compositeList.get(partTwo);

            if (isPartOneComposite && isPartTwoComposite) {
                System.out.println(partOne + " " + partTwo);
                return;
            }
        }
    }

    // Time Complexity: O(n * lg(lg(n)))
    // Space Complexity: O(k)
    private static BitSet sieveOfEratosthenes() {
        int maximumNumber = 1000001;
        BitSet compositeList = new BitSet(maximumNumber);

        for (int number = 2; number < maximumNumber; number++) {
            boolean isNumberComposite = compositeList.get(number);

            if (!isNumberComposite) {
                int maximumMultiplier = maximumNumber / number;

                for (int multiplier = 2; multiplier < maximumMultiplier; multiplier++) {
                    int multiple = number * multiplier;

                    compositeList.set(multiple);
                }
            }
        }

        return compositeList;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static void optimalSolution(int number) {
        int compositeOne = 8;

        if (number % 2 == 1) {
            compositeOne = 9;
        }

        int compositeTwo = number - compositeOne;

        System.out.println(compositeOne + " " + compositeTwo);
    }
}
