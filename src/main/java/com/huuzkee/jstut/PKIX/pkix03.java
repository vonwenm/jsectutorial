//36.37.3.Getting the Subject and Issuer Distinguished Names of an X509 Certificate
//http://www.java2s.com/Tutorial/Java/0490__Security/GettingtheSubjectandIssuerDistinguishedNamesofanX509Certificate.htm

package com.huuzkee.jstut.PKIX;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class pkix03 {
  public static void main(String[] argv) throws Exception {
    FileInputStream is = new FileInputStream("your.keystore");

    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
    keystore.load(is, "my-keystore-password".toCharArray());

    Enumeration e = keystore.aliases();
    for (; e.hasMoreElements();) {
      String alias = (String) e.nextElement();

      java.security.cert.Certificate cert = keystore.getCertificate(alias);
      if (cert instanceof X509Certificate) {
        X509Certificate x509cert = (X509Certificate) cert;

        // Get subject
        Principal principal = x509cert.getSubjectDN();
        String subjectDn = principal.getName();

        // Get issuer
        principal = x509cert.getIssuerDN();
        String issuerDn = principal.getName();
      }
    }
  }
}