//36.23.3.Retrieving a Certificate from a Key Store
//http://www.java2s.com/Tutorial/Java/0490__Security/RetrievingaCertificatefromaKeyStore.htm

package com.huuzkee.jstut.KSTOR;

import java.io.FileInputStream;
import java.security.KeyStore;

public class kstor03 {
  public static void main(String[] argv) throws Exception {
    FileInputStream is = new FileInputStream("your.keystore");

    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
    keystore.load(is, "my-keystore-password".toCharArray());

    // Get certificate
    java.security.cert.Certificate cert = keystore.getCertificate("myalias");
  }
}