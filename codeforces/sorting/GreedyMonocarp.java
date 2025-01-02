// Problem URL: https://codeforces.com/contest/2042/problem/A

import java.util.Scanner;
import java.util.Arrays;

public class GreedyMonocarp {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] args) {
        int totalTests = inputReader.nextInt();

        while (totalTests-- > 0) {
            int totalChests = inputReader.nextInt();
            int expectedCoinCount = inputReader.nextInt();
            int[] chestList = new int[totalChests];
            int actualCoinCount = readChestList(totalChests, chestList);
            int additionalCoinsRequired = sorting(expectedCoinCount, actualCoinCount, totalChests, chestList);

            System.out.println(additionalCoinsRequired);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int readChestList(int totalChests, int[] chestList) {
        int actualCoinCount = 0;

        for (int chestNumber = 0; chestNumber < totalChests; chestNumber++) {
            int currentChestCoinCount = inputReader.nextInt();

            chestList[chestNumber] = currentChestCoinCount;
            actualCoinCount += currentChestCoinCount;
        }

        return actualCoinCount;
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static int sorting(int expectedCoinCount, int actualCoinCount, int totalChests, int[] chestList) {
        if (expectedCoinCount > actualCoinCount) {
            return expectedCoinCount - actualCoinCount;
        } else if (expectedCoinCount == actualCoinCount) {
            return 0;
        } else {
            int chestNumber = totalChests - 1;

            Arrays.sort(chestList);

            while (chestNumber >= 0 && expectedCoinCount > 0) {
                int currentChestCoinCount = chestList[chestNumber--];

                expectedCoinCount -= currentChestCoinCount;
            }

            if (expectedCoinCount == 0) {
                return 0;
            }

            return chestList[chestNumber + 1] + expectedCoinCount;
        }
    }
}
