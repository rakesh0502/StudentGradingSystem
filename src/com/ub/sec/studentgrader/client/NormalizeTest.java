package com.ub.sec.studentgrader.client;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class NormalizeTest {


	private static Normalize instance;
	
	@BeforeClass
	public static void setUp() {
	    instance = new Normalize();
	}
	
	@Test
	 public void testNormalization() {
		 
			int[] professionalism  = {5,4,5,1,2};
			int[] meetingParticipation  = {5,4,5,1,2};
			int[] workEvaluation  = {5,4,5,1,2};
			int totalStudents = 5;
			int expectedResultLength  = 5;
			
			double[] result = instance.doNormalization(professionalism, meetingParticipation, workEvaluation, totalStudents);
			assertEquals(expectedResultLength, result.length);

//		    assertEquals(Color.BLUE, instance.getLabelColor());
		  }
}
