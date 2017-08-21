package demo;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class TestWeakReference {
	public static void main(String[] args) {
		Map<Employee, EmployeeVal> map = new HashMap<Employee, EmployeeVal>();
		Reference<Map<Employee, EmployeeVal>> aMap = new WeakReference<Map<Employee, EmployeeVal>>(
				map);

		// map = null;
		int count = 0;
		while (null != aMap.get()) {
			aMap.get().put(new Employee("Vinoth"),
					new EmployeeVal("Programmer"));
			System.out.println("Size of aMap " + aMap.get().size());
			System.gc();
			++count;
			if (count > 500)
				break;
		}
		System.out.println("Its garbage collected and took : " + count);
		System.err.println(map);
	}
}
