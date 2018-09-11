package Racing;
import HorsesHomework.*;

public class TheRace {
	public HorseRace[] arr = new HorseRace[5];
	public int racersNumber = 0;
	
	public void enrollHorse(String n, double s, String t) {
		if(t == "steady") {
			arr[racersNumber] = new SteadyRun(n, s);
		}
		else if (t == "slow") {
			arr[racersNumber] = new SlowRun(n, s);
		}
		else {
			arr[racersNumber] = new EarlySprintRun(n, s);
		}
		
		racersNumber++;
	}
	
	public TheRace(){
	}
	
	public void startRace() throws InterruptedException{
		while (!arr[0].completedRace && !arr[1].completedRace && !arr[2].completedRace && !arr[3].completedRace && !arr[4].completedRace) {
			for (int i = 0; i < 5; i++) {
				arr[i].run();
			}
			for (int i = 0; i < 5; i++) {
				arr[i].display();
			}
			if (arr[0].completedRace) {
				System.out.println(arr[0].name + " HAS WON!");
			}
			else if(arr[1].completedRace) {
				System.out.println(arr[1].name + " HAS WON!");
			}
			else if(arr[2].completedRace) {
				System.out.println(arr[2].name + " HAS WON!");
			}
			else if(arr[3].completedRace) {
				System.out.println(arr[3].name + " HAS WON!");
			}
			else if(arr[4].completedRace) {
				System.out.println(arr[4].name + " HAS WON!");
			}
			Thread.sleep(500);
		}
	}

}
