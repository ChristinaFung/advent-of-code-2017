package com.christina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day6 {
    private static final String filePath = "day6-input.txt";

    public static void main(String[] args) throws IOException {
//       findIndexOfLargestVal(getInput(filePath));
       solvePartOne(getInput(filePath));
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

        System.out.println("input: "+input);

        return input;
    }

    public static int solvePartOne(List<Integer> input) {
        int i = 0;
        int j = 0;
        int cycles = 0;
        Set<List<Integer>> cycleSets = new HashSet<>();


        // checks to see if cycle has already been seen
        while(!cycleSets.contains(input)) {
            cycleSets.add(input);
            i = findIndexOfLargestVal(input);
            j = (i == (input.size() - 1)) ? 0 : i + 1;

            System.out.println("j: "+j+" i: "+i);
            int largestVal = input.get(i);
            System.out.println("largestVal: "+largestVal);


            // redistribute blocks amongst memory banks
            // start from index after largestVal
           while (j >= 0 && j < input.size() && largestVal != 0) {
                input.set(j, input.get(j) + 1);
                largestVal--;

                // reset index to 0 after last index has been reached
                if (j == (input.size() - 1)) {
                    j = 0;
                } else {
                    j++;
                }

                System.out.println("largestVal decremented: "+largestVal);
                System.out.println("j is now: "+j);
            }
            System.out.println("next cycle: "+input);

            cycles++;
        }
        System.out.println("cycles: "+cycles);

        return cycles;
    }

    public static int findIndexOfLargestVal(List<Integer> input) {
        int largest = input.get(0);
        int index = 0;

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) > largest) {
                largest = input.get(i);
            }
        }

        // write code to replicate "indexOf" method because l e a r n i n g
        for (int i = 0; i < input.size(); i++) {
            int currentVal = input.get(i);
            if (currentVal == largest) {
                index = i;
                System.out.println("i: "+i);
            }
        }

        return index;
    }


}
