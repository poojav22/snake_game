package org.example;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeBoundaryTester {
	@Test public void snakeHitsDown() {
		Snake snake = new Snake();
		snake.size = 2;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(400,snake.board.breadth);
		snake.set_current_loc(cell);
		boolean thrown = false;
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.DOWN, new Food(), new JPanel());
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test public void snakeNotHitsDown() {
		Snake snake = new Snake();
		snake.size = 2;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(400,snake.board.breadth);
		Food food = new Food();
		food.location = cell;
		snake.set_current_loc(cell);
		boolean thrown = false;
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.RIGHT, food, new JPanel());
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}
	@Test public void snakeHitsRight() {
		Snake snake = new Snake();
		snake.size = 2;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(snake.board.length,400);
		snake.set_current_loc(cell);
		boolean thrown = false;
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.RIGHT, new Food(), new JPanel());
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test public void snakeHitsUp() {
		Snake snake = new Snake();
		snake.size = 2;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(400,0);
		snake.set_current_loc(cell);
		boolean thrown = false;
		Food food = new Food();
		food.location = cell;
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.UP, new Food(), new JPanel());
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test public void snakeHitsLeft() {
		Snake snake = new Snake();
		snake.size = 2;
		snake.curr_dir = Snake.Direction.LEFT;
		JPanel sPanel = new JPanel();
		JPanel fPanel = new JPanel();
		JFrame sFrame = new JFrame();
		Food food = new Food();
		sPanel.setSize(50,50);
		Cell cell = new Cell(100,200);
		snake.set_current_loc(cell);
		food.location = cell;
		boolean thrown = false;
		try {
			snake.move(sFrame, sPanel, Snake.Direction.DOWN, food, fPanel);
			snake.move(sFrame, sPanel, Snake.Direction.LEFT, food, fPanel);
			Cell c = snake.current_loc;
			c.y = c.y = 100;
			snake.move(sFrame, sPanel, Snake.Direction.UP, food, fPanel);
			snake.move(sFrame, sPanel, Snake.Direction.LEFT, food, fPanel);
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test public void foodExists() {
		Snake snake = new Snake();
		snake.size = 2;
		snake.curr_dir = Snake.Direction.LEFT;
		JPanel sPanel = new JPanel();
		JPanel fPanel = new JPanel();
		JFrame sFrame = new JFrame();
		Food food = new Food();
		sPanel.setSize(50,50);
		Cell cell = new Cell(100,200);
		snake.set_current_loc(cell);
		food.location = cell;
		boolean thrown = false;
		try {
			snake.move(sFrame, sPanel, Snake.Direction.RIGHT, food, fPanel);
			snake.move(sFrame, sPanel, Snake.Direction.DOWN, food, fPanel);
			snake.move(sFrame, sPanel, Snake.Direction.UP, food, fPanel);
			snake.move(sFrame, sPanel, Snake.Direction.LEFT, food, fPanel);
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
		assertTrue(food.location.x >= 0);
		assertTrue(food.location.y >= 0);
		assertTrue(food.location.x <= snake.board.length);
		assertTrue(food.location.y <= snake.board.breadth);
	}
}