package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/phone-book
*/

class Solution {

    private static final Map<String, Integer> phoneBook = new HashMap<>();

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            if (phoneBook.containsKey(s)) {
                System.out.println(s + "=" + phoneBook.get(s));
            } else {
                System.out.println("Not found");
            }
        }
    }
}
