// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FireRetardantShoe {
	Point location = new Point();
	board board1;
	ImageView imageView;
	int scale = 20;
	int ID = 1;

	public FireRetardantShoe(board Board, int x, int y) {
		board1 = Board;
		location.x = x;
		location.y = y;
		Image blueKeyImage = new Image("images//FireRetardantShoe.png", scale, scale, false, true);
		imageView = new ImageView(blueKeyImage);
		imageView.setX(location.x*scale);
		imageView.setY(location.y*scale);
	}

	public Point getLoca() {
		return location;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public int getId() {
		return 0;
	}

}
