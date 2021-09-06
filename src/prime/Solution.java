package prime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/*
https://www.hackerrank.com/challenges/prime-checker
*/

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Prime {

    public void checkPrime(int... numbers) {
        for (int number : numbers) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private boolean isPrime(int number) {
        //optimized primality test based on: https://en.wikipedia.org/wiki/Primality_test
        if (number == 2 || number == 3) {
            return true;
        } else if (number <= 1 || number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; Math.pow(i, 2) <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
