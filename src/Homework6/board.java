// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class board {
	
	int[][] chipsGrid = new int[25][25];
	final int dimensions = 25;
	ImageView tileImageView;
	ImageView wallImageView;
	ImageView waterImageView;
	ImageView fireImageView;
	int vWall, vWall1, vWall2, vWall3, vWall4, vWall5, vWall6, vWall7, vWall8, vWall9, vWall10, vWall11, vWall12;
	int hWall, hWall1, hWall2, hWall3, hWall4, hWall5, hWall6, hWall7, hWall8, hWall9, hWall10, hWall11, hWall12;
	DoorBlue blueDoor;
	
	public void Map(ObservableList<Node> root, int scale) {
		Image tile = new Image("images//BlankTile.png", scale, scale, false, true);
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				tileImageView = new ImageView(tile);
				tileImageView.setX(x*scale);
				tileImageView.setY(y*scale);
				root.add(tileImageView);
				chipsGrid[x][y] = 0;
			}
		}
	}
	
	public void Floor(ObservableList<Node> root, int scale, int x, int y) {
		Image tile = new Image("images//BlankTile.png", scale, scale, false, true);
		tileImageView = new ImageView(tile);
		tileImageView.setX(x*scale);
		tileImageView.setY(y*scale);
		root.add(tileImageView);
		chipsGrid[x][y] = 0;
	}
	
	public void Obstacles(ObservableList<Node> root, int scale) {
		
		for(int y = 7; y < 15; y++) {
			for(int x = 0; x < dimensions - 1; x++) {
				Image water = new Image("images//ChipWater.png", scale, scale, false, true);
				waterImageView = new ImageView(water);
				waterImageView.setX(x*scale);
				waterImageView.setY(y*scale);
				root.add(waterImageView);
				chipsGrid[x][y] = 1;
			}
		}
		for(int y = 22; y < dimensions; y++) {
			for(int x = 3; x < 14; x++) {
				Image water = new Image("images//ChipWater.png", scale, scale, false, true);
				waterImageView = new ImageView(water);
				waterImageView.setX(x*scale);
				waterImageView.setY(y*scale);
				root.add(waterImageView);
				chipsGrid[x][y] = 1;
			}
		}
		
		for(int y = 1; y < 7; y++) {
			for(int x = 3; x < 12; x++) {
				Image fire = new Image("images//ChipFire.png", scale, scale, false, true);
				fireImageView = new ImageView(fire);
				fireImageView.setX(x*scale);
				fireImageView.setY(y*scale);
				root.add(fireImageView);
				chipsGrid[x][y] = 2;
			}
		}
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 5; y++) {
				Image fire = new Image("images//ChipFire.png", scale, scale, false, true);
				fireImageView = new ImageView(fire);
				fireImageView.setX(x*scale);
				fireImageView.setY(y*scale);
				root.add(fireImageView);
				chipsGrid[x][y] = 2;
			}
		}
	}
	
	public void ObstaclesTwo(ObservableList<Node> root, int scale) {
		
		for(int y = 0; y < 13; y++) {
			for(int x = 22; x < dimensions; x++) {
				Image water = new Image("images//ChipWater.png", scale, scale, false, true);
				waterImageView = new ImageView(water);
				waterImageView.setX(x*scale);
				waterImageView.setY(y*scale);
				root.add(waterImageView);
				chipsGrid[x][y] = 1;
			}
		}
		
		for(int y = 18; y < 21; y++) {
			for(int x = 8; x < dimensions-1; x++) {
				Image water = new Image("images//ChipWater.png", scale, scale, false, true);
				waterImageView = new ImageView(water);
				waterImageView.setX(x*scale);
				waterImageView.setY(y*scale);
				root.add(waterImageView);
				chipsGrid[x][y] = 1;
			}
		}

		for(int y = 2; y < 25; y++) {
			for(int x = 0; x < 1; x++) {
				Image fire = new Image("images//ChipFire.png", scale, scale, false, true);
				fireImageView = new ImageView(fire);
				fireImageView.setX(x*scale);
				fireImageView.setY(y*scale);
				root.add(fireImageView);
				chipsGrid[x][y] = 3;
			}
		}
		
		for(int x = 1; x < 24; x++) {
			for(int y = 24; y < 25; y++) {
				Image fire = new Image("images//ChipFire.png", scale, scale, false, true);
				fireImageView = new ImageView(fire);
				fireImageView.setX(x*scale);
				fireImageView.setY(y*scale);
				root.add(fireImageView);
				chipsGrid[x][y] = 3;
			}
		}
	}
	
	public int killChip(int x, int y) {
		return chipsGrid[x][y];
	}
	
	public void FireWalk(ObservableList<Node> root) {
		for(int y = 1; y < 7; y++) {
			for(int x = 3; x < 12; x++) {
				chipsGrid[x][y] = 0;
			}
		}
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 5; y++) {
					chipsGrid[x][y] = 0;
			}
		}
	}
	
	public void FireWalkTwo(ObservableList<Node> root) {
		for(int y = 2; y < 25; y++) {
			for(int x = 0; x < 1; x++) {
				chipsGrid[x][y] = 0;
			}
		}
		
		for(int x = 1; x < 24; x++) {
			for(int y = 24; y < 25; y++) {
				chipsGrid[x][y] = 0;
			}
		}
	}
	
	public void Walls(ObservableList<Node> root, int scale) {
		
		vWall = 2;
		vWall1 = 14;
		vWall2 = 16;
		vWall3 = 6;
		vWall4 = 23;
		for(int y = 0; y < dimensions; y++) {
			if((y > 11 && y < 16) || y > 16) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall][y] = 1;
			}
			if(y > 19) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall1*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall1][y] = 1;
			}
			if(y < 19 && y > 16) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall4*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall4][y] = 1;
			}
			if(y > 3 && y < 9) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall2*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall2][y] = 1;
			}
			if(y >= 0 && y < 5) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall3*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall3][y] = 1;
			}
		}

		hWall = 2;
		hWall1 = 4;
		hWall2 = 17;
		hWall3 = 16;
		for(int x = 0; x < dimensions; x++) {
			if(x > 13 && x != 24) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall] = 1;
			}
			if(x > 3 && x < 23) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall2*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall2] = 1;
			}
			if(x == 4) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall3*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall3] = 1;
			}
			if((x > 12 && x < 24) || (x > 6 && x < 12)) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall1*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall1] = 1;
			}
		}
	}
	
	public void WallsTwo(ObservableList<Node> root, int scale) {
		
		vWall5 = 1;
		vWall6 = 5;
		vWall7 = 4;
		vWall8 = 6;
		vWall9 = 14;
		vWall10 = 12;
		vWall11 = 2;
		vWall12 = 3;
		for(int y = 0; y < dimensions; y++) {
			if(y < 24) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall5*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall5][y] = 1;
			}
			if(y < 24) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall11*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall11][y] = 1;
			}
			if(y < 24) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall12*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall12][y] = 1;
			}
			if(y > 1 && y < 8) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall6*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall6][y] = 1;
			}
			if(y > 11 && y < 22) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall7*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall7][y] = 1;
			}
			if(y > 13 && y < 22) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall8*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall8][y] = 1;
			}
			if(y > 3 && y < 14) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall9*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall9][y] = 1;
			}
			if(y > 3 && y < 12) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(vWall10*scale);
				wallImageView.setY(y*scale);
				root.add(wallImageView);
				chipsGrid[vWall10][y] = 1;
			}
		}
		
		hWall4 = 2;
		hWall5 = 7;
		hWall6 = 11;
		hWall7 = 13;
		hWall8 = 23;
		hWall9 = 21;
		hWall10 = 14;
		hWall11 = 16;
		hWall12 = 0;
		for(int x = 0; x < dimensions; x++) {
			if(x > 4 && x < 21) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall12*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall12] = 1;
			}
			if(x > 4 && x < 21) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall4*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall4] = 1;
			}
			if(x > 1 && x < 5) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall5*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall5] = 1;
			}
			if(x > 3 && x < 12) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall6*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall6] = 1;
			}
			if(x > 5 && x < 14) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall7*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall7] = 1;
			}
			if(x > 1 && x < 24) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall8*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall8] = 1;
			}
			if(x > 6 && x < 24) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall9*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall9] = 1;
			}
			if(x > 22) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall10*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall10] = 1;
			}
			if(x > 22) {
				Image wall = new Image("images//WallTile.png", scale, scale, false, true);
				wallImageView = new ImageView(wall);
				wallImageView.setX(x*scale);
				wallImageView.setY(hWall11*scale);
				root.add(wallImageView);
				chipsGrid[x][hWall11] = 1;
			}
		}
	}
}