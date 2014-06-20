//36.18.1.DES Encrypt Console
//http://www.java2s.com/Tutorial/Java/0490__Security/DESEncryptConsole.htm

package com.huuzkee.jstut.ENDEC;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class endec01 {
  public static void main(String[] args) throws Exception {
    desEncrypt("plaintextfile", "ciphertextfile");
  }

  public static void desEncrypt(String f1, String f2) throws Exception {
    SecretKey key = null;
    ObjectInputStream keyFile = new ObjectInputStream(new FileInputStream("DESKey.ser"));
    key = (SecretKey) keyFile.readObject();
    keyFile.close();

    KeyGenerator keygen = KeyGenerator.getInstance("DES");
    key = keygen.generateKey();
    ObjectOutputStream keyFileout = new ObjectOutputStream(new FileOutputStream("DESKey.ser"));
    keyFileout.writeObject(key);
    keyFileout.close();
    Cipher cipher = null;
    cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key);
    BufferedInputStream in = new BufferedInputStream(new FileInputStream(f1));

    CipherOutputStream out = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(
        f2)), cipher);
    int i;
    do {
      i = in.read();
      if (i != -1)
        out.write(i);
    } while (i != -1);
    in.close();
    out.close();
  }
}