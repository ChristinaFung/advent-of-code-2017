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

    public static int solvePartTwo() throws IOException {
        int answer = 0;

        /*
            1. dont know any values beforehand
                - need dynamic data structure
            2. current value based on prev values
                - need to know prev values, prev values must be stored (efficiently)
            3. need to know position (adjacent + diagonals)
                - coordinates
                - key value pairs (key: coordinate, value: sum at that coord)

           next:
           - how to represent coordinates as keys
           - how to get surrounding values
           - how to iterate through all the key value pairs
         */

        /*
            while sum < input

         */
        return answer;
    }

    class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return this.x;
        }

        public int y() {
            return this.y;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Coordinate)) {
                return false;
            }

            Coordinate coordinate = (Coordinate) obj;

            return (this.x == coordinate.x && this.y == coordinate.y);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + x;
            result = 31 * result + y;
            return result;
        }
    }
}


