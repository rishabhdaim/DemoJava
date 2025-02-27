/*package java7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ARM {

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		String read = null;

		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				"largeFile.txt")), 10240);
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
						"arm.txt")), 10240)) {
			while ((read = br.readLine()) != null)
				bw.write(read);
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}
}
*/