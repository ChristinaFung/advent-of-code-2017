package com.christina;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    private static final String filePath = "day4-input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String lineInput;

        List<List<String>> passphrases = new ArrayList<>();

        fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);

        while ((lineInput = bufferedReader.readLine()) != null) {
            String[] input = lineInput.split("[ \t]+");
            List<String> passwordLine = new ArrayList<>();

            for (int i = 0; i < input.length; i++) {
                // create row for each password line
               passwordLine.add(input[i]);
            }
            // store each row in the list called "numbers"
           passphrases.add(passwordLine);
        }
        
        System.out.println(solvePart1(passphrases));

    }

    public static int solvePart1(List<List<String>> args) {
        List<List<String>> passphrases = args;
        int validPhraseCount = 0;

        for (List<String> passphrase : passphrases) {
            boolean isValidPhrase = true;

            // ty based StackOverflow: https://stackoverflow.com/questions/886955/breaking-out-of-nested-loops-in-java
            secondLoop:
            for (int j = 0; j < passphrase.size(); j++) {
                String currentWord = passphrase.get(j);

                for (int k = (j + 1); k < passphrase.size(); k++) {
                    String nextWord = passphrase.get(k);

                    if (currentWord.equals(nextWord)) {
                        isValidPhrase = false;
                        break secondLoop;
                    }
                } // end of k loop
            } // end of j loop

            if (isValidPhrase) {
                validPhraseCount++;
            }
        }

        return validPhraseCount;
    }
}
