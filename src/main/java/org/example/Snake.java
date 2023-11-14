package org.example;

import javax.swing.*;


public class Snake {
    int size;
    Board board;
    Cell current_loc;
    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    String curr_dir;
    public Snake() {
        this.board = new Board();
        this.size = 1;
        this.current_loc = new Cell(0, 0);
        this.curr_dir = String.valueOf(Direction.RIGHT);
    }

    public int get_size() {
        return this.size;
    }

    public int set_size(int size) {
        this.size = size;
        return this.size;
    }

    public void grow(JPanel sPanel) {
        this.set_size(this.get_size()+10);
        //sPanel.setSize(this.size, 50);
        System.out.printf("Snake has grown. Snake size: %d\n", this.get_size());
    }

    public Cell get_current_loc() {
        return this.current_loc;
    }

    public Cell set_current_loc(Cell current_loc) {
        this.current_loc = current_loc;
        return this.current_loc;
    }

    public void move(JFrame frame, JPanel sPanel, Direction dir, Food food) {
        System.out.printf("Current direction: %s\n", dir);
        if (dir == Direction.RIGHT) {
            current_loc = this.get_current_loc();
            current_loc.x += 100;
            if (current_loc.x > board.size) {
                this.game_over();
            } else {
                System.out.printf("Current location now: (%d, %d)\n", current_loc.x, current_loc.y);
                this.set_current_loc(current_loc);
                sPanel.setLocation(current_loc.x, current_loc.y);
                frame.repaint();
            }
        }
        else if (dir == Direction.LEFT) {
            current_loc = this.get_current_loc();
            current_loc.x -= 100;
            if (current_loc.x < 0) {
                this.game_over();
            } else {
                System.out.printf("Current location now: (%d, %d)\n", current_loc.x, current_loc.y);
                this.set_current_loc(current_loc);
                sPanel.setLocation(current_loc.x, current_loc.y);
                frame.repaint();
            }
        }
        else if (dir == Direction.UP) {
                current_loc = this.get_current_loc();
                current_loc.y -= 100;
                if (current_loc.y < 0) {
                    this.game_over();
                } else {
                    System.out.printf("Current location now: (%d,%d)\n", current_loc.x, current_loc.y);
                    this.set_current_loc(current_loc);
                    sPanel.setLocation(current_loc.x, current_loc.y);
                    frame.repaint();

                }
            }

        else if (dir == Direction.DOWN) {
                    current_loc = this.get_current_loc();
                    current_loc.y += 100;
                    if (current_loc.y > board.size) {
                        this.game_over();
                    } else {
                        System.out.printf("Current location now: (%d, %d)\n", current_loc.x, current_loc.y);
                        this.set_current_loc(current_loc);
                        sPanel.setLocation(current_loc.x, current_loc.y);
                        frame.repaint();
                    }
                }
//        if (this.current_loc.x == food.location.x && this.current_loc.y == food.location.y) {
//            food.consume_food();
//            this.grow(sPanel);
//            food.generate_food(frame, sPanel);
//        }
            }

    public void game_over() {
        System.out.println("Game Over.\nRestart the game");
        System.exit(1);
    }
}
