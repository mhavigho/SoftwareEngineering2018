package Homework4;
// Michael Havighorst
// Software Engineering
// Homework 4

import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	
	OceanMap theOcean;
	Scene scene;
	Image shitIpmage;
	ImageView shipImageView;
	Ship ship;
	Image pirateImage;
	ImageView pirateImageView;
	List<Pirate> pirates;
	final int dimensions = 10;
	final int numIslands = 10;
	final int scalingFactor = 50;
	boolean[][] mapOfIsland;
	Pane root;
	
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		// TODO Auto-generated method stub
		theOcean = new OceanMap();
		root = new AnchorPane();
		theOcean.drawMap(root.getChildren(), scalingFactor);
		theOcean.placeIslands(root.getChildren(), scalingFactor);
		ship = new Ship(theOcean);
		pirates = new LinkedList<Pirate>();
		int numPirates = 2;
		for (int i = 0; i < numPirates; i++) {
			pirates.add(new Pirate(theOcean));
		}
		for (Pirate pirate: pirates) {
			ship.addObserver(pirate);
		}
		loadShipImage();
		for(Pirate pirate: pirates) {
			pirate.setImageView();
		}
		scene = new Scene(root, 500, 500);
		oceanStage.setTitle("Chris Columbus Game");
		oceanStage.setScene(scene);
		oceanStage.show();
		Sail();
	}
	
	private void Sail() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent kevent) {
				switch(kevent.getCode()) {
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				}
				shipImageView.setX(ship.getShipLocation().x*scalingFactor);
				shipImageView.setY(ship.getShipLocation().y*scalingFactor);
			}
		});
	}
	
	private void loadShipImage() {
		Image shipImage = new Image("images//ColumbusShip.png", scalingFactor, scalingFactor, false, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x*scalingFactor);
		shipImageView.setY(ship.getShipLocation().y*scalingFactor);
		root.getChildren().add(shipImageView);
		for (Pirate pirate: pirates)
			root.getChildren().add(pirate.getImageView());
	}
	
}
