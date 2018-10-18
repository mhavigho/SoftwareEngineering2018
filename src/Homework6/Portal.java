// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Portal {

	Point location = new Point();
	board board1;
	ImageView imageView;
	int scale = 20;

	public Portal(board Board, int x, int y) {
		board1 = Board;
		location.x = x;
		location.y = y;
		Image portalImage = new Image("images//portal.png", scale, scale, false, true);
		imageView = new ImageView(portalImage);
		imageView.setX(location.x*scale);
		imageView.setY(location.y*scale);
	}
	
	public Point getLoca() {
		return location;
	}
	
	public void setLocation2() {
		location.x = 0;
		location.y = 0;
	}
	
	public ImageView getImageView() {
		return imageView;
	}

}
