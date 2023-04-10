package demo.java.security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.nio.charset.StandardCharsets;
import java.security.*;

public class SignatureExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA", new BouncyCastleProvider());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Signature signature = Signature.getInstance("SHA256WithDSA", new BouncyCastleProvider());

        signature.initSign(keyPair.getPrivate(), secureRandom);

        byte[] data = "abcdefghijklmnopqrstuvxyz".getBytes(StandardCharsets.UTF_8);
        signature.update(data);

        byte[] digitalSignature = signature.sign();


        Signature signature2 = Signature.getInstance("SHA256WithDSA", new BouncyCastleProvider());
        signature2.initVerify(keyPair.getPublic());

        signature2.update(data);

        boolean verified = signature2.verify(digitalSignature);

        System.out.println("verified = " + verified);
    }
}
