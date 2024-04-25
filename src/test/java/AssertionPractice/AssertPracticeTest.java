package AssertionPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Test
public class AssertPracticeTest {
public void Assertest()
{
	SoftAssert sa=new SoftAssert();
	System.out.println("step1");
	System.out.println("step2");
	sa.assertEquals(true, false);
	System.out.println("step3");
	Assert.assertEquals(true,false);
	System.out.println("step4");
	System.out.println("step5");
	System.out.println("step6");
	System.out.println("step7");
	System.out.println("step8");
	System.out.println("step9");
	sa.assertAll();
}
}
