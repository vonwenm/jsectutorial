//36.7.1.Using Certificates in Java
//http://www.java2s.com/Tutorial/Java/0490__Security/UsingCertificatesinJava.htm

package com.huuzkee.jstut.CERT;

import java.io.FileInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class cert01 {

  public static void main(String[] args) throws Exception {

    CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

    FileInputStream fis = new FileInputStream("a.dat");

    Certificate cert = certFactory.generateCertificate(fis);
    fis.close();

    System.out.println(cert);
  }
}