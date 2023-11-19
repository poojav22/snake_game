package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeEatsTester {
	@Test public void snakeEatsDown() {
		Snake snake = new Snake();
		snake.size = 2;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(500,400);
		snake.set_current_loc(cell);
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.DOWN, new Food(), new JPanel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(300, snake.get_size());
	}
	@Test public void snakeEatsUp() {
		Snake snake = new Snake();
		snake.size = 2;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(500,600);
		snake.set_current_loc(cell);
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.UP, new Food(), new JPanel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(300, snake.get_size());
	}
	@Test public void snakeEatsLeft() {
		Snake snake = new Snake();
		snake.size = 2;
		snake.curr_dir = Snake.Direction.LEFT;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(600,500);
		snake.set_current_loc(cell);
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.LEFT, new Food(), new JPanel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(300, snake.get_size());
	}
	@Test public void snakeEatsRight() {
		Snake snake = new Snake();
		snake.size = 2;
		snake.curr_dir = Snake.Direction.RIGHT;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(400,500);
		snake.set_current_loc(cell);
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.RIGHT, new Food(), new JPanel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(300, snake.get_size());
	}
}