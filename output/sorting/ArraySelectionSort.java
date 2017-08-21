package sorting;

public class ArraySelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = new String[10];
		arr[0] = "msas";
		arr[1] = "nksas";
		arr[2] = "vsas";
		arr[3] = "nsas";
		arr[4] = "ksas";
		arr[5] = "jsas";
		arr[6] = "hsas";
		arr[7] = "gsas";
		arr[8] = "rsas";
		arr[9] = "fd";
		for (String string : arr)
			System.out.print(string + " ");
		System.out.println();
		selectionSort(arr, 0, arr.length - 1);
		for (String string : arr)
			System.out.print(string + " ");
	}

	private static <T> void selectionSort(Comparable<T>[] arr, int left,
			int right) {
		for (int i = left; i < right; i++) {
			int least = i;
			for (int j = i + 1; j <= right; j++) {
				@SuppressWarnings("unchecked")
				int comp = arr[j].compareTo((T) arr[least]);

				if (comp < 0)
					least = j;
			}

			Comparable<T> temp = arr[least];
			if (least != i) {
				arr[least] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
