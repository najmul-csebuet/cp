package Codeforces.Easy_Problems_Bootcamp.day6;

import java.io.*;
import java.util.*;

public class P51 {

    public static void main(String[] args) throws IOException {
        Scanner io = new Scanner(System.in);
        long n = io.nextLong();
        long t = n;
        long sum = 0;
        while (t-- > 1) {
            int a = io.nextInt();
            sum += a;
        }
        System.out.println((n * (n + 1) / 2) - sum);
    }
}
