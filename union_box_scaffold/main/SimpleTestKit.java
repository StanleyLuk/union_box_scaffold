package main;

import main.Box;
import main.Coordinate;
import main.UnionBox;

public class SimpleTestKit {

    public static void printCoords(Coordinate[] clist) {

        String r = "[";

        for (int i = 0; i < clist.length; i++) {
            r += clist[i].toString();
            if (i != clist.length - 1) {
                r += ", ";
            }
        }

        r += "]";

        System.out.println(r);

    }


    public static void main(String[] args) {

        // Example Test Case
        /*
         *
         *   Tests the example of multiple boxes
         *
         *   4 |                   ______
         *   3 |     ____         |    __|_______________
         *   2 |   _|__  |    ____|   |  |               |
         *   1 |  | |  | |   |    |   |  |               |
         *   0 |__|_|__|_|___|____|___|__|_______________|________
         *        2 4  7 9   13   18  22 25              40
         */


        UnionBox ub = new UnionBox();
        Box[] boxes = new Box[5];
        boxes[0] = new Box(2, 7, 2);
        boxes[1] = new Box(4, 9, 3);
        boxes[2] = new Box(13, 18, 2);
        boxes[3] = new Box(18, 25, 4);
        boxes[4] = new Box(22, 40, 3);

        Coordinate[][] boxCoords = new Coordinate[5][4];
        for (int i = 0; i < boxes.length; ++i) {
            boxCoords[i] = boxes[i].getBoxCoordinates();
        }

        Coordinate[] expected = new Coordinate[]{
                new Coordinate(2, 0),
                new Coordinate(2, 2),
                new Coordinate(4, 2),
                new Coordinate(4, 3),
                new Coordinate(9, 3),
                new Coordinate(9, 0),
                new Coordinate(13, 0),
                new Coordinate(13, 2),
                new Coordinate(18, 2),
                new Coordinate(18, 4),
                new Coordinate(25, 4),
                new Coordinate(25, 3),
                new Coordinate(40, 3),
                new Coordinate(40, 0)
        };

        Coordinate[] result = ub.union(boxCoords);

        System.out.println("Expected:");
        printCoords(expected);
        System.out.println("Got:");
        printCoords(result);

        // Recursive
        /*
         *   Tests the recursive box test.
         *   10   _______________
         *   9 | |  _________   |
         *   8 | | |  ______  | |
         *   7 | | | |      | | |
         *   6 | | | |      | | |
         *   5 | | | |      | | |
         *   4 | | | |      | | |
         *   3 | | | |      | | |
         *   2 | | | |  _   | | |
         *   1 | | | | | |  | | |
         *   0 |_|_|_|_|_|__|_|_|_____
         *       2 4 6 7 10 131517
         */
        ub = new UnionBox();
        boxes = new Box[4];
        boxes[0] = new Box(2, 17, 10);
        boxes[1] = new Box(4, 15, 9);
        boxes[2] = new Box(6, 13, 8);
        boxes[3] = new Box(7, 10, 2);

        boxCoords = new Coordinate[4][4];
        for (int i = 0; i < boxes.length; ++i) {
            boxCoords[i] = boxes[i].getBoxCoordinates();
        }

        expected = boxes[0].getBoxCoordinates();
        result = ub.union(boxCoords);

        System.out.println("Expected:");
        printCoords(expected);
        System.out.println("Got:");
        printCoords(result);
    }
}
