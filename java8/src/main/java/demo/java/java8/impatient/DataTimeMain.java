/**
 * 
 */
package demo.java.java8.impatient;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.Month.JANUARY;
import static java.time.Month.NOVEMBER;
import static java.time.temporal.TemporalAdjusters.next;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Set;

/**
 * @author Rishabh.Daim
 *
 */
public class DataTimeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Instant
		instant();

		// LocalDateTime
		loaclDateTime();

		// dateAdjusters
		dateAdjusters();

		// dateTime
		dateTime();

		// ZoneDateTime
		zoneDateTime();

		// dateFormatter
		dateFormatter();
	}

	private static void dateFormatter() {
		ZonedDateTime dateTime = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0,
				ZoneId.of("America/New_York"));
		String formatted = DateTimeFormatter.ISO_DATE_TIME.format(dateTime);
		System.out.println(formatted);

		// date formatter
		DateTimeFormatter formatter = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.LONG);
		formatted = formatter.withLocale(Locale.GERMAN).format(dateTime);
		System.out.println(formatted);

		formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
		formatted = formatter.withLocale(Locale.FRANCE).format(dateTime);
		System.out.println(formatted);

		formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		formatted = formatter.format(dateTime);
		System.out.println(formatted);

		formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		formatted = formatter.withLocale(Locale.ITALIAN).format(dateTime);
		System.out.println(formatted);

		formatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
		formatted = formatter.withLocale(Locale.FRENCH).format(dateTime);
		System.out.println(formatted);

		// parsing
		LocalDate churchsBirthday = LocalDate.parse("1903-06-14");
		System.out.println(churchsBirthday);
		ZonedDateTime apollo11launch = ZonedDateTime.parse(
				"1969-07-16 03:32:00-0400",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssxx"));
		System.out.println(apollo11launch);
	}

	private static void zoneDateTime() {
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println(availableZoneIds);

		LocalDateTime apollo11launch = LocalDateTime.of(1969, 7, 16, 9, 32, 0,
				0);

		System.out.println(apollo11launch);

		ZonedDateTime atZone = apollo11launch.atZone(ZoneId
				.of("America/New_York"));
		System.out.println(atZone);

		Instant ins = atZone.toInstant();
		System.out.println(ins);

		// DayLight savings
		ZonedDateTime skipped = ZonedDateTime.of(LocalDate.of(2013, 3, 31),
				LocalTime.of(2, 30), ZoneId.of("Europe/Berlin"));
		System.out.println(skipped);

		ZonedDateTime ambiguous = ZonedDateTime.of(LocalDate.of(2013, 10, 27), // End
																				// of
																				// daylight
																				// savings
																				// time
				LocalTime.of(2, 30), ZoneId.of("Europe/Berlin"));
		System.out.println(ambiguous);
		// 2013-10-27T02:30+02:00[Europe/Berlin]
		ZonedDateTime anHourLater = ambiguous.plusHours(1);
		// 2013-10-27T02:30+01:00[Europe/Berlin]
		System.out.println(anHourLater);

		ZonedDateTime nextMeeting = anHourLater.plus(Period.ofDays(7)); // OK
		System.out.println(nextMeeting);
	}

	private static void dateTime() {
		LocalTime now = LocalTime.now();
		System.out.println(now);

		LocalTime bedTime = LocalTime.of(11, 40);
		System.out.println(bedTime);

		LocalTime wakeUp = bedTime.plusHours(8);
		System.out.println(wakeUp);
	}

	private static void dateAdjusters() {
		LocalDate with = LocalDate.of(2016, JANUARY, 1).with(next(FRIDAY));
		System.out.println(with);

		// next working day
		LocalDate nextWorkingDay = LocalDate.of(2015, Month.FEBRUARY, 20).with(
				t -> {

					LocalDate date = (LocalDate) t;
					do {
						date = date.plusDays(1);
					} while (date.getDayOfWeek().getValue() >= 6);

					return date;
				});

		System.out.println(nextWorkingDay);

		// next working method

		nextWorkingDay = LocalDate.of(2015, Month.FEBRUARY, 20).with(
				TemporalAdjusters.ofDateAdjuster(t -> {
					do {
						t = t.plusDays(1);
					} while (t.getDayOfWeek().getValue() >= 6);

					return t;
				}));

		System.out.println(nextWorkingDay);
	}

	private static void loaclDateTime() {
		LocalDate myBirthday = LocalDate.now();
		System.out.println(myBirthday);

		// Birthday
		myBirthday = LocalDate.of(1991, JANUARY, 24);
		System.out.println(myBirthday);

		LocalDate ankuBirthday = LocalDate.of(1992, NOVEMBER, 21);

		LocalDate plusDays = myBirthday.plusDays(20);
		System.out.println(plusDays);

		LocalDate withDayOfMonth = plusDays.withDayOfMonth(23);
		System.out.println(withDayOfMonth);

		DayOfWeek dayOfWeek = withDayOfMonth.getDayOfWeek();
		System.out.println(dayOfWeek);

		LocalDate period = withDayOfMonth.plus(Period.ofWeeks(34));
		System.out.println(period);

		long until = myBirthday.until(ankuBirthday, ChronoUnit.DAYS);
		System.out.println(until);

		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
	}

	private static void instant() {
		Instant now = Instant.now();
		System.out.println(now);
		for (int i = 0; i < Integer.MAX_VALUE; i++)
			;
		Instant after = Instant.now();

		Duration timeTaken = Duration.between(now, after);
		System.out.println(timeTaken.toMillis());

		Duration plus = timeTaken.plus(Duration.ofSeconds(120));

		System.out.println(plus.toMillis());
	}

}
