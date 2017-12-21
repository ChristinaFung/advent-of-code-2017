package com.christina;

import java.io.IOException;

public class Day3 {
    public static void main(String[] args) throws IOException {
        int n = 1;
        int input = 368078;

        while ((n * n) < input) {
            n = n + 1;
            System.out.println("n: "+n);
            System.out.println("n*n: "+(n * n));
        }
        System.out.println("n*n: "+(n * n));
    }
}
