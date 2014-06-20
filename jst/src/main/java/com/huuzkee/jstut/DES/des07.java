//36.12.7.Encrypting a File or Stream with DES
//http://www.java2s.com/Tutorial/Java/0490__Security/EncryptingaFileorStreamwithDES.htm

package com.huuzkee.jstut.DES;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

class DesEncrypter {
  byte[] buf = new byte[1024];
  Cipher ecipher;
  Cipher dcipher;
  DesEncrypter(SecretKey key) throws Exception{
    byte[] iv = new byte[] { (byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F, 0x5A };
    AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
    ecipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    dcipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

    ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
    dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
  }


  public void encrypt(InputStream in, OutputStream out)  throws Exception{
    out = new CipherOutputStream(out, ecipher);

    int numRead = 0;
    while ((numRead = in.read(buf)) >= 0) {
      out.write(buf, 0, numRead);
    }
    out.close();
  }

  public void decrypt(InputStream in, OutputStream out)  throws Exception{
    in = new CipherInputStream(in, dcipher);

    int numRead = 0;
    while ((numRead = in.read(buf)) >= 0) {
      out.write(buf, 0, numRead);
    }
    out.close();
  }
}

public class des07 {
  public static void main(String[] argv) throws Exception {
    SecretKey key = KeyGenerator.getInstance("DES").generateKey();
    DesEncrypter encrypter = new DesEncrypter(key);
    encrypter.encrypt(new FileInputStream("cleartext01.txt"), new FileOutputStream("ciphertext.txt"));
    encrypter.decrypt(new FileInputStream("ciphertext.txt"), new FileOutputStream("cleartext02.txt"));
  }
}