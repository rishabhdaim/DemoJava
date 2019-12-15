package memory.leaks;

import org.aspectj.util.FileUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GetImage {

    private static int counter = 0;

    public static void main(String[] args) throws IOException {
        while(true) {
            getImage();
        }
    }

    private static void getImage() throws IOException {
        InputStream in = new FileInputStream("test.pdf");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        FileUtil.copyStream(in, outputStream);
        System.out.println(++counter);
//        System.out.println(outputStream);
    }
}
