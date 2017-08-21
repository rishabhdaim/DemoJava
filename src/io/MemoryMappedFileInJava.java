package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMappedFileInJava {
	private static final int count = 1048576000; // 1 Gb

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		RandomAccessFile memoryMappedFile = new RandomAccessFile(
				"largeFile3.txt", "rw");

		MappedByteBuffer out = memoryMappedFile.getChannel().map(
				FileChannel.MapMode.READ_WRITE, 0, count);
		long l = System.currentTimeMillis();
		for (int i = 0; i < count; i++)
			out.put((byte) 'b');
		System.out.println(System.currentTimeMillis() - l);
	}
}