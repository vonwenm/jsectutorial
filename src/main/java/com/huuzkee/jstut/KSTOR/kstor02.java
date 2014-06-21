//36.23.2.Adding a Certificate to a Key Store
//http://www.java2s.com/Tutorial/Java/0490__Security/AddingaCertificatetoaKeyStore.htm

package com.huuzkee.jstut.KSTOR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class kstor02 {
  public static void main(String[] argv) throws Exception {
    FileInputStream is = new FileInputStream("your.keystore");

    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
    keystore.load(is, "my-keystore-password".toCharArray());

    String alias = "myalias";
    char[] password = "password".toCharArray();

    Certificate cert = keystore.getCertificate(alias);

    File keystoreFile = new File("your.keystore");
    // Load the keystore contents
    FileInputStream in = new FileInputStream(keystoreFile);
    keystore.load(in, password);
    in.close();

    // Add the certificate
    keystore.setCertificateEntry(alias, cert);

    // Save the new keystore contents
    FileOutputStream out = new FileOutputStream(keystoreFile);
    keystore.store(out, password);
    out.close();

  }
}