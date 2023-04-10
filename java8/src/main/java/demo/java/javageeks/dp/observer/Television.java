/**
 * 
 */
package demo.java.javageeks.dp.observer;

/**
 * @author rishabh.daim
 * 
 */
public class Television implements Observer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see observerdp.Observer#update(float)
	 */
	@Override
	public void update(float interest) {
		System.out.println("TV: Interest Rate updated, new Rate is: " + interest);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Television";
	}

	@Override
	public void added(Subject subject, int i) {
		// TODO Auto-generated method stub
		
	}
}