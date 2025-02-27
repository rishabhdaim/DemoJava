package demo.java8.javageeks.dp.observer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObserverTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Observer newPaper = new Newspaper();
		Observer internet = new Internet();
		Observer tv = new Television();

		Loan loan = new Loan("home", 12.25f, "HSBC");
		loan.registerObserver(newPaper);
		loan.registerObserver(internet);
		loan.registerObserver(tv);
		loan.setInterest(13.75f);

		ObservableSet observableSet = new ObservableSet();

		observableSet.registerObserver(new Observer() {

			@Override
			public void update(float interest) {
				// TODO Auto-generated method stub

			}

			@Override
			public void added(final Subject subject, int i) {
				System.out.println(i);
				if (i == 23) {
					// subject.removeObserver(this);
					ExecutorService executorService = Executors
							.newSingleThreadExecutor();
					final Observer observer = this;

					try {
						executorService.submit(new Runnable() {

							@Override
							public void run() {
								subject.removeObserver(observer);
							}
						}).get();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						executorService.shutdown();
					}
				}
			}
		});

		for (int i = 0; i < 100; i++)
			observableSet.add(i);
	}
}