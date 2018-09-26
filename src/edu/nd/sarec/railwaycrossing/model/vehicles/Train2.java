// Michael Havighorst
// Software Engineering
// Homework 5

package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Train2 extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	
	public Train2(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		img = new Image("images\\Train2.png",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public boolean offScreen(){
		if (currentX > 1800)
			return true;
		else
			return false;				
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
	
	@Override
	public void move() {
		currentX+=4;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
}
