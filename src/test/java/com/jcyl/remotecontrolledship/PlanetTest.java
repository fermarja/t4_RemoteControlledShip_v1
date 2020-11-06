package com.jcyl.remotecontrolledship;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
public class PlanetTest {

	public PlanetTest() {
		super();
	}

	@Test
	public void whenInstantiatedThenMaxIsSet(){
		Point max = new Point(10, 20);
		Planet planet = new Planet(max);
		Assert.assertEquals(max, planet.getMax());
	}
	@Test
	public void whenInstantiatedThenObstaclesAreSet(){ 
		List<Point> obstacles = new ArrayList<Point>();
		obstacles.add(new Point (1,1));
		Point max = new Point(10, 20);
		Planet planet = new Planet(max, obstacles);
		Assert.assertEquals(obstacles, planet.getObstacles());
	}
}
