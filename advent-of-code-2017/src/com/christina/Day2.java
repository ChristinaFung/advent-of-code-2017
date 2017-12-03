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

            String[] input = sheetInput.split("[\t]+");
            List<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < input.length; i++) {
                numbers.add(Integer.parseInt(input[i]));
            }

            maxNum = Collections.max(numbers);
            minNum = Collections.min(numbers);

            difference = maxNum - minNum;
            checkSum = checkSum + difference;
        }
    }
}
