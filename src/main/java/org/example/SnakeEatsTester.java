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
		snake.curr_dir = Snake.Direction.LEFT;
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
		snake.curr_dir = Snake.Direction.UP;
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
	@Test public void snakeNotEats() {
		Snake snake = new Snake();
		snake.size = 2;
		snake.curr_dir = Snake.Direction.RIGHT;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(400,500);
		snake.set_current_loc(cell);
		Food food = new Food();
		food.location.x = 400;
		food.location.y = 0;
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.RIGHT, food, new JPanel());
			food.location.x = snake.current_loc.x+200;
			food.location.y = snake.current_loc.y;
			snake.move(new JFrame(), sPanel, Snake.Direction.RIGHT, food, new JPanel());
			food.location.x = snake.current_loc.x;
			food.location.y = snake.current_loc.y+200;
			snake.move(new JFrame(), sPanel, Snake.Direction.UP, food, new JPanel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(20, snake.get_size());
	}
}