package com.jcyl.remotecontrolledship;

import org.junit.Assert;
import org.junit.Test;

public class ShipTest {

	public ShipTest() {
		super();
	}
	
	@Test
	public void permiteIndicarLocalizacionAlCrearBarco() {
		Location loc = new Location(new Point(1, 1), Direction.NORTH);
		Ship ship = new Ship(loc, new Planet(new Point(10,10)));
		Assert.assertEquals(loc, ship.getLocation());
	}

}
