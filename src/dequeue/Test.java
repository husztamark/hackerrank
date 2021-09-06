package dequeue;

import java.util.*;

/*
https://www.hackerrank.com/challenges/java-dequeue
*/

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> numbers = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            numbers.add(num);

            if (deque.size() == m + 1) {
                int head = deque.remove();
                if (!deque.contains(head)) {
                    numbers.remove(head);
                }
            }
            max = Math.max(numbers.size(), max);
            if (max == m) {
                break;
            }
        }
        in.close();
        System.out.println(max);
    }
}