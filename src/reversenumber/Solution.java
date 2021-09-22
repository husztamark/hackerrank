package reversenumber;

public class Solution {

    public static void main(String[] args) {
        int original = 676;
        int num = 676;
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }

        System.out.println("Reversed number: " + reversed);
        if (reversed == original) {
            System.out.println(original + " is a palindrome");
        }
    }
}
