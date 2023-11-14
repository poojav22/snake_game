package org.example;
import javax.swing.*;
import java.util.Random;
public class Food {
    Cell location = new Cell(500,500);
    Board board = new Board();
    Random rand = new Random();
    public void generate_food(JFrame frame, JPanel flabel) {
        int x = rand.nextInt(board.length/100) * 100;
        int y = rand.nextInt(board.breadth/100) * 100;
        this.location = new Cell(x, y);
        System.out.printf("Generating new food at: (%d, %d)\n", this.location.x, this.location.y );
        flabel.setLocation(this.location.x, this.location.y);
        frame.repaint();
    }

    public void consume_food() {
        System.out.println("Food is consumed\n");
    }
}
