/**
 * 
 */
package demo.java.java8;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Rishabh.Daim
 *
 */
public class DateTimeApi {

	final LocalDate today = LocalDate.now();
	final LocalDate bday = LocalDate.of(1991, 1, 24);

	@Test
	public void test() {
		LocalDate date = today.plusDays(30);
		Assert.assertTrue(date.isEqual(today.plusDays(30)));
	}
}