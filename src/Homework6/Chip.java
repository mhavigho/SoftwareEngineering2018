// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class Chip extends Observable{

	Point location = new Point();
	board board1;
	List<Key> bag;
	int doorId = 1;
	
	public Chip(board Board) {
		board1 = Board;
		location.x = 10;
		location.y = 20;
		bag = new LinkedList<Key>();
	}
	
	public Point getChipLoca() {
		return location;
	}
	
	public int getDoorId() {
		return doorId;
	}
	
	public void resetChip() {
		location.x = 10;
		location.y = 20;
	}
	
	public void resetChipTwo() {
		location.x = 7;
		location.y = 20;
	}
	
	public void goNorth() {
		if(location.y > 0 && board1.chipsGrid[location.x][location.y-1] != 1) {
			location.y -= 1;
			setChanged();
			notifyObservers();
		}
	}

	public void goSouth() {
		if(location.y < 24 && board1.chipsGrid[location.x][location.y +1] != 1) {
			location.y += 1;
			setChanged();
			notifyObservers();
		}
	}
	
	public void goEast() {
		if(location.x < 24 && board1.chipsGrid[location.x +1][location.y] != 1) {
			location.x += 1;
			setChanged();
			notifyObservers();
		}
	}
	
	public void goWest() {
		if(location.x > 0 && board1.chipsGrid[location.x -1][location.y] != 1) {
			location.x -= 1;
			setChanged();
			notifyObservers();
		}
	}
}