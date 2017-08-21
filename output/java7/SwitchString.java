package java7;

public class SwitchString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		switch (args[0]) {
		case "trade":
			System.out.println("trade");
			break;

		default:
			System.out.println("not mentioned");
			break;
		}
	}

}
