//36.16.8.Use DSAPrivateKeySpec
//http://www.java2s.com/Tutorial/Java/0490__Security/UseDSAPrivateKeySpec.htm

package com.huuzkee.jstut.DSA;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.DSAPrivateKeySpec;

public class dsa08 {
  public static void main(String args[]) throws Exception {
    FileInputStream fis = new FileInputStream("exportedKey");
    ObjectInputStream ois = new ObjectInputStream(fis);
    DSAPrivateKeySpec ks = new DSAPrivateKeySpec((BigInteger) ois.readObject(), (BigInteger) ois
        .readObject(), (BigInteger) ois.readObject(), (BigInteger) ois.readObject());
    KeyFactory kf = KeyFactory.getInstance("DSA");
    PrivateKey pk = kf.generatePrivate(ks);
    System.out.println("Got private key");
  }
}