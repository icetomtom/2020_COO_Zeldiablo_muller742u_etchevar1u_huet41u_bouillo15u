package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Elements.Case;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/** 
 * teste la classe Case
 */
public class TestCase {
	/**
	 * teste le constructeur avec les valeurs par defauts
	 */
	@Test
	public void test_ConstructeurDefaut() {
		Case c = new Case(0, 1, Case.TYPE_VIDE);
		
		assertEquals("la valeur par defaut n est pas bonne",0, c.getX());
		assertEquals("la valeur par defaut n est pas bonne",1, c.getY());
		assertEquals("la valeur n'est pas bonne",Case.TYPE_VIDE, c.getType());
		
	}

	/**
	 * Lance les tests
	 * @param args
	 */
	public static void main(String[] args) {
		boolean succes = true;
		Result result = JUnitCore.runClasses(TestCase.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
			succes = false;
		}
		if(succes)
			System.out.println("Tous les tests se sont bien passes !");
	}
}
