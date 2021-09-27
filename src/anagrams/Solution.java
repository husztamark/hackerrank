package anagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-anagrams
*/

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Integer> aMap = countCharsIntoMap(a);
        Map<Character, Integer> bMap = countCharsIntoMap(b);
        return aMap.equals(bMap);
    }

    private static Map<Character, Integer> countCharsIntoMap(String input) {
        Map<Character, Integer> result = new HashMap<>();
        input.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> {
                    if (result.containsKey(c)) {
                        result.put(c, result.get(c) + 1);
                    } else {
                        result.put(c, 1);
                    }
                });
        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
