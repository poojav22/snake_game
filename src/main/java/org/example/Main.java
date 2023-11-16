package org.example;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        long sec = 0;
        Snake snake = new Snake();
        Food food = new Food();
        Board board = new Board();
        System.out.println("Starting the Game:");
        final Snake.Direction[] lastDirection = new Snake.Direction[1];
        lastDirection[0] = Snake.Direction.RIGHT;
        JFrame jframe = new JFrame();
        jframe.setSize(board.length, board.breadth);
        JPanel panel = new JPanel();
        JPanel sPanel = new JPanel();
        sPanel.setSize(50,50);
        sPanel.setBackground(Color.RED);
        sPanel.setOpaque(true);
        JPanel fPanel = new JPanel();
        fPanel.setSize(50,50);
        fPanel.setBackground(Color.BLUE);
        fPanel.setOpaque(true);
        panel.add(sPanel);
        panel.add(fPanel);
        jframe.add(panel);
        jframe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                if (keycode == KeyEvent.VK_UP) {
                    System.out.println("Up arrow is pressed");
                    lastDirection[0] = Snake.Direction.UP;
                    snake.move(jframe, sPanel, Snake.Direction.UP, food);

                }
                else if (keycode == KeyEvent.VK_DOWN) {
                    System.out.println("Down arrow is pressed");
                    lastDirection[0] = Snake.Direction.DOWN;
                    snake.move(jframe, sPanel, Snake.Direction.DOWN, food);

                }
                else if (keycode == KeyEvent.VK_RIGHT) {
                    System.out.println("Right arrow is pressed");
                    lastDirection[0] = Snake.Direction.RIGHT;
                    snake.move(jframe, sPanel, Snake.Direction.RIGHT, food);

                }
                else if (keycode == KeyEvent.VK_LEFT) {
                    System.out.println("Left arrow is pressed");
                    lastDirection[0] = Snake.Direction.LEFT;
                    snake.move(jframe, sPanel, Snake.Direction.LEFT, food);
                }
            }
        });
        jframe.setVisible(true);
        snake.setDirection(lastDirection[0]);
        while(true) {

            Thread.sleep(1000);
            sec += 1;

            System.out.printf("Snake size: %d\n", snake.get_size());
            System.out.printf("Food location: (%d, %d)\n", food.location.x, food.location.y);
            fPanel.setLocation(food.location.x, food.location.y);
            jframe.repaint();
            snake.move(jframe, sPanel, snake.getDirection(), food);

            if (snake.current_loc.x == food.location.x && snake.current_loc.y == food.location.y) {
                food.consume_food();
                snake.grow(sPanel);
                food.generate_food(jframe, fPanel);
            }
            System.out.printf("Seconds elapsed: %d\n", sec);
        }
    }
}
