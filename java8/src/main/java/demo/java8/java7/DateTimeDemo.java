/**
 * 
 */
package demo.java8.java7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author Rishabh.Daim
 *
 */
public class DateTimeDemo {
	
	class Inner{
		
		void test() {
			if (DateTimeDemo.this.flag) {
				sample();
			}
		}
	}
	
	boolean flag = true;
	public void sample() {
		System.out.println("sample");
	}
	
	public DateTimeDemo() {
		(new Inner()).test();
	}

	public static void main(String[] args) throws ParseException {

		timeCheck();
		
		timeCheck2();
		
		String[] arr = {"722/148+360/176"};
		
		for (int i = 0; i < arr.length; i++) {
			
			String[] arr2 = arr[i].split("\\+");
			
			String[] s1Arr = arr2[0].split("/");
			String[] s2Arr = arr2[1].split("/");
			
			int a = Integer.parseInt(s1Arr[1]);
			int b = Integer.parseInt(s2Arr[1]);
			
			int lcm = lcm(a, b);
			
			int n1 = Integer.parseInt(s1Arr[0]);
			int n2 = Integer.parseInt(s2Arr[0]);
			
			n1 = lcm/a*n1;
			n2 = lcm/b*n2;
			
			int n = n1 + n2;
			
			int gcd = gcd(lcm, n);
			
			
			arr[i] = (n/gcd+"/" + lcm/gcd);
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return (gcd(b, a % b));
		}
	}


	/**
	 * @throws ParseException 
	 * 
	 */
	private static void timeCheck() throws ParseException {
		long t = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

			String format = sdf.format(Calendar.getInstance().getTime());
			
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			
			sdf.parse(format);
		}

		System.out.println(System.currentTimeMillis() - t);
	}
	
	private static void timeCheck2() {
		long t = System.currentTimeMillis();
		
		long l = 0;

		for (int i = 0; i < 10; i++) {

			l = t + Calendar.getInstance().getTimeZone().getOffset(t);
			l = t + Calendar.getInstance().getTimeZone().getOffset(t);
		}
		
		System.out.println(l);
		System.out.println(System.currentTimeMillis() - t);
	}

}
