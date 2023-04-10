/**
 * 
 */
package demo.java.javageeks.dp.prototype;

/**
 * @author Rishabh.Daim
 *
 */
public class TestPrototypePattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AccessControl userAccessControl = AccessControlProvider.getAccessControlObject(AccessLevel.USER);
		User user = new User("User A", AccessLevel.USER, userAccessControl);
		System.out.println("************************************");
		System.out.println(user);
		
		userAccessControl = AccessControlProvider.getAccessControlObject(AccessLevel.USER);
		user = new User("User B", AccessLevel.USER, userAccessControl);
		System.out.println("Changing access control of: "+user.getUserName());
		user.getAccessControl().setAccess("READ REPORTS");
		System.out.println(user);
		System.out.println("************************************");
		
		AccessControl managerAccessControl = AccessControlProvider.getAccessControlObject(AccessLevel.MANAGER);
		user = new User("User C", AccessLevel.MANAGER, managerAccessControl);
		System.out.println(user);
	}

}
