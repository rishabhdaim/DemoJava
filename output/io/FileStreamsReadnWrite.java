package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamsReadnWrite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("largeFile.txt");
		FileReader fis = null;
		FileWriter fos = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fis = new FileReader(file);
			br = new BufferedReader(fis, 90240);
			try {
				fos = new FileWriter(new File("out.txt"));
				bw = new BufferedWriter(fos, 90240);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String count = null;
		long l = System.currentTimeMillis();
		try {
			while ((count = br.readLine()) != null)
				bw.append(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - l);
		try {
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
