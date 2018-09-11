// Michael Havighorst
// Software Engineering
// Homework 3

package Racing;
import org.junit.Test;
import HorsesHomework.*;
public class TheRaceTest2 {
	@Test
	public void test() throws InterruptedException {
		HorseRace test1 = new SteadyRun(null, 0);
		test1.run();
		HorseRace test2 = new SlowRun(null, 0);
		test2.run();
		HorseRace test3 = new EarlySprintRun(null, 0);
		test3.run();
	}	
}
