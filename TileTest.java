import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class TileTest {

		
		
	private Tile t;

	@SuppressWarnings("unused")
	@Before 
	public void setUp() {
		t = new Tile();
		t.setPlatform(true);
	}
	
	@Test
	public void testGetPlatform() {
		assertTrue(t.getPlatform());
			
	}
		
	@Test
	public void testSetPlatform() {
		t.setPlatform(false);
		assertFalse(t.getPlatform());
	}
	
	@Test
	public void testGetPerson() {	
		t.setPerson(true);
		assertTrue(t.getPerson());
	}
	
	@Test
	public void testSetPerson() {
		t.setPerson(true);
		t.setPerson(false);
		assertFalse(t.getPerson());
	}
	
	@Test
	public void testGetColor() {
		t.setColor(Color.YELLOW);
		assertEquals(Color.YELLOW, t.getColor());
	}
	
	@Test
	public void testSetPlayer() {
		t.setPlayer("Player 1");
		assertEquals("Player 1", t.getPlayer());
	}
}
