package com.jcyl.remotecontrolledship;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ShipTest {

	public ShipTest() {
		super();
	}
	
	@Test
	public void permiteIndicarLocalizacionAlCrearBarco() {
		Location loc = new Location(new Point(2, 2), Direction.NORTH);
		Ship ship = new Ship(loc, new Planet(new Point(10,10)));
		Assert.assertEquals(loc, ship.getLocation());
	}

	
	@Test
	public void moverForward() {
		Location loc = new Location(new Point(2, 2), Direction.NORTH);
		Ship ship = new Ship(loc, new Planet(new Point(10,10), new ArrayList<Point>()));
		ship.moveForward();
		Location destino = new Location(new Point(2,1), Direction.NORTH);
		Assert.assertEquals(destino, ship.getLocation());
	}
	@Test
	public void moverBackward() {
		Location loc = new Location(new Point(2, 2), Direction.NORTH);
		Ship ship = new Ship(loc, new Planet(new Point(10,10), new ArrayList<Point>()));
		ship.moveBackward();
		Location destino = new Location(new Point(2,3), Direction.NORTH);
		Assert.assertEquals(destino, ship.getLocation());
	}
	
	@Test
	public void giraDerecha() {
		Location loc = new Location(new Point(2, 2), Direction.NORTH);
		Ship ship = new Ship(loc, new Planet(new Point(10,10), new ArrayList<Point>()));
		ship.turnRight();
		Location destino = new Location(new Point(2,2), Direction.EAST);
		Assert.assertEquals(destino, ship.getLocation());
	}
	@Test
	public void giraIzquierda() {
		Location loc = new Location(new Point(2, 2), Direction.NORTH);
		Ship ship = new Ship(loc, new Planet(new Point(10,10), new ArrayList<Point>()));
		ship.turnLeft();
		Location destino = new Location(new Point(2,2), Direction.WEST);
		Assert.assertEquals(destino, ship.getLocation());
	}
	
	@Test
	public void comandosMultiples() {
		Location loc = new Location(new Point(2, 2), Direction.NORTH);
		Ship ship = new Ship(loc, new Planet(new Point(10,10), new ArrayList<Point>()));
		ship.receiveCommands("rf");
		Location destino = new Location(new Point(3,2), Direction.EAST);
		Assert.assertEquals(destino, ship.getLocation());
	}
}
