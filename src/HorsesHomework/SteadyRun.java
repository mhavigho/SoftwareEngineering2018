package HorsesHomework;

// Michael Havighorst
// Software Engineering
// Homework 3

public class SteadyRun extends HorseRace{

	public double speed;

	public SteadyRun(String n, double s) {
		name = n;
		speed = s*.8;
	}

	
	@Override
	public void run() {
		if (distance < 10) {
			distance = distance + speed*incrementTime;
		}
		else {
			completedRace = true;
		}
	}
	
	public void display() {
		if (!completedRace) {
			System.out.println(name+" has ran "+distance+" miles.");
		}
		else {
			System.out.println(name+" has finished.");
		}
	}
}