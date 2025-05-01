package lab;

import java.security.*;
import java.util.*;

public class DSA { 
    public static void main(String[] args) throws Exception { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter data to sign: "); 
        String input = sc.nextLine(); 
        sc.close(); 
 
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA"); 
        kpg.initialize(512); 
        KeyPair kp = kpg.generateKeyPair(); 
 
        Signature sig = Signature.getInstance("SHAwithDSA"); 
        sig.initSign(kp.getPrivate()); 
        sig.update(input.getBytes()); 
        byte[] signature = sig.sign(); 
        String sigB64 = Base64.getEncoder().encodeToString(signature); 
        System.out.println("Signature: " + sigB64); 
 
        sig.initVerify(kp.getPublic()); 
        sig.update(input.getBytes()); 
        boolean valid = sig.verify(Base64.getDecoder().decode(sigB64)); 
        System.out.println("Signature valid: " + valid); 
    } 
} 

