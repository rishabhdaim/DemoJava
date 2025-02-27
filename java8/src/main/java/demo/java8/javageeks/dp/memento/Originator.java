/**
 * 
 */
package demo.java8.javageeks.dp.memento;

/**
 * @author Rishabh.Daim
 *
 */
public final class Originator {

	private double x;
	private double y;

	private String lastUndoSavePoint;
	private final CareTaker careTaker;

	/**
	 * @param x
	 * @param y
	 * @param careTaker
	 */
	public Originator(double x, double y, CareTaker careTaker) {
		this.x = x;
		this.y = y;
		this.careTaker = careTaker;
		
		createSavePoint("INITIAL");
	}

	/**
	 * @return the x
	 */
	public final double getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public final void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public final double getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public final void setY(double y) {
		this.y = y;
	}

	// memento operations

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Originator [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}

	public void createSavePoint(final String savePointName) {
		System.out.println("Creating save point with name : " + savePointName);
		careTaker.saveMemento(new Memento(getX(), getY()), savePointName);
		lastUndoSavePoint = savePointName;
	}

	public void undoAll() {
		System.out.println("Clearing all saved states");
		setOriginator("INITIAL");
		careTaker.clearSavePoints();
	}

	public void undo(final String savePointName) {
		System.out.println("Revertng to save point : " + savePointName);
		setOriginator(savePointName);
	}

	public void undo() {
		System.out.println("Revertng to save point : " + lastUndoSavePoint);
		setOriginator(lastUndoSavePoint);
	}

	// internal helpers
	private void setOriginator(final String savePointName) {
		final Memento memento = careTaker.getMemento(savePointName);
		this.x = memento.getX();
		this.y = memento.getY();
	}
}
