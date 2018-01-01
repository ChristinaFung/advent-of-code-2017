package com.christina;

import java.io.IOException;
import static java.lang.Math.abs;

public class Day3 {
    public static void main(String[] args) throws IOException {
        System.out.println(solvePartOne());
    }

    public static int solvePartOne() throws IOException {
        // if we know n, we can find the abs value of "y" for the "middle value" in each section of a spiral layer
        // 1 is at 0,0
        // the steps = (abs value of x) + (abs value of y)
        // middle value = corner - (n/2)
        // y of the middle value = quotient (int value) of (n / 2)

        //finding (n * n) and n
        int n = 1;
        int input = 368078;
        int steps = 0;

        // corner values
        int topLeftVal;
        int topRightVal;
        int bottomLeftVal;
        int bottomRightVal;
        int middleVal = 0;

        while ((n * n) < input) {
            n = n + 1;
        }

        bottomRightVal = (n * n);
        bottomLeftVal = (n*n) - (n - 1);
        topLeftVal = (n*n) - ((2*n) - 2);
        topRightVal = (n*n) - ((3*n) - 3);

        // finding middle ("cross section") values
        if (input >= bottomLeftVal && input < bottomRightVal) {
            middleVal = bottomRightVal - (n/2);
        } else if (input >= topLeftVal && input < bottomLeftVal ) {
            middleVal = bottomLeftVal - (n/2);
        } else if (input >= topRightVal && input < topLeftVal) {
            middleVal =  topLeftVal - (n/2);
        } else if (input >= (topRightVal - (n-2)) && input < topRightVal) {
            middleVal = topRightVal - (n/2);
        }

        steps = abs(input - middleVal) + (n/2);

        return steps;
    }
}
