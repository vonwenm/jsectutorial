//36.18.4.Blowfish Decrypt
//http://www.java2s.com/Tutorial/Java/0490__Security/BlowfishDecrypt.htm

package com.huuzkee.jstut.ENDEC;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;

public class endec04 {
  public static void main(String[] args) throws Exception {
    blowfishEncrypt("ciphertextfile", "plaintextfile");
  }

  public static void blowfishEncrypt(String f1, String f2) throws Exception {
    SecretKey key = null;

    ObjectInputStream keyFile = new ObjectInputStream(new FileInputStream("BlowfishKey.ser"));
    key = (SecretKey) keyFile.readObject();
    keyFile.close();
    Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
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