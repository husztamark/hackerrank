package palindrome;

import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-string-reverse
*/

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        StringBuilder sb = new StringBuilder(text);
        System.out.println(sb.reverse().toString().equals(text) ? "Yes" : "No");
    }

}
