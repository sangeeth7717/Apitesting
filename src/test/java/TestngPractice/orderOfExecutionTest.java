package TestngPractice;

import org.testng.annotations.Test;

public class orderOfExecutionTest {
@Test(priority = 1)
public void createTest()
{
	System.out.println("Create");
}
@Test
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
