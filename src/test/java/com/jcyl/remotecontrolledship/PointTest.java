package com.jcyl.remotecontrolledship;

import org.junit.Assert;
import org.junit.Test;


public class PointTest {

	public PointTest() {
		super();
	}

	
	@Test
	public void whenInstantiatedThenXIsSet(){ 
		Point point = new Point (5,7);
		Assert.assertEquals(5, point.getX());
	}
	@Test
	public void whenInstantiatedThenYIsSet(){ 
		Point point = new Point (5,7);
		Assert.assertEquals(7, point.getY());
	}
}
