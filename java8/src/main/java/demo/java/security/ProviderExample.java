package demo.java.security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class ProviderExample {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
    }
}
