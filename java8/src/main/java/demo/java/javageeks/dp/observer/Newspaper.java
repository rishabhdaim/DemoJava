package demo.java.javageeks.dp.observer;

public class Newspaper implements Observer {

	@Override
	public void update(float interest) {
		System.out.println("Newspaper: Interest Rate updated, new Rate is: "
				+ interest);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Newspaper";
	}

	@Override
	public void added(Subject subject, int i) {
		// TODO Auto-generated method stub
		
	}
}
