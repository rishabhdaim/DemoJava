/**
 * 
 */
package demo.java8.javageeks.dp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rishabh.daim
 * 
 */
public class Loan implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();

	private String type;

	private float interest;

	private String bank;

	public Loan(String type, float interest, String bank) {

		this.type = type;

		this.interest = interest;

		this.bank = bank;

	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the interest
	 */
	public float getInterest() {
		return interest;
	}

	/**
	 * @param interest
	 *            the interest to set
	 */
	public void setInterest(float interest) {
		this.interest = interest;
		notifyObservers();
	}

	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * @param bank
	 *            the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see demo.Subject#registerObserver(demo.Observer)
	 */
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see demo.Subject#removeObserver(demo.Observer)
	 */
	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see demo.Subject#notifyObservers()
	 */
	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			System.out.println("Notifying..." + observer);
			observer.update(this.interest);
		}
	}
}