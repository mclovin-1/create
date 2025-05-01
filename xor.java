package lab;

import java.util.*;

public class xor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pt = sc.nextLine();
        StringBuilder k = new StringBuilder(), c = new StringBuilder();
        Random r = new Random();
        for (char ch : pt.toCharArray()) {
            char b = (char) ('0' + r.nextInt(2));
            k.append(b);
            c.append((char)(ch ^ b));
        }
        System.out.println("Key: " + k + "\nCiphertext: " + c);

        StringBuilder d = new StringBuilder();
        for (int i = 0; i < c.length(); i++)
            d.append((char)(c.charAt(i) ^ k.charAt(i)));

        System.out.println("Decrypted: " + d);
        sc.close();
    }
}
