//36.22.4.Asymmetric Key Maker
//http://www.java2s.com/Tutorial/Java/0490__Security/AsymmetricKeyMaker.htm

package com.huuzkee.jstut.KPG;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class kpg04 {

  public static void main(String[] args) throws Exception {
    String algorithm = "";
    KeyPair keyPair = KeyPairGenerator.getInstance(algorithm).generateKeyPair();

    System.out.println(keyPair.getPublic());
    System.out.println(keyPair.getPrivate());

  }
}