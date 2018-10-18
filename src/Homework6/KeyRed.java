// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class KeyRed implements Key{

	Point location = new Point();
	board board1;
	ImageView imageView;
	int scale = 20;
	int ID = 3;

	public KeyRed(board Board, int x, int y) {
		board1 = Board;
		location.x = x;
		location.y = y;
		Image blueKeyImage = new Image("images//redKey.png", scale, scale, false, true);
		imageView = new ImageView(blueKeyImage);
		imageView.setX(location.x*scale);
		imageView.setY(location.y*scale);
	}

	@Override
	public Point getKeyLoca() {
		return location;
	}

	@Override
	public ImageView getKeyImageView() {
		return imageView;
	}

	@Override
	public int getDoorId() {
		return ID;
	}

}