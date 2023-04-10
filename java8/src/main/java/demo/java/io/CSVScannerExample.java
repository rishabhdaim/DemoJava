/**
 * 
 */
package demo.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.java.xml.Employee;

/**
 * @author rishabh.daim
 * 
 */
public class CSVScannerExample {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("employees.csv"));
		Scanner dataScanner = null;
		int index = 0;
		List<Employee> empList = new ArrayList<Employee>();
		while (scanner.hasNextLine()) {
			dataScanner = new Scanner(scanner.nextLine());
			dataScanner.useDelimiter(",");
			Employee emp = new Employee();
			while (dataScanner.hasNext()) {
				String data = dataScanner.next();
				if (index == 0)
					emp.setId(Integer.parseInt(data));
				else if (index == 1)
					emp.setName(data);
				else if (index == 2)
					emp.setRole(data);
				else if (index == 3)
					emp.setSalary(Double.valueOf(data.split(" ")[0]));
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			empList.add(emp);
		}
		scanner.close();
		System.out.println(empList);
	}
}