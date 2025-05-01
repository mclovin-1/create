package lab;

import java.util.*;

public class rail {
    static String encrypt(String m, int k) {
        StringBuilder e = new StringBuilder();
        for (int i = 0; i < k; i++)
            for (int j = i; j < m.length(); j += k) e.append(m.charAt(j));
        return e.toString();
    }

    static String decrypt(String m, int k) {
        char[] d = new char[m.length()];
        for (int i = 0, idx = 0; i < k; i++)
            for (int j = i; j < m.length(); j += k)
                d[j] = m.charAt(idx++);
        return new String(d);
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine(); int k = sc.nextInt();
        String e = encrypt(m, k);
        System.out.println("Encrypted: " + e + "\nDecrypted: " + decrypt(e, k));
        sc.close();
    }
}
