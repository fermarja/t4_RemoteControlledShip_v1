package com.jcyl.remotecontrolledship;

import org.junit.Test;
import org.junit.Assert;

public class DirectionTest {

	public DirectionTest() {
		super();
	}

	@Test
	public void whenGetFromShortNameNThenReturnDirectionN() {
		Assert.assertEquals(Direction.NORTH, Direction.getFromShortName('N'));
	}

	@Test
	public void whenGetFromShortNameWThenReturnDirectionW() {
		Assert.assertEquals(Direction.WEST, Direction.getFromShortName('W'));
	}

	@Test
	public void whenGetFromShortNameBThenReturnNone() {
		Assert.assertEquals(Direction.NONE, Direction.getFromShortName('B'));
	}

	@Test
	public void givenSWhenLeftThenE() {
		Direction origin = Direction.SOUTH;
		Direction dest = origin.turnLeft();
		Assert.assertEquals(Direction.EAST, dest);
	}

	@Test
	public void givenSWhenRightThenW() {
		Direction origin = Direction.SOUTH;
		Direction dest = origin.turnRight();
		Assert.assertEquals(Direction.WEST, dest);
	}

	@Test
	public void givenNWhenLeftThenW() {
		Direction origin = Direction.NORTH;
		Direction dest = origin.turnLeft();
		Assert.assertEquals(Direction.WEST, dest);
	}

	@Test
	public void givenWWhenRightThenN() {
		Direction origin = Direction.WEST;
		Direction dest = origin.turnRight();
		Assert.assertEquals(Direction.NORTH, dest);
	}
}
