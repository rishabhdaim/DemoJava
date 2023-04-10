package demo.java.javageeks.dp.builder;

public class TestBuilderDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cake cake = new Cake.Builder().build();
		System.out.println(cake.toString());
		Computer computer = new Computer.ComputerBuilder("2 TB", "16 GB")
				.setBluetoothEnabled(true).setGraphisCard(true).build();
		System.out.println(computer);
		Form form = new Form.FormBuilder("Dave", "Carter", "DavCarter", "DAvCaEr123").passwordHint("MyName").city("NY").language("English").build();
		System.out.println(form);
	}
}
