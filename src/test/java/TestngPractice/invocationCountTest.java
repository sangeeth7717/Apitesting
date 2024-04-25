package TestngPractice;

import org.testng.annotations.Test;

public class invocationCountTest {
	public class orderOfExecutionTest {
		@Test(invocationCount = 2)
		public void createTest()
		{
			System.out.println("Create");
		}
		@Test(invocationCount = 3)
		public void modifyTest()
		{
			System.out.println("modify");
		}
		@Test(priority = -1)
		public void deleteTest()
		{
			System.out.println("delete");
		}
}
}