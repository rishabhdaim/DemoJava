package builderdp;

public class TestBuilderDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cake cake = new Cake.Builder().build();
		System.out.println(cake.toString());
	}
}
