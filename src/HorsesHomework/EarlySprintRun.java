package HorsesHomework;

// Michael Havighorst
// Software Engineering
// Homework 3

public class EarlySprintRun extends HorseRace {

	public double speed;
	public double slowSpeed;

	public EarlySprintRun(String n, double s) {
		name = n;
		speed = s;
		slowSpeed = s*.75;
	}
	
	@Override
	public void run() {
		if (distance < 10) {
			if (distance >= 2) {
				speed = slowSpeed;
			}
			
			distance = distance + speed*incrementTime;
		}
		else {
			completedRace = true;
		}
	}
	
	public void display() {
		if (!completedRace) {
			System.out.println(name +" has ran "+distance+" miles.");
		}
		else {
			System.out.println(name+" has finished.");
		}
	}
}