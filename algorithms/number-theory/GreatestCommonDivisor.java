public class GreatestCommonDivisor {
    // Time Complexity: O(min(m, n))
    // Space Complexity: O(1)
    public static int naiveAlgorithm(int numberOne, int numberTwo) {
        numberOne = Math.abs(numberOne);
        numberTwo = Math.abs(numberTwo);

        int greatestCommonDivisor = Math.min(numberOne, numberTwo);

        while (numberOne % greatestCommonDivisor != 0 || numberTwo % greatestCommonDivisor != 0) {
            greatestCommonDivisor--;
        }

        return greatestCommonDivisor;
    }

    // Time Complexity: O(min(m, n))
    // Space Complexity: O(1)
    public static long naiveAlgorithm(long numberOne, long numberTwo) {
        numberOne = Math.abs(numberOne);
        numberTwo = Math.abs(numberTwo);

        long greatestCommonDivisor = Math.min(numberOne, numberTwo);

        while (numberOne % greatestCommonDivisor != 0 || numberTwo % greatestCommonDivisor != 0) {
            greatestCommonDivisor--;
        }

        return greatestCommonDivisor;
    }
}
