import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	
	private Board testBoard;
	private Object[] tBoard;
	
	@Before
	public void setUp() {
		testBoard = new Board<Tile>();
	}
	
	@Test
	public void testGetTurn() {
		assertTrue(testBoard.getTurn());
	}
	
	@Test
	public void testSetTurn() {
		testBoard.setTurn(false);
		assertFalse(testBoard.getTurn());
	}

	@Test
	public void testRight() {
		testBoard.right(testBoard);
		int pos = testBoard.findplayer1(testBoard);
		assertEquals(1, pos);
	}
	
	@Test
	public void testLeft() {
		testBoard.right(testBoard);
		testBoard.up(testBoard);
		testBoard.left(testBoard);
		int pos = testBoard.findplayer1(testBoard);
		assertEquals(0, pos);
	}
	
	@Test
	public void testUp() {
		testBoard.down(testBoard);
		testBoard.down(testBoard);
		testBoard.up(testBoard);
		testBoard.up(testBoard);
		
		int pos = testBoard.findplayer2(testBoard);
		assertEquals(20, pos);
	}
	
	
	@Test
	public void testDown() {
		testBoard.down(testBoard);
		testBoard.down(testBoard);
		testBoard.up(testBoard);
		testBoard.up(testBoard);
		
		int pos = testBoard.findplayer1(testBoard);
		assertEquals(28, pos);
	}
	
	@Test
	public void testGetPlayerScore() {
		testBoard.setP1score(1);
		testBoard.setP2score(4);
		assertEquals(1, testBoard.getP1score());
		assertEquals(4, testBoard.getP2score());
	}
}
