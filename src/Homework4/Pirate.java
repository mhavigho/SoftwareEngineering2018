package Homework4;
// Michael Havighorst
// Software Engineering
// Homework 4

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Observable;
import java.util.Observer;

public class Pirate implements Observer{
	
	Point locatePirate = new Point();
	Point locateShip;
	final int scalingFactor = 50;
	Image pirateImage;
	ImageView pirateImageView;
	OceanMap theOcean;
	
	public Pirate(OceanMap oceanMap) {
		theOcean = oceanMap;
		do {
			locatePirate.x = ThreadLocalRandom.current().nextInt(0, 10);
			locatePirate.y = ThreadLocalRandom.current().nextInt(0, 10);
		} while (theOcean.oceanGrid[locatePirate.x][locatePirate.y] != 0);
		pirateImage = new Image("file:///Users/michaelhavighorst/git/activeRepository/src/Homework4/pirateship.gif",50,50,true,true);	
		pirateImageView = new ImageView(pirateImage);
	}
	
	public void setImageView() {
		pirateImageView.setX(locatePirate.x*scalingFactor);
		pirateImageView.setY(locatePirate.y*scalingFactor);
	}
	
	public ImageView getImageView(){
		return pirateImageView;
	}
	
	public void movePirate() {
		if (locatePirate.x - locateShip.x < 0 && theOcean.oceanGrid[locatePirate.x +1][locatePirate.y] == 0 ) {
				locatePirate.x++;
		}else if (locatePirate.x - locateShip.x > 0 && theOcean.oceanGrid[locatePirate.x -1][locatePirate.y] == 0) {
				locatePirate.x--;
		}else if (locatePirate.y - locateShip.y < 0 && theOcean.oceanGrid[locatePirate.x][locatePirate.y+1] == 0) {
				locatePirate.y++;
		}else if (locatePirate.y - locateShip.y > 0 && theOcean.oceanGrid[locatePirate.x][locatePirate.y-1] == 0) {
				locatePirate.y--;
		}
		setImageView();
	}
	
	@Override
	public void update(Observable s, Object arg) {
		if (s instanceof Ship){
			locateShip = ((Ship)s).getShipLocation();
			movePirate();			
		}
		
	}
	
}