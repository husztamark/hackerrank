package arraygame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-1d-array
*/

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        Deque<Integer> possibleIndexes = new ArrayDeque<>();
        possibleIndexes.push(0);

        while (!possibleIndexes.isEmpty()) {
            int index = possibleIndexes.pop();

            if (index >= game.length) {
                return true;
            }

            if (game[index] == 1) {
                continue;
            }

            game[index] = 1;

            possibleIndexes.push(index + 1);
            if (index - 1 > 0) {
                possibleIndexes.push(index - 1);
            }
            possibleIndexes.push(index + leap);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}

