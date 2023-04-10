/**
 * 
 */
package demo.java.java8;

import java.io.IOException;


import com.mscharhag.et.ExceptionTranslator;

/**
 * @author rishabh.daim
 *
 */
public class ET {

	/**
	 * @param args
	 */

	static ExceptionTranslator et = com.mscharhag.et.ET.newConfiguration()
			.translate(IOException.class, IllegalAccessException.class)
			.to(NullPointerException.class).done();

	public static void main(String[] args) {
		et.withTranslation(()->{
			throw new IllegalAccessException("exception");
		});
	}

}
