package TestngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DepentsonmethodTest {
	@Test
	public void create() {
		
		System.out.println("create");
	}

	@Test(dependsOnMethods = "create")
	public void modifyTest() {
		Assert.fail();
		System.out.println("modify");
	}

	@Test(dependsOnMethods = { "create", "modifyTest" })
	public void deleteTest() {
		System.out.println("delete");
	}

	@Test(dependsOnMethods = "create")
	public void updateTest() {
		System.out.println("update");
	}
}
