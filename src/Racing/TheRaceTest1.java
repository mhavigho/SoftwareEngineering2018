// Michael Havighorst
// Software Engineering
// Homework 3

package Racing;
import org.junit.Test;
public class TheRaceTest1 {
	@Test
	public void test() throws InterruptedException {
		TheRace race1 = new TheRace();
		race1.enrollHorse("Michael", 40, "steady");
		race1.enrollHorse("Shane", 48, "slow");
		race1.enrollHorse("Connor", 49, "early");
		race1.enrollHorse("Tim", 44, "steady");
		race1.enrollHorse("Al", 44, "slow");
	}	
}