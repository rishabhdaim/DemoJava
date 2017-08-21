/**
 * 
 */
package javageeks.dp.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aa49442
 * 
 */
public class Employees implements Cloneable {
	private List<String> empList;

	/**
	 * @return the empList
	 */
	public List<String> getEmpList() {
		return empList;
	}

	public Employees() {
		empList = new ArrayList<String>();
	}

	public Employees(List<String> list) {
		this.empList = list;
	}

	public void loadData() {
		// read all employees from database and put into the list
		empList.add("Pankaj");
		empList.add("Raj");
		empList.add("David");
		empList.add("anku");
		empList.add("rishu");
	}

	@Override
	protected Employees clone() throws CloneNotSupportedException {
		final List<String> temp = new ArrayList<String>();
		for (String string : this.getEmpList())
			temp.add(string);
		return new Employees(temp);
	}
}