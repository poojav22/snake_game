package org.example;

class Cell {
    int x;
    int y;
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Board {
    int length;
    int breadth;
    int size;
    Board() {
        this.size = 1400;
        this.length = 14 * 100;
        this.breadth = 8 * 100;

    }
}