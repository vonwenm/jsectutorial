//36.11.2.Using CipherOutputStream
//http://www.java2s.com/Tutorial/Java/0490__Security/UsingCipherOutputStream.htm

package com.huuzkee.jstut.CYST;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class cyst02 {
  public static void main(String args[]) throws Exception {
    KeyGenerator kg = KeyGenerator.getInstance("DES");
    kg.init(new SecureRandom());
    SecretKey key = kg.generateKey();
    SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
    Class spec = Class.forName("javax.crypto.spec.DESKeySpec");
    DESKeySpec ks = (DESKeySpec) skf.getKeySpec(key, spec);
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("keyfile.txt"));
    oos.writeObject(ks.getKey());

    Cipher c = Cipher.getInstance("DES/CFB8/NoPadding");
    c.init(Cipher.ENCRYPT_MODE, key);
    CipherOutputStream cos = new CipherOutputStream(new FileOutputStream("ciphertext.txt"), c);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(cos));
    pw.println("Stand and unfold yourself");
    pw.close();
    oos.writeObject(c.getIV());
    oos.close();
  }
}