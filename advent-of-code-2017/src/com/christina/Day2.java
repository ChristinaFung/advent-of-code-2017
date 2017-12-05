package com.christina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2 {
    private static final String filePath = "day2-input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String sheetInput;
        int checkSum = 0;

        fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);

        while ((sheetInput = bufferedReader.readLine()) != null) {
            int difference;
            int maxNum;
            int minNum;

            String[] input = sheetInput.split("[ \t]+");
            List<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < input.length; i++) {
                numbers.add(Integer.parseInt(input[i]));
            }

            maxNum = Collections.max(numbers);
            minNum = Collections.min(numbers);

            difference = maxNum - minNum;
            checkSum = checkSum + difference;
        }

        System.out.println("********************** PART 2 **********************");
        solveDay2Part2();
    }

    public static void solveDay2Part2() throws IOException {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String sheetInput;
        int checkSum = 0;
        int quotient;

        List<List<Integer>> numbers = new ArrayList<>();

        fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);

        // Read each line from text input file +
        // convert input into a list of integer lists
        while ((sheetInput = bufferedReader.readLine()) != null) {

            String[] input = sheetInput.split("[ \t]+");
            List<Integer> numberRow = new ArrayList<>();

            for (int i = 0; i < input.length; i++) {
                // create row (integer list)
                numberRow.add(Integer.parseInt(input[i]));
            }
            // store each row in the list called "numbers"
            numbers.add(numberRow);
        }

        // use "numbers" list to find checksum
        // for each integer list or row stored in "numbers", compare the value
        // at each index w/ values at all other indices in the list
        // TODO: add...more...comments...

        for(int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).size(); j++) {
                int currentNum = numbers.get(i).get(j);

                for (int k = 0; k < numbers.get(i).size(); k++) {
                    int nextNum = numbers.get(i).get(k);
                    int modulus;

                    // TODO: Refactor this if statement....
                    if (currentNum > nextNum) {
                        modulus = currentNum % nextNum;
                        if (modulus == 0) {
                            quotient = currentNum / nextNum;

                            checkSum = checkSum + quotient;
                        }
                    }
                } // end of k loop
            } // end of j loop
        } // end of i loop

        System.out.println("checkSum: "+checkSum);
    }
}
