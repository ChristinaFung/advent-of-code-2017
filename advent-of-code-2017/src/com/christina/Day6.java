package com.christina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day6 {
    private static final String filePath = "day6-input.txt";

    public static void main(String[] args) throws IOException {
       System.out.println(solvePartOne(getInput(filePath)));
    }

    public static List<Integer> getInput(String path) throws IOException {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String line;
        String[] strInput;
        List<Integer> input = new ArrayList<>();

        fileReader = new FileReader(path);
        bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            strInput = line.split("[ \t]+");

           for (int i = 0; i < strInput.length; i++) {
               input.add(Integer.parseInt(strInput[i]));
           }
        }

        return input;
    }

    public static int solvePartOne(List<Integer> input) {
        int i;
        int j;
        int cycles = 0;

        Set<List<Integer>> cycleSets = new HashSet<>();

        // checks to see if cycle has already been seen
        while(!cycleSets.contains(input)) {

            cycleSets.add(input);
            i = findIndexOfLargestVal(input);
            j = (i == (input.size() - 1)) ? 0 : i + 1;

            int largestVal = input.get(i);

            // remove blocks from memory bank w/ largest amount of blocks
            input.set(i, 0);

            // redistribute blocks amongst memory banks
            // start from index after largestVal
           while (largestVal > 0) {
                input.set(j, input.get(j) + 1);
                largestVal--;

                // reset index to 0 after last index has been reached
                if (j == (input.size() - 1)) {
                    j = 0;
                } else {
                    j++;
                }
            }

            cycles++;
        }

        System.out.println(solvePartTwo(input));

        return cycles;
    }

    public static int solvePartTwo(List<Integer> input) {
        int i;
        int j;
        int infiniteLoopCycles = 0;
        Set<List<Integer>> cycleSets = new HashSet<>();
        List<Integer> inputLastSeen = input;

        while(!cycleSets.contains(inputLastSeen)) {

            cycleSets.add(input);
            i = findIndexOfLargestVal(input);
            j = (i == (input.size() - 1)) ? 0 : i + 1;

            int largestVal = input.get(i);

            input.set(i, 0);

            while (largestVal > 0) {
                input.set(j, input.get(j) + 1);
                largestVal--;

                if (j == (input.size() - 1)) {
                    j = 0;
                } else {
                    j++;
                }
            }

            infiniteLoopCycles++;
        }

        return infiniteLoopCycles;
    }

    public static int findIndexOfLargestVal(List<Integer> input) {
        int largest = input.get(0);
        int index = 0;
        List<Integer> largestValues = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) > largest) {
                largest = input.get(i);
            }
        }


        // write code to replicate "indexOf" method because l e a r n i n g
        for (int i = 0; i < input.size(); i++) {
            int currentVal = input.get(i);

            // check for previous occurrence of largest value
            while (!largestValues.contains(currentVal)) {
                largestValues.add(currentVal);

                if (currentVal == largest) {
                    index = i;
                }
            }

        }

        return index;
    }
}
