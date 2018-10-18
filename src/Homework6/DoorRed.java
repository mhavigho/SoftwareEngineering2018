// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DoorRed implements Door{
	
	board board1;
	Point location = new Point();
	ImageView imageView;
	int scale = 20;
	int ID = 3;

	public DoorRed(board Board, int x, int y) {
		board1 = Board;
		location.x = x;
		location.y = y;
		Image redDoorImage = new Image("images//redKeyWall.png", scale, scale, false, true);
		imageView = new ImageView(redDoorImage);
		imageView.setX(location.x*scale);
		imageView.setY(location.y*scale);
		board1.chipsGrid[location.x][location.y] = 1;
	}

	@Override
	public Point getDoorLoca() {
		return location;
	}

	@Override
	public void lockDoor() {
		board1.chipsGrid[location.x][location.y] = 1;
		
	}

	@Override
	public int getDoorId() {
		return ID;
	}

	@Override
	public void unlockDoor() {
		board1.chipsGrid[location.x][location.y] = 0;
		
	}

	@Override
	public ImageView getDoorImageView() {
		return imageView;
	}

}
