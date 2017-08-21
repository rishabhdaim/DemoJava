package journel.dev;

import oracle.jdbc.driver.OracleDriver;

public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("class loader for HashMap: "
				+ java.util.HashMap.class.getClassLoader());
		System.out.println("class loader for DNSNameService: "
				+ sun.net.spi.nameservice.dns.DNSNameService.class
						.getClassLoader());
		System.out.println("class loader for this class: "
				+ ClassLoaderTest.class.getClassLoader());
		System.out.println(OracleDriver.class.getClassLoader());
	}
}