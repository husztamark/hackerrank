package sha256;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/sha-256
*/

public class Solution {

    private static String input;
    private static String output;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        readInput();
        hashValue();
        printOutput();
    }

    private static void readInput() {
        input = scanner.nextLine();
    }

    private static void hashValue() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = md.digest(input.getBytes(StandardCharsets.UTF_8));
            output = DatatypeConverter.printHexBinary(encodedHash).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printOutput() {
        System.out.println(output);
    }
}
