package com.christina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5 {
    private static final String filePath = "day5-input.txt";

    public static void main(String[] args) throws IOException {
        solvePartOne(getInput(filePath));

    }

    public static List<Integer> getInput(String path) throws IOException {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String line;
        List<Integer> input = new ArrayList<>();

        fileReader = new FileReader(path);
        bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            input.add(Integer.parseInt(line));
        }

        return input;
    }

    public static int solvePartOne(List<Integer> input) {
        int i = 0;
        int steps = 0;
        System.out.println("input size: "+input.size());

        while (i >= 0 && i < input.size()) {
            int offset = input.get(i);
            input.set(i, input.get(i) + 1);
            i = i + offset;
            steps++;
        }

        System.out.println("steps: "+steps);

        return steps;
    }
}
