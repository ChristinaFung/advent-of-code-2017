package com.christina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    private static final String filePath = "puzzle-input.txt";

    public static void main(String[] args) throws IOException {
//      thanks to this tutorial:
//      https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
        BufferedReader bufferedReader;
        FileReader fileReader;
        String puzzleInput;

        fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);

        puzzleInput = bufferedReader.readLine();
        System.out.println("part 1 answer: "+solveCaptcha(puzzleInput));
        System.out.println("part 2 answer: "+solveCaptchaPart2(puzzleInput));

    }

    public static int solveCaptcha(String input) {
        int sum = 0;

        for(int i = 0; i < input.length(); i++) {
            char firstNum = input.charAt(0);
            char currentNum = input.charAt(i);
            char nextNum = (i == input.length() - 1) ? firstNum : input.charAt(i + 1);

            if (currentNum == nextNum) {
                int matchedDigit = Character.getNumericValue(currentNum);
                sum = sum + matchedDigit;
            }
        }
        return sum;
    }

    public static int solveCaptchaPart2(String input) {
        int sum = 0;
        int steps = input.length() / 2;
        System.out.println("steps: "+steps);

        for(int i = 0; i < input.length(); i++) {
            char currentNum = input.charAt(i);
//            char nextNum = (i >= steps) ? input.charAt(steps - (input.length() - i)) : input.charAt(i + steps);
//          better solution: could use modulo operator to derive the value that must be subtracted from steps
//          when index is greater than or equal to the halfway point
            int halfWaySum = i + steps;
            char nextNum = input.charAt(halfWaySum % input.length());

            if (currentNum == nextNum) {
                int matchedDigit = Character.getNumericValue(currentNum);
                sum = sum + matchedDigit;
            }
        }

        return sum;

    }
}
