package lab;

import java.util.*;

public class ceasar {
    static String encrypt(String msg, int k) {
        StringBuilder r = new StringBuilder();
        for (char c : msg.toCharArray())
            r.append((c >= 'a' && c <= 'z') ? (char) ((c - 'a' + k) % 26 + 'a') : c);
        return r.toString();
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine(); int k = sc.nextInt();
        String e = encrypt(m, k);
        System.out.println("Encrypted: " + e + "\nDecrypted: " + encrypt(e, 26 - (k % 26)));
        sc.close();
    }
}
