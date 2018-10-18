// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import java.util.ArrayList;
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

public class ChipGame extends Application {
	
	Pane root;
	Scene scene;
	board board1;
	final int scalingFactor = 20;
	Image chipImage;
	Image chipLeft = new Image("images//chipLeft.png", scalingFactor, scalingFactor, false, true);
	Image chipRight = new Image("images//chipRight.png", scalingFactor, scalingFactor, false, true);
	Image chipUp = new Image("images//chipUp.png", scalingFactor, scalingFactor, false, true);
	Image chipDown = new Image("images//chipDown.png", scalingFactor, scalingFactor, false, true);
	Portal portal = new Portal(board1, 4, 0);
	ImageView chipImageView;
	List<Key> keys;
	List<Door> doors;
	Chip chip;
	FireRetardantShoe fireRetardantShoe;
	Stage mapStage;
	List<Bug> bugs;
	int level = 0;
	ArrayList<Key> keyDelete = new ArrayList<Key>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage chipStage) throws Exception {
		// TODO Auto-generated method stub
		board1 = new board();
		chip = new Chip(board1);
		fireRetardantShoe = new FireRetardantShoe(board1, 15, 6);
		keys = new LinkedList<Key>();
		keys.add(new KeyBlue(board1, 24, 24));
		keys.add(new KeyGreen(board1, 1, 23));
		doors = new LinkedList<Door>();
		doors.add(new DoorBlue(board1, 2, 16));
		doors.add(new DoorGreen(board1, 24, 7));
		root = new AnchorPane();
		board1.Map(root.getChildren(), scalingFactor);
		board1.Walls(root.getChildren(), scalingFactor);
		board1.Obstacles(root.getChildren(), scalingFactor);
		root.getChildren().add(fireRetardantShoe.getImageView());
		bugs = new LinkedList<Bug>();
		bugs.add(new Bug(board1, scalingFactor));
		for(Bug bug: bugs)
			chip.addObserver(bug);
		for(Bug bug: bugs) {
			bug.setImageView();
		}
		loadChipImage();
		loadItems();
		for(Door door: doors)
			door.lockDoor();
		root.getChildren().add(portal.getImageView());
		scene = new Scene(root, 500, 500);
		chipStage.setTitle("Chips Challenge Game");
		chipStage.setScene(scene);
		chipStage.show();
		mapStage = chipStage;
		moveChip();
	}
	
	private void moveChip() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) {
				// TODO Auto-generated method stub
				switch(ke.getCode()) {
					case RIGHT:
						chip.goEast();
						chipImageView.setImage(chipRight);
						chipImage = chipRight;
						chipImageView.setX(chip.getChipLoca().x*scalingFactor);
						chipImageView.setY(chip.getChipLoca().y*scalingFactor);
						break;
					case LEFT:
						chip.goWest();
						chipImageView.setImage(chipLeft);
						chipImage = chipLeft;
						chipImageView.setX(chip.getChipLoca().x*scalingFactor);
						chipImageView.setY(chip.getChipLoca().y*scalingFactor);
						break;
					case UP:
						chip.goNorth();
						chipImageView.setImage(chipUp);
						chipImage = chipUp;
						chipImageView.setX(chip.getChipLoca().x*scalingFactor);
						chipImageView.setY(chip.getChipLoca().y*scalingFactor);
						break;
					case DOWN:
						chip.goSouth();
						chipImageView.setImage(chipDown);
						chipImage = chipDown;
						chipImageView.setX(chip.getChipLoca().x*scalingFactor);
						chipImageView.setY(chip.getChipLoca().y*scalingFactor);
						break;	
					case ESCAPE:
						mapStage.close();
						break;	
					default:
						break;
				}
				if(chip.getChipLoca().x - portal.getLoca().x == 0 && chip.getChipLoca().y - portal.getLoca().y == 0) {
					if(level == 0) {
						nextLevel();
						level++;
					} else {
						mapStage.close();
					}
				}
				
				if(board1.killChip(chip.getChipLoca().x, chip.getChipLoca().y) == 2) 
					resetGame();
				
				if(board1.killChip(chip.getChipLoca().x, chip.getChipLoca().y) == 3)
					nextLevel();
	
				if(chip.getChipLoca().x - fireRetardantShoe.getLoca().x == 0 && chip.getChipLoca().y - fireRetardantShoe.getLoca().y == 0) {
					board1.Floor(root.getChildren(), scalingFactor, fireRetardantShoe.getLoca().x, fireRetardantShoe.getLoca().y);
					resetChipImage();
					if(level == 0)
						board1.FireWalk(root.getChildren());
					else
						board1.FireWalkTwo(root.getChildren());
				}
				
				for(Bug key: bugs) {
					if(chip.getChipLoca().x - key.getBugLoca().x == 0 && chip.getChipLoca().y - key.getBugLoca().y == 0) {
						resetGame();
					}
				}
				
				for(Key key: keys) {
					if(chip.getChipLoca().x - key.getKeyLoca().x == 0 && chip.getChipLoca().y - key.getKeyLoca().y == 0) {
						keyDelete.add(key);
					}
				}
				
				for(Key key: keyDelete) {
					board1.Floor(root.getChildren(), scalingFactor, key.getKeyLoca().x, key.getKeyLoca().y);
					keys.remove(key);
					resetChipImage();
				}
				
				for(Key key: keyDelete) {
					for(Door door: doors) {
						if(key.getDoorId() == door.getDoorId()) {
							door.unlockDoor();
						}
					}
				}
				
				for(Door door: doors) {
					if(chip.getChipLoca().x - door.getDoorLoca().x == 0 && chip.getChipLoca().y - door.getDoorLoca().y == 0) {
						board1.Floor(root.getChildren(), scalingFactor, door.getDoorLoca().x, door.getDoorLoca().y);
						resetChipImage();
					}				
				}
			}
			
		});
	}
	
	private void loadChipImage() {
		Image chipLeft = new Image("images//chipLeft.png", scalingFactor, scalingFactor, false, true);
			chipImageView = new ImageView(chipLeft);
			chipImageView.setX(chip.getChipLoca().x*scalingFactor);
			chipImageView.setY(chip.getChipLoca().y*scalingFactor);
			root.getChildren().add(chipImageView);
	}
	
	private void loadItems() {
		for(Key key: keys) 
			root.getChildren().add(key.getKeyImageView());
		
		for(Door door: doors) 
			root.getChildren().add(door.getDoorImageView());
		
		for (Bug bug: bugs)
			root.getChildren().add(bug.getImageView());
	}
	
	private void resetChipImage() {
		root.getChildren().remove(chipImageView);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getChipLoca().x*scalingFactor);
		chipImageView.setY(chip.getChipLoca().y*scalingFactor);
		root.getChildren().add(chipImageView);
	}
	
	
	private void resetGame() {
		ArrayList<Key> keyDelete2 = new ArrayList<Key>();
		for(Key key: keyDelete) {
			keyDelete2.add(key);
		}
		for(Key key: keyDelete2) {
			keyDelete.remove(key);
		}
		ArrayList<Bug> bugsDelete = new ArrayList<Bug>();
		for(Bug key: bugs) {
			bugsDelete.add(key);
		}
		for(Bug key: bugsDelete) {
			board1.Floor(root.getChildren(), scalingFactor, key.getBugLoca().x, key.getBugLoca().y);
			bugs.remove(key);
		}
		root.getChildren().clear();
		bugs.add(new Bug(board1, scalingFactor));
		for(Bug bug: bugs)
			chip.addObserver(bug);
		for(Bug bug: bugs) 
			bug.setImageView();
		
		board1.Map(root.getChildren(), scalingFactor);
		board1.Walls(root.getChildren(), scalingFactor);
		board1.Obstacles(root.getChildren(), scalingFactor);
		root.getChildren().add(portal.getImageView());
		root.getChildren().add(fireRetardantShoe.getImageView());
		chip.resetChip();
		loadChipImage();
		keys = new LinkedList<Key>();
		keys.add(new KeyBlue(board1, 15, 24));
		keys.add(new KeyGreen(board1, 1, 23));
		
		loadItems();
		
		for(Door door: doors)
			door.lockDoor();
	}
	
	private void nextLevel() {
		
		ArrayList<Bug> bugsDelete = new ArrayList<Bug>();
		for(Bug key: bugs) {
			bugsDelete.add(key);
		}
		for(Bug bug: bugsDelete) {
			board1.Floor(root.getChildren(), scalingFactor, bug.getBugLoca().x, bug.getBugLoca().y);
			bugs.remove(bug);
		}
		ArrayList<Key> keyDelete2 = new ArrayList<Key>();
		for(Key key: keyDelete) {
			keyDelete2.add(key);
		}
		for(Key key: keyDelete2) {
			keyDelete.remove(key);
		}
		ArrayList<Door> doorDelete = new ArrayList<Door>();
		for(Door door: doors) {
			doorDelete.add(door);
		}
		for(Door door: doorDelete) {
			doors.remove(door);
		}
		
		root.getChildren().clear();
		board1.Map(root.getChildren(), scalingFactor);
		chip.resetChipTwo();
		loadChipImage();
		board1.WallsTwo(root.getChildren(), scalingFactor);
		board1.ObstaclesTwo(root.getChildren(), scalingFactor);
		portal.setLocation2();
		Portal portal = new Portal(board1, 0, 0);
		root.getChildren().add(portal.getImageView());
		fireRetardantShoe = new FireRetardantShoe(board1, 23, 22);
		root.getChildren().add(fireRetardantShoe.getImageView());		

		keys = new LinkedList<Key>();
		keys.add(new KeyBlue(board1, 4, 0));
		keys.add(new KeyGreen(board1, 4, 6));
		keys.add(new KeyRed(board1, 24, 15));
		keys.add(new KeyYellow(board1, 0, 14));
		
		doors.add(new DoorBlue(board1, 24, 22));
		doors.add(new DoorGreen(board1, 5, 21));
		doors.add(new DoorYellow(board1, 23, 15));
		doors.add(new DoorRed(board1, 0, 1));
		loadItems();
	}
}
	