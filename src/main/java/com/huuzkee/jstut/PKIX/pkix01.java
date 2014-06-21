//36.37.1.PKIX Demo
//http://www.java2s.com/Tutorial/Java/0490__Security/PKIXDemo.htm

package com.huuzkee.jstut.PKIX;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class pkix01 {
  public static void main(String args[]) throws Exception {
    CertificateFactory cf = CertificateFactory.getInstance("X.509");

    List mylist = new ArrayList();

    FileInputStream in = new FileInputStream(args[0]);
    Certificate c = cf.generateCertificate(in);
    mylist.add(c);

    CertPath cp = cf.generateCertPath(mylist);

    FileInputStream kin = new FileInputStream(args[0]);
    KeyStore ks = KeyStore.getInstance("JKS");
    ks.load(kin, args[1].toCharArray());

    PKIXParameters params = new PKIXParameters(ks);
    params.setRevocationEnabled(false);

    CertPathValidator cpv = CertPathValidator.getInstance("PKIX");

    PKIXCertPathValidatorResult result = (PKIXCertPathValidatorResult) cpv.validate(cp, params);

    PublicKey pbk = result.getPublicKey();
    byte[] pkenc = pbk.getEncoded();
    BigInteger pk = new BigInteger(pkenc);
    System.out.println(pk.toString(16));

    TrustAnchor anc = result.getTrustAnchor();
    X509Certificate xc = anc.getTrustedCert();
    System.out.println(xc.getSubjectDN());
    System.out.println(xc.getIssuerDN());

  }
}