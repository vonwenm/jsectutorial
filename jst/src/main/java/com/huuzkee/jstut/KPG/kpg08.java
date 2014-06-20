//36.22.8.Generate a 576-bit DH key pair
//http://www.java2s.com/Tutorial/Java/0490__Security/Generatea576bitDHkeypair.htm

package com.huuzkee.jstut.KPG;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class kpg08 {
  public static void main(String[] argv) throws Exception {
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH");
    keyGen.initialize(576);
    KeyPair keypair = keyGen.genKeyPair();
    PrivateKey privateKey = keypair.getPrivate();
    PublicKey publicKey = keypair.getPublic();
  }
}