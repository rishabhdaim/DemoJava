/**
 * 
 */
package demo.java.javageeks.dp.prototype;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author Rishabh.Daim
 *
 */
public final class AccessControlProvider {
	
	private static Map<AccessLevel, AccessControl> accessControlMap = Maps.newConcurrentMap();
	
	static {
		System.out.println("Fetching data from external resources and creating access control objects");
		accessControlMap.put(AccessLevel.USER, new AccessControl(AccessLevel.USER,"DO_WORK"));
		accessControlMap.put(AccessLevel.ADMIN, new AccessControl(AccessLevel.ADMIN,"ADD/REMOVE USERS"));
		accessControlMap.put(AccessLevel.MANAGER, new AccessControl(AccessLevel.MANAGER,"GENERATE/READ REPORTS"));
		accessControlMap.put(AccessLevel.VP, new AccessControl(AccessLevel.VP,"MODIFY REPORTS"));
	}
	
	public static AccessControl getAccessControlObject(final AccessLevel accessLevel) {
		AccessControl accessControl = accessControlMap.get(accessLevel);
		if (accessControl != null) {
			accessControl = accessControl.clone();
		}
		return accessControl;
	}
}
