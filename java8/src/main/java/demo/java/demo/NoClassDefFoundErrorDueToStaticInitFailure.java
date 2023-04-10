package demo.java.demo;

import java.util.ArrayList;
import java.util.List;

public class NoClassDefFoundErrorDueToStaticInitFailure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>(2);

		for (int i = 0; i < 2; i++) {
			try {
				users.add(new User(String.valueOf(i))); // will throw
														// NoClassDefFoundError
			} catch (Throwable t) {
				System.err.println(t.getCause());
				t.printStackTrace();
			}
		}

	}

	private static class User {
		private static String USER_ID = getUserId();

		public User(String id) {
			User.USER_ID = id;
		}

		private static String getUserId() {
			throw new RuntimeException("UserId Not found : " + USER_ID);
		}

	}
}
