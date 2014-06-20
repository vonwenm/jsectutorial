//36.20.5.Rich DES Key
//http://www.java2s.com/Tutorial/Java/0490__Security/RichDESKey.htm

package com.huuzkee.jstut.KEY;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class key05 {

  public static void main(String args[]) throws Exception {

    KeyGenerator keyGen = KeyGenerator.getInstance("DES");
    SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
    random.setSeed(101L);
    keyGen.init(56, random);
    SecretKey sKey = keyGen.generateKey();
    SecretKeyFactory kfactory = SecretKeyFactory.getInstance("DES");

    DESKeySpec kspec = (DESKeySpec) kfactory.getKeySpec(sKey, DESKeySpec.class);

    System.out.println(sKey);
    FileOutputStream fos = new FileOutputStream("secretKeys");
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.writeObject(kspec.getKey());

    FileInputStream fin = new FileInputStream("secretKeys");
    ObjectInputStream ois = new ObjectInputStream(fin);

    byte[] kMaterial = (byte[]) ois.readObject();

    DESKeySpec keyspec = new DESKeySpec(kMaterial);
    SecretKey newKey = kfactory.generateSecret(keyspec);
    System.out.println(newKey);
    System.out.println("Do the keys equal :" + newKey.equals(sKey));

  }
}