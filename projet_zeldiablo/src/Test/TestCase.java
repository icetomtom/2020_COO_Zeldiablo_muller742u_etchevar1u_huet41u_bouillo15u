package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Elements.Case;

/** 
 * teste la classe Case
 */
public class TestCase {
	/**
	 * teste le constructeur avec les valeurs par defauts
	 */
	@Test
	public void test_ConstructeurDefaut() {
		Case c = new Case(int x, int y, int type);
		Boolean trouve = false;
		
		assertEquals("la valeur par defaut n est pas bonne",1, c.getX());
		assertEquals("la valeur par defaut n est pas bonne",1,c.getY());
		
	}
}
