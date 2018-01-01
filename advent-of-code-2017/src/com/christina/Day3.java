package com.christina;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.abs;

public class Day3 {
    public static void main(String[] args) throws IOException {
        System.out.println(solvePartOne());
        System.out.println(solvePartTwo());
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
        /*
            NOTES:

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

        int sum = 0;
        int input = 368078;
        int layer = 1; // represents each "layer" of the spiral pattern
        HashMap<Coordinate, Integer> data = new HashMap<>();

        data.put(new Coordinate(0,0), 1);
        Coordinate currentCoord = new Coordinate(0,0);

        parentLoop:
         while (sum < input) {
             Coordinate topRight = new Coordinate(layer, layer);
             Coordinate topLeft = new Coordinate(-layer, layer);
             Coordinate bottomLeft = new Coordinate(-layer, -layer);
             Coordinate bottomRight = new Coordinate(layer, -layer);

            // go one to the right of origin
            currentCoord = currentCoord.goRight();
            sum = getSum(currentCoord, data);
            data.put(currentCoord, sum);

            if (sum > input) {
                break parentLoop;
            }

            // one to the right of origin to top right (lol)
            while(!currentCoord.equals(topRight)) {
                currentCoord = currentCoord.goUp();
                sum = getSum(currentCoord, data);
                data.put(currentCoord, sum);

                if (sum > input) {
                    break parentLoop;
                }
            }

            // top right to top left
            while(!currentCoord.equals(topLeft)) {
                currentCoord = currentCoord.goLeft();
                sum = getSum(currentCoord, data);
                data.put(currentCoord, sum);

                if (sum > input) {
                    break parentLoop;
                }
            }

            // top left to bottom left
            while(!currentCoord.equals(bottomLeft)) {
                currentCoord = currentCoord.goDown();
                sum = getSum(currentCoord, data);
                data.put(currentCoord, sum);

                if (sum > input) {
                    break parentLoop;
                }
            }

            // bottom left to bottom right
            while(!currentCoord.equals(bottomRight)) {
                currentCoord = currentCoord.goRight();
                sum = getSum(currentCoord, data);
                data.put(currentCoord, sum);

                if (sum > input) {
                    break parentLoop;
                }
            }

            layer++;
        }

        return sum;
    }

    public static int getSum(Coordinate coord, HashMap<Coordinate, Integer> hashmap) {
        int sum = 0;

        // coordinates of all points surrounding current coord
        Coordinate[] coordinates = {
                new Coordinate(coord.x+1,coord.y),
                new Coordinate(coord.x+1,coord.y+1),
                new Coordinate(coord.x,coord.y+1),
                new Coordinate(coord.x-1,coord.y+1),
                new Coordinate(coord.x-1,coord.y),
                new Coordinate(coord.x-1,coord.y-1),
                new Coordinate(coord.x,coord.y-1),
                new Coordinate(coord.x+1,coord.y-1)
        };

        List<Coordinate> surroundingVals = Arrays.asList(coordinates);

        for (int i = 0; i < surroundingVals.size(); i++) {
            Coordinate key = coordinates[i];

            if (hashmap.containsKey(key)) {
                sum += hashmap.get(key);
            }
        }

        return sum;
    }

    public static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate goUp() {
            return new Coordinate(this.x, this.y + 1);
        }

        public Coordinate goLeft() {
            return new Coordinate(this.x - 1, this.y);
        }

        public Coordinate goDown() {
            return new Coordinate(this.x, this.y - 1);
        }

        public Coordinate goRight() {
            return new Coordinate(this.x + 1, this.y);
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

        @Override
        public String toString() {
            return "x: "+this.x+", y: "+this.y;
        }
    }
}


