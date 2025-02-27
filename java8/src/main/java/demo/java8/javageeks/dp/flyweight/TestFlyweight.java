/**
 * 
 */
package demo.java8.javageeks.dp.flyweight;

/**
 * @author Rishabh.Daim
 *
 */
public class TestFlyweight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Code code = new Code();
		code.setCode("C code");
		Platform platform = PlatformFactory.getPlatformInstance(PlatformType.C);
		platform.execute(code);
		System.out.println("*************************");
		code = new Code();
		code.setCode("C Code2...");
		platform = PlatformFactory.getPlatformInstance(PlatformType.C);
		platform.execute(code);
		System.out.println("*************************");
		code = new Code();
		code.setCode("JAVA Code...");
		platform = PlatformFactory.getPlatformInstance(PlatformType.JAVA);
		platform.execute(code);
		System.out.println("*************************");
		code = new Code();
		code.setCode("JAVA Code2...");
		platform = PlatformFactory.getPlatformInstance(PlatformType.JAVA);
		platform.execute(code);
		System.out.println("*************************");
		code = new Code();
		code.setCode("RUBY Code...");
		platform = PlatformFactory.getPlatformInstance(PlatformType.RUBY);
		platform.execute(code);
		System.out.println("*************************");
		code = new Code();
		code.setCode("RUBY Code2...");
		platform = PlatformFactory.getPlatformInstance(PlatformType.RUBY);
		platform.execute(code);
	}

}
