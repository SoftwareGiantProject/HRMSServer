package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testtemp {

	private int a;
	@Before
	public void setUp(){
		a = 1;
	}
	
	
	@Test
	public void test() {
		assertEquals(1, a);
	}

}
