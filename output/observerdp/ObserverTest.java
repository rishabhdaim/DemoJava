package observerdp;

public class ObserverTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Observer newPaper = new Newspaper();
		Observer internet = new Internet();

		Loan loan = new Loan("home", 12.25f, "HSBC");
		loan.registerObserver(newPaper);
		loan.registerObserver(internet);
		loan.setInterest(13.75f);
	}

}
