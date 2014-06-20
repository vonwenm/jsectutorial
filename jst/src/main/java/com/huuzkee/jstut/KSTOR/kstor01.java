//36.23.1.Retrieving a Key Pair from a Key Store
//http://www.java2s.com/Tutorial/Java/0490__Security/RetrievingaKeyPairfromaKeyStore.htm

package com.huuzkee.jstut.KSTOR;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class kstor01 {
  public static void main(String[] argv) throws Exception {
    FileInputStream is = new FileInputStream("your.keystore");

    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
    keystore.load(is, "my-keystore-password".toCharArray());

    String alias = "myalias";

    Key key = keystore.getKey(alias, "password".toCharArray());
    if (key instanceof PrivateKey) {
      // Get certificate of public key
      Certificate cert = keystore.getCertificate(alias);

      // Get public key
      PublicKey publicKey = cert.getPublicKey();

      // Return a key pair
      new KeyPair(publicKey, (PrivateKey) key);
    }
  }
}