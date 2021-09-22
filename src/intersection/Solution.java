package intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://www.hackerrank.com/challenges/basics-of-sets-and-relational-algebra-2
*/

public class Solution {

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8));

        s1.retainAll(s2);
        System.out.println(s1.size());
    }

}
