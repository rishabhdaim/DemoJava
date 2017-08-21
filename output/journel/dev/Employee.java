package journel.dev;

import java.io.Serializable;
import java.util.Comparator;

public class Employee implements Comparable<Employee>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
	private long salary;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the salary
	 */
	public long getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(long salary) {
		this.salary = salary;
	}

	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(int id, String name, int age, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}

	/**
	 * Comparator to sort employees list or array in order of Salary
	 */
	public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return (int) (e1.getSalary() - e2.getSalary());
		}
	};
	/**
	 * Comparator to sort employees list or array in order of Age
	 */
	public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getAge() - e2.getAge();
		}
	};
	/**
	 * Comparator to sort employees list or array in order of Name
	 */
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	};
}
