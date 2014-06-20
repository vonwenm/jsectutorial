//36.23.4.Listing the Aliases in a Key Store: A key store is a collection of keys and certificates.
//http://www.java2s.com/Tutorial/Java/0490__Security/ListingtheAliasesinaKeyStoreAkeystoreisacollectionofkeysandcertificates.htm

package com.huuzkee.jstut.KSTOR;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Enumeration;

public class kstor04 {
  public static void main(String[] argv) throws Exception {
    FileInputStream is = new FileInputStream("yourfile"+".keystore");
    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
    String password = "my-keystore-password";
    keystore.load(is, password.toCharArray());

    Enumeration e = keystore.aliases();
    for (; e.hasMoreElements();) {
      String alias = (String) e.nextElement();

      boolean b = keystore.isKeyEntry(alias);

      b = keystore.isCertificateEntry(alias);
    }
    is.close();
  }
}
