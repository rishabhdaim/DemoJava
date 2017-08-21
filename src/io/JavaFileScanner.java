/**
 * 
 *//*
package io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import xml.Employee;

*//**
 * @author aa49442
 * 
 *//*
public class JavaFileScanner {

	*//**
	 * @param args
	 * @throws IOException
	 *//*
	public static void main(String[] args) throws IOException {
		String fileName = "source.txt";
		Path path = Paths.get(fileName);
		Scanner scanner = new Scanner(path);
		// read file line by line
		String delim = System.getProperty("line.separator");
		System.out.println(delim);
		scanner.useDelimiter(delim);
		while (scanner.hasNext())
			System.out.println("Lines: " + scanner.next());
		scanner.close();
		// read CSV Files and parse it to object array
		scanner = new Scanner(Paths.get("data.csv"));
		scanner.useDelimiter(delim);
		while (scanner.hasNext()) {
			// parse line to get Emp Object
			Employee emp = parseCSVLine(scanner.next());
			System.out.println(emp.toString());
		}
		scanner.close();
		// read from system input
		// System.out.println("Read from system input:");
		// scanner = new Scanner(System.in);
		// System.out.println("Input first word: " + scanner.next());
	}

	private static Employee parseCSVLine(String line) {
		Scanner scanner = new Scanner(line);
		// \\s* is added to remove spaces around , before splitting the line..
		scanner.useDelimiter("\\s*,\\s*");
		String name = scanner.next();
		int age = scanner.nextInt();
		String gender = scanner.next();
		return new Employee(name, gender, age);
	}

}
*/