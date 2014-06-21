//36.18.2.Use DES to Decrypt
//http://www.java2s.com/Tutorial/Java/0490__Security/UseDEStoDecrypt.htm

package com.huuzkee.jstut.ENDEC;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;

public class endec02 {
  public static void main(String[] args) throws Exception {
    desEncrypt("plaintextfile", "ciphertextfile");
  }

  public static void desEncrypt(String f1, String f2) throws Exception {
    SecretKey key = null;

    ObjectInputStream keyFile = new ObjectInputStream(new FileInputStream("DESKey.ser"));
    key = (SecretKey) keyFile.readObject();
    keyFile.close();
    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, key);
    CipherInputStream in = new CipherInputStream(new BufferedInputStream(new FileInputStream(f1)),
        cipher);
    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f2));
    int i;
    do {
      i = in.read();
      if (i != -1)
        out.write(i);
    } while (i > 0);
    in.close();
    out.close();
  }
}