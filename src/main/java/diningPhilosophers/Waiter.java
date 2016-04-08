package diningPhilosophers;

/**
 * Philosophers must ask a waiter before picking up the forks
 */
public class Waiter {
	
	
	/**
	 * Attempt to pick up the forks
	 * @param a
	 * @param b
	 * @return true if you successfully pick up the forks otherwise false
	 */
	public boolean tryToEat(Fork a, Fork b){
		if (!a.isInUse() && !b.isInUse()){
			a.setInUse(true);
			b.setInUse(true);
			return true;
		}
		return false;
	}

}
