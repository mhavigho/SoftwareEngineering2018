package HorsesHomework;

// Michael Havighorst
// Software Engineering
// Homework 3

public class SlowRun extends HorseRace {

	public double speed;
	public double normalSpeed;
	public double slowSpeed;
	public double slowSpeed2;

	public SlowRun(String n, double s) {
		name = n;
		normalSpeed = s;
		slowSpeed = s*.90;
		slowSpeed2 = s*.75;
	}
	
	@Override
	public void run() {
		if (distance < 10) {
			if (distance <= 6) {
				speed = slowSpeed2;
			}
			else if (distance > 6 && distance < 9) {
				speed = slowSpeed;
			}
			else {
				speed = normalSpeed;
			}
			distance = distance + speed*incrementTime;
		}
		else {
			completedRace = true;
		}
	}
	
	public void display() {
		if (!completedRace) {
			System.out.println(name + " has ran " + distance + " miles.");
		}
		else {
			System.out.println(name + " has finished.");
		}
	}
}