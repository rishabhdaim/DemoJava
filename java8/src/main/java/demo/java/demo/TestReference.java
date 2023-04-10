package demo.java.demo;

import java.util.Map;
import java.util.WeakHashMap;

public class TestReference {
	public static void main(String[] args) {
		Map<Employee, EmployeeVal> employees = new WeakHashMap<Employee, EmployeeVal>();

		Employee emp = new Employee("Vinoth");
		EmployeeVal val = new EmployeeVal("Programmer");

		employees.put(emp, val);

		emp = null;
		//System.gc();
		//System.gc();
		System.out.println("Size of Map " + employees.size());
		int count = 0;
		while (0 != employees.size()) {
			++count;
			System.gc();
			if (count == Integer.MAX_VALUE)
				break;
		}
		System.out.println("Took " + count
				+ " calls to System.gc() to result in weakHashMap size of : "
				+ employees.size());

	}
}
