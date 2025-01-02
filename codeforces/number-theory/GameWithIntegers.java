// Problem URL: https://codeforces.com/problemset/problem/1899/A

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class GameWithIntegers {
    // Time Complexity: O(t)
    // Space Complexity: O(1)
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int totalCases = inputReader.nextInt();

        while (totalCases-- > 0) {
            int number = inputReader.nextInt();

            optimalSolution(number);
        }
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static void bruteForce(int number) {
        record State(int moveNumber, int number) {}
        Deque<State> stateQueue = new ArrayDeque<>();
        State initialState = new State(0, number);
        boolean isVanyaWinPossible = false;

        stateQueue.push(initialState);

        while (!stateQueue.isEmpty()) {
            State currentState = stateQueue.pop();
            int currentMoveNumber = currentState.moveNumber();

            if (currentMoveNumber <= 9) {
                int currentNumber = currentState.number();

                if (currentMoveNumber % 2 == 1 && currentNumber % 3 == 0) {
                    isVanyaWinPossible = true;
                    break;
                }

                int currentNumberMinusOne = currentNumber - 1;
                int nextMoveNumber = currentMoveNumber + 1;
                int currentNumberPlusOne = currentNumber + 1;

                if (currentNumberMinusOne % 3 == 0 || currentNumberMinusOne % 3 == 2) {
                    State optionOne = new State(nextMoveNumber, currentNumberMinusOne);

                    stateQueue.push(optionOne);
                }

                if (currentNumberPlusOne % 3 == 0 || currentNumberPlusOne % 3 == 2) {
                    State optionTwo = new State(nextMoveNumber, currentNumberPlusOne);

                    stateQueue.push(optionTwo);
                }
            }
        }

        if (isVanyaWinPossible) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static void optimalSolution(int number) {
        int optionOne = number - 1;
        int optionTwo = number + 1;

        if (optionOne % 3 == 0 || optionTwo % 3 == 0) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }
    }
}