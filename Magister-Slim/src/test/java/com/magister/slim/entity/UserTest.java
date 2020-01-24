package com.magister.slim.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UserTest {

	public int value1,value2;
	@Before
	public void setUp()
	{
		value1=3;
		value2=3;
	}
	@Test
	public void test() {
		double result=value1+value2;
		assertTrue(result==6);
		//fail();
		
	}
	@Ignore
	@Test
	public void demo() {
		System.out.println("hello");
		fail();
	}
	

}
