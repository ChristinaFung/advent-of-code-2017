package com.christina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day6 {
    private static final String filePath = "day6-input.txt";

    public static void main(String[] args) throws IOException {
       findIndex(getInput(filePath)) ;
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
        int i;
        int cycles = 0;
        Set<List<Integer>> cycleSets = new HashSet<>();

        while(!cycleSets.contains(input)) {
            cycleSets.add(input);
            i = findIndex(input);
            int blocks = input.get(i);

            for (int j = 0; j < blocks; j++) {
                // set input
            }

            cycles++;
        }

        return cycles;
    }

    public static int findIndex(List<Integer> input) {
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
