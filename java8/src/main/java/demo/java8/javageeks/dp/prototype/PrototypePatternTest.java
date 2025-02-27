/**
 * 
 */
package demo.java8.javageeks.dp.prototype;

import java.util.List;

/**
 * @author rishabh.daim
 * 
 */
public class PrototypePatternTest {

	/**
	 * @param args
	 * @throws CloneNotSupportedException
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		Employees emps = new Employees();
		emps.loadData();
		// Use the clone method to get the Employee object
		Employees empsNew = emps.clone();
		Employees empsNew1 = emps.clone();
		List<String> list = empsNew.getEmpList();
		list.add("John");
		List<String> list1 = empsNew1.getEmpList();
		list1.remove("Pankaj");
		System.out.println("emps List: " + emps.getEmpList());
		System.out.println("empsNew List: " + list);
		System.out.println("empsNew1 List: " + list1);
	}
}