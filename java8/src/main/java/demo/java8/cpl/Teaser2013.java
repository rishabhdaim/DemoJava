package demo.java8.cpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class Teaser2013 {

	// public static void findOddOneOut(String[] catArr,String category,String
	// input){

	private static PrintWriter printWriter = null;
	private static final Logger LOGGER = Logger.getLogger(Teaser2013.class
			.getName());
	private static String[] inputArr = null;
	private static String[] validValues = null;
	private static final String[] typeArr = { "Animals", "Mammals", "Fruits",
			"Flowers", "Vegetables", "Cities", "Beverages", "Mountains",
			"Trees", "Mobiles", "Companies", "Colors", "Vehicles",
			"TwoWheelers", "FourWheelers", "E-Gadgets", "ComputerAccessories",
			"Designations", "Rivers", "Actors", "Carnivorours", "Omnivorours",
			"Herbivorours", "Movies", "Singers", "Players", "NameOfMonths",
			"DaysOfWeeks" };

	private static final Properties PROPERTIES = new Properties();

	public static void main(String[] args) {

		// fillTypeList();
		String result = null;
		// String parentPath = new File("").getAbsolutePath();
		String filename = "./bin/cpl/DAVINCERS_in.txt";
		Scanner in = null;
		File file = new File(filename);
		try {
			in = new Scanner(file);
			printWriter = new PrintWriter("./bin/cpl/DAVINCERS_out.txt");
			int count = 0;
			while (in.hasNextLine()) {
				count++;
				String inputLine = in.nextLine();
				if (inputLine.equals("0"))
					break;
				inputArr = inputLine.split(" ");

				inner: for (String inputField : inputArr) {
					for (String type : typeArr) {
						result = checkValueInDataBase(inputField, type);
						if (result == null)
							continue;
						printWriter.println("Case " + count + " : " + result);
						break inner;
					}
				}
			}

			printWriter.flush();
			printWriter.close();

		} catch (FileNotFoundException e) {
			LOGGER.severe("file not found..");
			e.printStackTrace();
		}

	}

	private static String checkValueInDataBase(String inputField, String type) {
		try {
			PROPERTIES.load(Teaser2013.class.getClassLoader()
					.getResourceAsStream("DAVINCERS_in.properties"));
		} catch (IOException e) {
			LOGGER.severe("property file missing..");
			e.printStackTrace();
		}

		validValues = PROPERTIES.getProperty(type).split(",");
		String oddValue = null;
		for (String value : validValues) {
			if (inputField.equalsIgnoreCase(value))
				oddValue = findOddOneOut(validValues, inputArr);
		}

		if (oddValue != null)
			return oddValue;
		return null;

	}

	/*
	 * private static void fillTypeList() { for (int i = 0; i < typeArr.length;
	 * i++) { } }
	 */

	private static String findOddOneOut(String[] catArr, String[] inputArr) {
		List<CategoryKeyValue> flagList = new ArrayList<CategoryKeyValue>();
		List<String> list = new ArrayList<String>();

		for (String str : catArr)
			list.add(str.trim());

		for (String str : inputArr) {
			String trimStr = str.trim();
			CategoryKeyValue keyValue = new CategoryKeyValue();
			if (list.contains(trimStr)) {
				keyValue.setInput(trimStr);
				keyValue.setPresentInCategory(true);
			} else {
				keyValue.setInput(trimStr);
				keyValue.setPresentInCategory(false);
			}
			flagList.add(keyValue);
		}

		CategoryKeyValue returnValue = new CategoryKeyValue();

		for (CategoryKeyValue cat : flagList) {
			if (!cat.presentInCategory)
				returnValue = cat;
		}

		return returnValue.getInput();

	}

	private static class CategoryKeyValue {
		private String input;
		private boolean presentInCategory;

		public String getInput() {
			return input;
		}

		@SuppressWarnings("unused")
		public boolean isPresentInCategory() {
			return presentInCategory;
		}

		public void setInput(String input) {
			this.input = input;
		}

		public void setPresentInCategory(boolean presentInCategory) {
			this.presentInCategory = presentInCategory;
		}
	}

}
