// Problem URL: https://codeforces.com/contest/2042/problem/B

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.BitSet;

public class GameWithColoredMarbles {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(k)
    public static void main(String[] args) {
        int totalTests = inputReader.nextInt();

        while (totalTests-- > 0) {
            int totalMarbles = inputReader.nextInt();
            int[] marbleList = readMarbleList(totalMarbles);
            int aliceScore = bitFlagging(totalMarbles, marbleList);

            System.out.println(aliceScore);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readMarbleList(int totalMarbles) {
        int[] marbleList = new int[totalMarbles];

        for (int marbleIndex = 0; marbleIndex < totalMarbles; marbleIndex++) {
            marbleList[marbleIndex] = inputReader.nextInt();
        }

        return marbleList;
    }

    // Time Complexity: O(2^n * n)
    // Space Complexity: O(n^2)
    private static int bruteForce(int totalMarbles, int[] marbleList) {
        Deque<State> stateQueue = new ArrayDeque<>();
        State initialState = new State();
        int maximumAliceScore = Integer.MIN_VALUE;

        stateQueue.push(initialState);

        while (!stateQueue.isEmpty()) {
            State currentState = stateQueue.pop();
            int currentMarbleIndex = currentState.getMarbleIndex();

            if (currentMarbleIndex == totalMarbles) {
                int aliceScore = currentState.calculateAliceScore();

                maximumAliceScore = Math.max(maximumAliceScore, aliceScore);
            } else {
                State optionOne = new State(currentState);
                State optionTwo = new State(currentState);
                int marble = marbleList[currentMarbleIndex];

                optionOne.assignToAlice(marble);
                optionTwo.assignToBob(marble);
                stateQueue.push(optionOne);
                stateQueue.push(optionTwo);
            }
        }

        return maximumAliceScore;
    }

    private static class State {
        private final int marbleIndex;
        private final Map<Integer, Integer> aliceMarbleList;
        private int aliceMarbleCount;
        private final Map<Integer, Integer> bobMarbleList;
        private int bobMarbleCount;

        private State() {
            marbleIndex = 0;
            aliceMarbleList = new HashMap<>();
            aliceMarbleCount = 0;
            bobMarbleList = new HashMap<>();
            bobMarbleCount = 0;
        }

        private State(State previousState) {
            int previousStateMarbleIndex = previousState.getMarbleIndex();
            Map<Integer, Integer> previousStateAliceMarbleList = previousState.getAliceMarbleList();
            int previousStateAliceMarbleCount = previousState.getAliceMarbleCount();
            Map<Integer, Integer> previousStateBobMarbleList = previousState.getBobMarbleList();
            int previousStateBobMarbleCount = previousState.getBobMarbleCount();

            marbleIndex = previousStateMarbleIndex + 1;
            aliceMarbleList = new HashMap<>(previousStateAliceMarbleList);
            aliceMarbleCount = previousStateAliceMarbleCount;
            bobMarbleList = new HashMap<>(previousStateBobMarbleList);
            bobMarbleCount = previousStateBobMarbleCount;
        }

        private int getMarbleIndex() {
            return marbleIndex;
        }

        private Map<Integer, Integer> getAliceMarbleList() {
            return aliceMarbleList;
        }

        private int getAliceMarbleCount() {
            return aliceMarbleCount;
        }

        private Map<Integer, Integer> getBobMarbleList() {
            return bobMarbleList;
        }

        private int getBobMarbleCount() {
            return bobMarbleCount;
        }

        private void assignToAlice(int marble) {
            int marbleFrequency = aliceMarbleList.getOrDefault(marble, 0) + 1;

            aliceMarbleList.put(marble, marbleFrequency);
            aliceMarbleCount++;
        }

        private void assignToBob(int marble) {
            int marbleFrequency = bobMarbleList.getOrDefault(marble, 0) + 1;

            bobMarbleList.put(marble, marbleFrequency);
            bobMarbleCount++;
        }

        private int calculateAliceScore() {
            int marbleCountDifference = aliceMarbleCount - bobMarbleCount;

            if (aliceMarbleCount == bobMarbleCount || marbleCountDifference == 1) {
                int aliceScore = 0;

                for (int aliceMarble: aliceMarbleList.keySet()) {
                    if (bobMarbleList.containsKey(aliceMarble)) {
                        aliceScore += 1;
                    } else {
                        aliceScore += 2;
                    }
                }

                return aliceScore;
            }

            return Integer.MIN_VALUE;
        }
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static int sortingBasedFrequency(int totalMarbles, int[] marbleList) {
        double totalUniques = 0;
        int totalDuplicates = 0;

        Arrays.sort(marbleList);

        for (int marbleIndex = 0; marbleIndex < totalMarbles; marbleIndex++) {
            int previousMarble = marbleIndex > 0 ? marbleList[marbleIndex - 1] : -1;
            int currentMarble = marbleList[marbleIndex];
            int nextMarble = marbleIndex < totalMarbles - 1 ? marbleList[marbleIndex + 1] : -1;

            if (currentMarble != previousMarble && currentMarble != nextMarble) {
                totalUniques++;
            } else if (currentMarble != previousMarble) {
                totalDuplicates++;
            }
        }

        int uniqueScoreIntermediate = (int) Math.ceil(totalUniques / 2);
        int uniqueScore = uniqueScoreIntermediate * 2;

        return uniqueScore + totalDuplicates;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int frequencyMap(int totalMarbles, int[] marbleList) {
        Map<Integer, Integer> marbleCountList = new HashMap<>();
        double totalUniques = 0;
        int totalDuplicates = 0;

        for (int marbleIndex = 0; marbleIndex < totalMarbles; marbleIndex++) {
            int marble = marbleList[marbleIndex];
            int marbleCount = marbleCountList.getOrDefault(marble, 0) + 1;

            marbleCountList.put(marble, marbleCount);
        }

        for (int marble: marbleCountList.keySet()) {
            int marbleCount = marbleCountList.get(marble);

            if (marbleCount == 1) {
                totalUniques++;
            } else {
                totalDuplicates++;
            }
        }

        int uniqueScoreIntermediate = (int) Math.ceil(totalUniques / 2);
        int uniqueScore = uniqueScoreIntermediate * 2;

        return uniqueScore + totalDuplicates;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(k)
    private static int bitFlagging(int totalMarbles, int[] marbleList) {
        int maximumMarble = 1001;
        BitSet marblesSeen = new BitSet(maximumMarble);
        BitSet duplicateMarbles = new BitSet(maximumMarble);

        for (int marbleIndex = 0; marbleIndex < totalMarbles; marbleIndex++) {
            int marble = marbleList[marbleIndex];

            if (marblesSeen.get(marble)) {
                duplicateMarbles.set(marble);
            } else {
                marblesSeen.set(marble);
            }
        }

        double totalUniques = 0;
        int totalDuplicates = 0;

        for (int marble = 1; marble < maximumMarble; marble++) {
            if (duplicateMarbles.get(marble)) {
                totalDuplicates++;
            } else if (marblesSeen.get(marble)) {
                totalUniques++;
            }
        }

        int uniqueScoreIntermediate = (int) Math.ceil(totalUniques / 2);
        int uniqueScore = uniqueScoreIntermediate * 2;

        return uniqueScore + totalDuplicates;
    }
}
