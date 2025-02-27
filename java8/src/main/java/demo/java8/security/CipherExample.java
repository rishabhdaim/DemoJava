package demo.java8.security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

public class CipherExample {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        final byte[] keyBytes = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//        String algorithm = "RawBytes";
//        SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

        KeyGenerator keyGenerator  = KeyGenerator.getInstance("AES", new BouncyCastleProvider());
        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 256;
        keyGenerator.init(keyBitSize, secureRandom);

        System.out.println(keyGenerator.getAlgorithm());
        System.out.println(keyGenerator.getProvider());

        SecretKey secretKey = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", new BouncyCastleProvider());
        final IvParameterSpec ivspec = new IvParameterSpec(keyBytes);
//        cipher.init(Cipher.ENCRYPT_MODE, key, ivspec);
        cipher.init(ENCRYPT_MODE, secretKey, ivspec);

        final byte[] plainText = "abcdefghijklmnopqrstuvwxyz".getBytes(StandardCharsets.UTF_8);
        final byte[] cipherText = cipher.doFinal(plainText);

        System.out.println(new String(cipherText));

        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", new BouncyCastleProvider());
        cipher.init(DECRYPT_MODE, secretKey, ivspec);

        System.out.println(new String(cipher.doFinal(cipherText)));
    }
}
