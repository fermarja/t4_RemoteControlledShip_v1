package com.jcyl.remotecontrolledship;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LocationTest {

	public LocationTest() {
		super();
	}

	@Test
	public void whenInstantiatedThenXIsStored() {
		Location loc = new Location(new Point(5,7), Direction.NORTH);
		Assert.assertEquals(5, loc.getX());
	}

	@Test
	public void whenInstantiatedThenYIsStored() {
		Location loc = new Location(new Point(5,7), Direction.NORTH);
		Assert.assertEquals(7, loc.getY());
	}

	@Test
	public void whenInstantiatedThenDirectionIsStored() {
		Location loc = new Location(new Point(5,7), Direction.NORTH);
		Assert.assertEquals(Direction.NORTH, loc.getDirection());
	}

	@Test
	public void givenDirectionNWhenForwardThanYDecreases() {
		Location loc = new Location(new Point(5,7), Direction.NORTH);
		loc.forward();
		Assert.assertEquals(6, loc.getY());
	}

	@Test
	public void givenDirectionSWhenForwardThanYIncreases() {
		Location loc = new Location(new Point(5,7), Direction.SOUTH);
		loc.forward();
		Assert.assertEquals(8, loc.getY());
	}

	@Test
	public void givenDirectionEWhenForwardThanXIncreases() {
		Location loc = new Location(new Point(5,7), Direction.EAST);
		loc.forward();
		Assert.assertEquals(6, loc.getX());
	}

	@Test
	public void givenDirectionWWhenForwardThanXDecreases() {
		Location loc = new Location(new Point(5,7), Direction.WEST);
		loc.forward();
		Assert.assertEquals(4, loc.getX());
	}

	@Test
	public void givenDirectionNWhenBackwardThanYIncreases() {
		Location loc = new Location(new Point(5,7), Direction.NORTH);
		loc.backward();
		Assert.assertEquals(8, loc.getY());
	}

	@Test
	public void givenDirectionSWhenBackwardThanYDecreases() {
		Location loc = new Location(new Point(5,7), Direction.SOUTH);
		loc.backward();
		Assert.assertEquals(6, loc.getY());
	}

	@Test
	public void givenDirectionEWhenBackwardThanXDecreases() {
		Location loc = new Location(new Point(5,7), Direction.EAST);
		loc.backward();
		Assert.assertEquals(4, loc.getX());
	}

	@Test
	public void givenDirectionWWhenBackwardThanXIncreases() {
		Location loc = new Location(new Point(5,7), Direction.WEST);
		loc.backward();
		Assert.assertEquals(6, loc.getX());
	}

	@Test
	public void whenTurnLeftThenDirectionIsSet() {
		Location loc = new Location(new Point(5,7), Direction.NORTH);
		loc.turnLeft();
		Assert.assertNotNull(loc.getDirection());
	}

	@Test
	public void whenTurnRightThenDirectionIsSet() {
		Location loc = new Location(new Point(5,7), Direction.NORTH);
		loc.turnRight();
		Assert.assertNotNull(loc.getDirection());
	}

	@Test
	public void givenSameObjectsWhenEqualsThenTrue() {
		Location one = new Location(new Point(5,7), Direction.NORTH);
		
		
		Assert.assertTrue(one.equals(one));
	}

	@Test
	public void givenDifferentObjectWhenEqualsThenFalse() {
		Location one = new Location(new Point(5,7), Direction.NORTH);		
		Assert.assertFalse(one.equals("patata"));
	}

	@Test
	public void givenDifferentXWhenEqualsThenFalse() {
		Location one = new Location(new Point(5,7), Direction.NORTH);
		Location two = new Location(new Point(6,7), Direction.NORTH);
		
		Assert.assertFalse(one.equals(two));
	}

	@Test
	public void givenDifferentYWhenEqualsThenFalse() {
		Location one = new Location(new Point(5,7), Direction.NORTH);
		Location two = new Location(new Point(5,8), Direction.NORTH);
		
		Assert.assertFalse(one.equals(two));
	}

	@Test
	public void givenDifferentDirectionWhenEqualsThenFalse() {
		Location one = new Location(new Point(5,7), Direction.NORTH);
		Location two = new Location(new Point(5,7), Direction.SOUTH);
		
		Assert.assertFalse(one.equals(two));
	}

	@Test
	public void givenSameXYDirectionWhenEqualsThenTrue() {
		Location one = new Location(new Point(5,7), Direction.NORTH);
		Location two = new Location(new Point(5,7), Direction.NORTH);
		
		Assert.assertTrue(one.equals(two));
	}

	@Test
	public void whenCopyThenDifferentObject() {
		Location one = new Location(new Point(5,7), Direction.NORTH);
		Location two = one.copy();
		Assert.assertFalse(one == two);
	}

	@Test
	public void whenCopyThenEquals() {
		Location one = new Location(new Point(5,7), Direction.NORTH);
		Location two = one.copy();
		Assert.assertTrue(one.equals(two));
	}

	@Test
	public void givenDirectionEAndXEqualsMaxXWhenForwardThen1() {
		Location loc = new Location(new Point(10,10), Direction.EAST);
		loc.forward(new Point(10,10));
		Assert.assertEquals(1, loc.getX());
	}

	@Test
	public void givenDirectionWAndXEquals1WhenForwardThenMaxX() {
		Location loc = new Location(new Point(1,1), Direction.WEST);
		loc.forward(new Point(10,10));
		Assert.assertEquals(10, loc.getX());
	}

	@Test
	public void givenDirectionNAndYEquals1WhenForwardThenMaxY() {
		Location loc = new Location(new Point(1,1), Direction.NORTH);
		loc.forward(new Point(10,10));
		Assert.assertEquals(10, loc.getY());
	}

	@Test
	public void givenDirectionSAndYEqualsMaxYWhenForwardThen1() {
		Location loc = new Location(new Point(10,10), Direction.SOUTH);
		loc.forward(new Point(10,10));
		Assert.assertEquals(1, loc.getY());
	}

	@Test
	public void givenObstacleWhenForwardThenReturnFalse() {
		Location loc = new Location(new Point(5,7), Direction.NORTH);
		List<Point> obstacles = new ArrayList<Point>();
		obstacles.add(new Point(5,6));
		boolean result = loc.forward(new Point(10,10), obstacles);
		Assert.assertFalse(result);
	}

	@Test
	public void givenObstacleWhenBackwardThenReturnFalse() {
		Location loc = new Location(new Point(5,7), Direction.SOUTH);
		List<Point> obstacles = new ArrayList<Point>();
		obstacles.add(new Point(5,6));
		boolean result = loc.backward(new Point(10,10), obstacles);
		Assert.assertFalse(result);
	}
}
