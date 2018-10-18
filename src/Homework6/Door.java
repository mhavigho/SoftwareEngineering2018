// Michael Havighorst
// Software Engineering
// Homework 6

package Homework6;

import java.awt.Point;
import javafx.scene.image.ImageView;

public interface Door {
	Point getDoorLoca();
	void lockDoor();
	int getDoorId();
	void unlockDoor();
	ImageView getDoorImageView();
}