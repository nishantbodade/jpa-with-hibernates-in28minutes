package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathtest {

	@Test
	void sum_with3numbers() {
		MyMath math=new MyMath();
		
		int result=math.sum(new int[] {1,2,3,4});
		assertEquals(10, result);
		
			}

}
