// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bug implements Observer{
	// locals
	Point bugLocation = new Point();
	Point chipLocation;
	final int scalingFactor = 20;
	Image bugImage;
	ImageView bugImageView;
	board board1;
	
	public Bug(board Board, int scale) {
		board1 = Board;
		do {
			bugLocation.x = 14;
			bugLocation.y = 16;
		} while (board1.chipsGrid[bugLocation.x][bugLocation.y] != 0);
		Image bugImage = new Image("images//BugDown.png", scale, scale, false, true);
		bugImageView = new ImageView(bugImage);
	}
	
	public void setImageView() {
		bugImageView.setX(bugLocation.x*scalingFactor);
		bugImageView.setY(bugLocation.y*scalingFactor);
	}
	
	public ImageView getImageView(){
		return bugImageView;
	}
	
	public Point getBugLoca() {
		return bugLocation;
	}
	public void moveBug() {
		
		if (bugLocation.x - chipLocation.x < 0 && board1.chipsGrid[bugLocation.x +1][bugLocation.y] == 0 ) {
				bugLocation.x++;
		}else if (bugLocation.x - chipLocation.x > 0 && board1.chipsGrid[bugLocation.x -1][bugLocation.y] == 0) {
				bugLocation.x--;
		}
		setImageView();
	}
	
	@Override
	public void update(Observable s, Object arg) {
		if (s instanceof Chip){
			chipLocation = ((Chip)s).getChipLoca();
			moveBug();			
		}
		
	}
	
}