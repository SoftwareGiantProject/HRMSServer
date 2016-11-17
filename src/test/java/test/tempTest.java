package test;

import static org.junit.Assert.*;
import org.junit.*;

public class tempTest {

	private int a;
	
	@Before
	public void setUp(){
		a = 1;
	}
	
	@Test
	public void test(){
		assertEquals(1,a);
	}
}
