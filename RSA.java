package lab;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger message = new BigInteger(sc.nextLine().getBytes());
        sc.close();

        SecureRandom rand = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(256, rand);
        BigInteger q = BigInteger.probablePrime(256, rand);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(65537);
        BigInteger d = e.modInverse(phi);

        BigInteger encrypted = message.modPow(e, n);
        BigInteger decrypted = encrypted.modPow(d, n);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + new String(decrypted.toByteArray()));
    }
}

