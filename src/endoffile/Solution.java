package endoffile;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-end-of-file
*/

public class Solution {

    public static void main(String[] args) {
        URL url = Solution.class.getResource("input.txt");
        if (url != null) {
            try {
                Scanner scanner = new Scanner(new File(url.getPath()));
                int lineNumber = 1;
                while (scanner.hasNextLine()) {
                    System.out.println(lineNumber + " " + scanner.nextLine());
                    lineNumber++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
