package org.example;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeInvalidMovesTester {
	@Test public void test0() {
		Snake snake = new Snake();
		snake.size = 2;
		snake.curr_dir = Snake.Direction.RIGHT;
		JPanel sPanel = new JPanel();
		sPanel.setSize(50,50);
		Cell cell = new Cell(400,snake.board.breadth-400);
		snake.set_current_loc(cell);
		boolean thrown = false;
		Food food = new Food();
		try {
			snake.move(new JFrame(), sPanel, Snake.Direction.LEFT, food, new JPanel());
			food.location.x = 400;
			food.location.y = snake.board.breadth-500;
			snake.move(new JFrame(), sPanel, Snake.Direction.UP, food, new JPanel());
			snake.move(new JFrame(), sPanel, Snake.Direction.DOWN, food, new JPanel());
			snake.move(new JFrame(), sPanel, Snake.Direction.LEFT, food, new JPanel());
			snake.move(new JFrame(), sPanel, Snake.Direction.RIGHT, food, new JPanel());
			food.location.x = 300;
			food.location.y = snake.board.breadth-400;
			snake.move(new JFrame(), sPanel, Snake.Direction.DOWN, food, new JPanel());
			snake.move(new JFrame(), sPanel, Snake.Direction.UP, food, new JPanel());
			food.location.x = 400;
			food.location.y = snake.board.breadth-400;
			snake.move(new JFrame(), sPanel, Snake.Direction.RIGHT, food, new JPanel());
			assertEquals(400,snake.current_loc.x);
			assertEquals(snake.board.breadth-400,snake.current_loc.y);
		} catch (Exception e) {
			thrown = true;
		}
	}
}