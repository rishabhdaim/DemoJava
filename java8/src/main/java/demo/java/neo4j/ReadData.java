/**
 * 
 */
package demo.java.neo4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Rishabh.Daim
 *
 */
public class ReadData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Set<String> codes = new HashSet<>(13000);
			List<String> stations = Files.readAllLines(Paths.get("C:\\Users\\rishabh.daim\\Downloads\\trains2.txt"), StandardCharsets.UTF_8);
			
			/*for (Iterator<String> iterator = stations.iterator(); iterator.hasNext();) {
				String code = iterator.next();
				String name = iterator.next();
				String start = iterator.next();
				String end = iterator.next();
				trains.add(StringUtils.join(new String[] {code.trim().toUpperCase(), name.trim().toUpperCase(), start.trim().toUpperCase(), end.trim().toUpperCase()}, ","));
			}*/
			
			for (String string : stations) {
				String[] arr = string.split(",");
				trim(arr);
				codes.add(arr[0]);
			}
			List<String> readAllLines = Files.readAllLines(Paths.get("C:\\Users\\rishabh.daim\\Downloads\\trainFinalList.txt"), StandardCharsets.UTF_8);
			for (String string : readAllLines) {
				String[] arr = string.split(",");
				trim(arr);
				if (codes.add(arr[0])) {
					stations.add(string);
				}
			}
			// Files.write(Paths.get("C:\\Users\\rishabh.daim\\Downloads\\station1.txt"), stations, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void trim(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			String string = arr[i];
			arr[i] = string.trim().toUpperCase();
		}
	}

}
