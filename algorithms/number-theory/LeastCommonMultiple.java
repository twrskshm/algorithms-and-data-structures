public class LeastCommonMultiple {
    // Time Complexity: O(log(min(m, n)))
    // Space Complexity: O(1)
    private static long naiveAlgorithm(int partOne, int partTwo) {
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

    // Time Complexity: O(log(min(m, n)))
    // Space Complexity: O(1)
    private static long naiveAlgorithm(long partOne, long partTwo) {
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
}
