package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class DemoJUnit {

	@Before
	public void setUp() {
		System.out
				.println("@Before method will execute before every JUnit4 test");
	}

	@After
	public void tearDown() {
		System.out
				.println("@After method will execute after every JUnit4 test");
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
		System.out
				.println("@BeforeClass method will be executed before JUnit test for"
						+ "a Class starts");
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		System.out
				.println("@AfterClass method will be executed after JUnit test for"
						+ "a Class Completed");
	}

	@Test
	public void calculateInterest() {
		System.out.println("calculateInterest");
		Assert.fail("An Example of @Test JUnit4 journel.dev");
	}

	@Ignore("Not yet implemented")
	@Test
	public void testGetAmount() {
		System.out.println("getAmount");
		Assert.fail("@Ignore method will not run by JUnit4");
	}

	@Test(timeout = 500)
	public void testTimeout() {
		int i = 1;
		System.out
				.println("@Test(timeout) can be used to enforce timeout in JUnit4 test case");
		while (1 == i)
			System.out.println("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testException(int input) {
		System.out
				.println("@Test(expected) will check for specified exception during its run");

	}

}