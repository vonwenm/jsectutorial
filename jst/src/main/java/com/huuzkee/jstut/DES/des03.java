//36.12.3.Decrypt an object with DES
//http://www.java2s.com/Tutorial/Java/0490__Security/DecryptanobjectwithDES.htm

package com.huuzkee.jstut.DES;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class des03 {
  private static Object readFromFile(String filename) throws Exception {
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filename)));
    Object object = ois.readObject();
    ois.close();
    return object;
  }

  public static void main(String[] args) throws Exception {
    SecretKey key = (SecretKey) readFromFile("secretkey.dat");
    SealedObject sealedObject = (SealedObject) readFromFile("sealed.dat");
    String algorithmName = sealedObject.getAlgorithm();
    Cipher cipher = Cipher.getInstance(algorithmName);
    cipher.init(Cipher.DECRYPT_MODE, key);
    String text = (String) sealedObject.getObject(cipher);
    System.out.println("Text = " + text);
  }
}