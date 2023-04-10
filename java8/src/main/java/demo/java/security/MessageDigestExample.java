package demo.java.security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256", new BouncyCastleProvider());

        byte[] data1 = "0123456789".getBytes(StandardCharsets.UTF_8);
        byte[] data2 = "abcdefghijklmnopqrstuvxyz".getBytes(StandardCharsets.UTF_8);

        messageDigest.update(data1);
        messageDigest.update(data2);

        byte[] digest = messageDigest.digest();

        System.out.println(new String(digest));
    }
}
