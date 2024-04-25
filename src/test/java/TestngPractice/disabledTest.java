package TestngPractice;

import org.testng.annotations.Test;

public class disabledTest {
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
		@Test(enabled = true)
		public void deleteTest()
		{
			System.out.println("delete");
		}
		public void updateTest()
		{
			System.out.println("update");
		}
}
}
