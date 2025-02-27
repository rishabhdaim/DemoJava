package demo.java8.javageeks.dp.observer;

public class Internet implements Observer {

	@Override
	public void update(float interest) {
		System.out.println("Internet: Interest Rate updated, new Rate is: "
		+ interest);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Internet";
	}
	@Override
	public void added(Subject subject, int i) {
		// TODO Auto-generated method stub
		
	}
}