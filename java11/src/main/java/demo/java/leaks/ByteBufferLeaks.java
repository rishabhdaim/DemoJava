package demo.java.leaks;

import java.nio.ByteBuffer;

public class ByteBufferLeaks {
    public static void main(String[] args) {
        var counter = 0;
        while (true) {
            System.out.println(++counter);
            ByteBuffer.allocateDirect(1000000000);
        }
    }
}
