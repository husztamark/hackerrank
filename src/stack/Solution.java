package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
https://www.hackerrank.com/challenges/java-stack
*/

class Solution {

    private static final Map<Character, Character> PARENTHESIS = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            System.out.println(isBalanced(input.toCharArray()) ? "true" : "false");
        }

    }

    private static boolean isBalanced(char[] input) {
        Stack<Character> stack = new Stack<>();

        for (Character c : input) {
            if (PARENTHESIS.containsKey(c)) {
                stack.push(c);
            } else if (stack.empty() || PARENTHESIS.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}