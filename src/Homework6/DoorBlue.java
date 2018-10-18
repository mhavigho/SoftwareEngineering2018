// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import java.awt.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DoorBlue implements Door{

	board board1;
	Point location = new Point();
	ImageView imageView;
	int scale = 20;
	int ID = 1;

	public DoorBlue(board Board, int x, int y) {
		board1 = Board;
		location.x = x;
		location.y = y;
		Image blueDoorImage = new Image("images//blueKeyWall.png", scale, scale, false, true);
		imageView = new ImageView(blueDoorImage);
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
	public ImageView getDoorImageView() {
		return imageView;
	}
	@Override
	public int getDoorId() {
		return ID;
	}
	@Override
	public void unlockDoor() {
		board1.chipsGrid[location.x][location.y] = 0;
	}
}