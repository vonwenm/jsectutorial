//36.32.1.Principal and Certificate
//http://www.java2s.com/Tutorial/Java/0490__Security/PrincipalandCertificate.htm

package com.huuzkee.jstut.PRIN;

import java.io.FileInputStream;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class prin01 {
  public static void main(String args[]) throws Exception {
    Certificate[] certpath = new Certificate[args.length];
    CertificateFactory cf = CertificateFactory.getInstance("X.509");

    for (int i = 0; i < args.length; i++) {
      FileInputStream in = new FileInputStream(args[i]);
      certpath[i] = cf.generateCertificate(in);
    }
    for (int i = 0; i < certpath.length - 1; i++) {
      Principal issuer = ((X509Certificate) certpath[i]).getIssuerDN();
      Principal subject = ((X509Certificate) certpath[i + 1]).getSubjectDN();
      if (!issuer.equals(subject)) {
        System.out.println("in " + i + " issuer is " + issuer);
        System.out.println("But in " + (i + 1));
        System.out.println("subject is " + subject);
        break;
      }
    }
  }
}
