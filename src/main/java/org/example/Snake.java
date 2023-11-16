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
    Direction  curr_dir;
    public Snake() {
        this.board = new Board();
        this.size = 1;
        this.current_loc = new Cell(0, 0);
        this.curr_dir = Direction.RIGHT;
    }

    public int get_size() {
        return this.size * 10;
    }

    public void set_size(int size) {
        this.size = size;
    }

    public void grow(JPanel sPanel) {
        this.set_size(this.get_size()+10);
        this.snakeRedraw(sPanel, this.getDirection(), true);
        System.out.printf("Snake has grown. Snake size: %d\n", this.get_size());
    }

    public Cell get_current_loc() {
        return this.current_loc;
    }

    public void set_current_loc(Cell current_loc) {
        this.current_loc = current_loc;
    }

    public Direction getDirection() {
        return this.curr_dir;
    }

    public void setDirection(Direction dir) {
        this.curr_dir = dir;
    }

    public void snakeRedraw(JPanel sPanel, Direction dir, boolean grow) {
        int temp;
        int height = sPanel.getHeight();
        int width = sPanel.getWidth();
        System.out.printf("width: %d, height:%d ", width,height);
        System.out.printf("Curr dir: %s, Dir %s\n",  curr_dir, dir);
        if (this.curr_dir != dir) {
            temp = width;
            width = height;
            height = temp;
        }
        if (this.curr_dir == Direction.RIGHT || this.curr_dir == Direction.LEFT) {
            if (grow) {
                width += 10;
            }

        } else if (this.curr_dir == Direction.UP || this.curr_dir == Direction.DOWN) {
            if (grow) {
                height += 10;
            }
        }
        sPanel.setSize(width, height);
    }
    public void move(JFrame frame, JPanel sPanel, Direction dir, Food food) {
        System.out.printf("Current direction: %s\n", dir);
        //
        this.snakeRedraw(sPanel, dir, false);
        this.setDirection(dir);
        if (dir == Direction.RIGHT) {
            current_loc = this.get_current_loc();
            current_loc.x += 100;
            if (current_loc.x > board.length) {
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
                    if (current_loc.y > board.breadth) {
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
