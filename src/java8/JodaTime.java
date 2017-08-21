/**
 * 
 */
package java8;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Rishabh.Daim
 *
 */
public class JodaTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Get the system clock as UTC offset
		Clock clock = Clock.systemUTC();
		System.out.println(clock.instant());
		System.out.println(clock.millis());

		// Get the local date and local time
		LocalDate localDate = LocalDate.now();
		LocalDate localDate2 = LocalDate.now(clock);

		System.out.println(localDate);
		System.out.println(localDate2);

		// Get the local date and local time
		LocalTime localTime = LocalTime.now();
		LocalTime localTime2 = LocalTime.now(clock);

		System.out.println(localTime);
		System.out.println(localTime2);

		// Get the local date/time
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime localDateTime2 = LocalDateTime.now(clock);

		System.out.println(localDateTime);
		System.out.println(localDateTime2);

		// Get the zoned date/time
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		ZonedDateTime zonedDateTime2 = ZonedDateTime.now(clock);
		ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId
				.of("America/Los_Angeles"));

		System.out.println(zonedDateTime);
		System.out.println(zonedDateTime2);
		System.out.println(zonedDatetimeFromZone);

		// Get duration between two dates
		LocalDateTime from = LocalDateTime.of(2014, Month.SEPTEMBER, 24, 0, 0,
				0);
		LocalDateTime to = LocalDateTime.of(2015, Month.AUGUST, 24, 0, 0, 0);

		Duration duration = Duration.between(from, to);
		System.out.println("Duration in days: " + duration.toDays());
		System.out.println("Duration in hours: " + duration.toHours());
	}

}
