package lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.hackerrank.com/challenges/java-lambda-expressions
*/

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Write your code here

    public PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    public PerformOperation isPrime() {
        // CAN'T import java.util.stream.IntStream; on the online tab
        return a -> a > 1 &&
                java.util.stream.IntStream
                        .rangeClosed(2, (int) Math.sqrt(a))
                        .noneMatch(divisor -> a % divisor == 0);
    }

    public PerformOperation isPalindrome() {
        return a -> {
            String number = Integer.toString(a);
            String reversed = new StringBuilder(number).reverse().toString();
            return number.equals(reversed);
        };
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
