/**
 * 
 */
package demo.java8.journel.dev;

/**
 * @author rishabh.daim
 * 
 */
public class LongestPalindromeFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestPalindromeString("1234"));
		System.out.println(longestPalindromeString("12321"));
		System.out.println(longestPalindromeString("9912321456"));
		System.out.println(longestPalindromeString("9912333321456"));
		System.out.println(longestPalindromeString("12145445499"));
	}

	private static String longestPalindromeString(String in) {
		char[] input = in.toCharArray();
		int longestPalindromeStart = 0;
		int longestPalindromeEnd = 0;
		for (int mid = 0; mid < input.length; mid++) {
			// for odd palindrom case like 12321, 3 will be the mid
			int left = mid - 1;
			int right = mid + 1;
			// we need to move in the left and right side by 1 place till they
			// reach the end
			while (left >= 0 && right < input.length) {
				// below check to find out if its a palindrome
				if (input[left] == input[right]) {
					// update global indexes only if this is the longest one
					// till now
					if (right - left > longestPalindromeEnd
							- longestPalindromeStart) {
						longestPalindromeStart = left;
						longestPalindromeEnd = right;
					}
				}
				left--;
				right++;
			}
			// for even palindrome, we need to have similar logic with mid size
			// 2
			// for that we will start right from one extra place
			left = mid - 1;
			right = mid + 2;
			// for example 12333321 when we choose 33 as mid
			while (left >= 0 && right < input.length) {
				if (input[left] == input[right]) {
					if (right - left > longestPalindromeEnd
							- longestPalindromeStart) {
						longestPalindromeStart = left;
						longestPalindromeEnd = right;
					}
				}
				left--;
				right++;
			}
		}
		// we have the start and end indexes for longest palindrome now
		return in.substring(longestPalindromeStart, longestPalindromeEnd + 1);
	}
}