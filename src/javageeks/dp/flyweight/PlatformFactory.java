/**
 * 
 */
package javageeks.dp.flyweight;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author Rishabh.Daim
 *
 */
public class PlatformFactory {

	private static final Map<PlatformType, Platform> platformMap = Maps
			.newConcurrentMap();

	private PlatformFactory() {
		throw new AssertionError("Can't instantiate the class");
	}

	public static Platform getPlatformInstance(final PlatformType platformType) {
		Platform platform = platformMap.get(platformType);
		if (platform == null) {
			switch (platformType) {
			case JAVA:
				platform = new JavaPlatform();
				break;
			case C:
				platform = new CPlatform();
				break;
			case CPP:
				platform = new CppPlatform();
				break;
			case RUBY:
				platform = new RubyPlatform();
				break;
			default:
				platform = null;
				break;
			}
			platformMap.putIfAbsent(platformType, platform);
		}
		return platform;
	}
}
