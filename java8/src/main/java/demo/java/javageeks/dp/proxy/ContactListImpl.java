/**
 * 
 */
package demo.java.javageeks.dp.proxy;

import java.util.List;

/**
 * @author Rishabh.Daim
 *
 */
public class ContactListImpl implements ContactList {

	private ContactList contactList;

	@Override
	public List<Employee> getEmployeeList() {
		if (contactList == null) {
			System.out
					.println("Creating contact list and fetching list of employees...");
			contactList = new ContactListImpl();
		}
		return contactList.getEmployeeList();
	}
}
