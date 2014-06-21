//36.8.2.reading multiple certificates with a CertificateFactory.
//http://www.java2s.com/Tutorial/Java/0490__Security/readingmultiplecertificateswithaCertificateFactory.htm

package com.huuzkee.jstut.CFAC;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.x509.X509V1CertificateGenerator;

public class cfac02 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    KeyPair pair = generateRSAKeyPair();

    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    bOut.write(generateV1Certificate(pair).getEncoded());
    bOut.close();

    InputStream in = new ByteArrayInputStream(bOut.toByteArray());

    CertificateFactory fact = CertificateFactory.getInstance("X.509", "BC");

    X509Certificate x509Cert;
    Collection collection = new ArrayList();

    while ((x509Cert = (X509Certificate) fact.generateCertificate(in)) != null) {
      collection.add(x509Cert);
    }

    Iterator it = collection.iterator();
    while (it.hasNext()) {
      System.out.println("version: " + ((X509Certificate) it.next()).getVersion());
    }
  }

  public static X509Certificate generateV1Certificate(KeyPair pair) throws InvalidKeyException,
      NoSuchProviderException, SignatureException {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    X509V1CertificateGenerator certGen = new X509V1CertificateGenerator();

    certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
    certGen.setIssuerDN(new X500Principal("CN=Test Certificate"));
    certGen.setNotBefore(new Date(System.currentTimeMillis() - 10000));
    certGen.setNotAfter(new Date(System.currentTimeMillis() + 10000));
    certGen.setSubjectDN(new X500Principal("CN=Test Certificate"));
    certGen.setPublicKey(pair.getPublic());
    certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

    return certGen.generateX509Certificate(pair.getPrivate(), "BC");
  }

  public static KeyPair generateRSAKeyPair() throws Exception {
    KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA", "BC");
    kpGen.initialize(1024, new SecureRandom());
    return kpGen.generateKeyPair();
  }
}