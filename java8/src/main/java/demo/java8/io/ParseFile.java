/**
 * 
 */
package demo.java8.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author rishabh.daim
 *
 */
public class ParseFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		final String fileName = "C:\\Users\\rishabh.daim\\Desktop\\queueSize3.txt";
		
		//final String newFileName = "C:\\Users\\rishabh.daim\\Desktop\\queueSize2.txt";
		
		Path path = Paths.get(fileName);
		
		/*Path newPath = Paths.get(newFileName);
		
		System.out.println(path.getFileName());
		
		List<String> readAllLines = Files.readAllLines(path);
		
		List<String> newAllLines = Lists.newLinkedList();
		
		for (String string : readAllLines) {
			String[] arr = string.split("\\{");
			
			newAllLines.add(arr[1].trim());
		}
		
		Files.write(newPath, newAllLines);*/
		
		List<String> allLines = Files.readAllLines(path);
		
		int[] noList = new int[allLines.size()];
		
		for (int i = 0; i < allLines.size(); i++) {
			noList[i] = Integer.valueOf(allLines.get(i));
		}
		
		Arrays.sort(noList);
		
		System.out.println(noList[0]);
		System.out.println(noList[allLines.size()-1]);
	}

}
