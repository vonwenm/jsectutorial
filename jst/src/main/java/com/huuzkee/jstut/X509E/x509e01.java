//36.48.1.use of X509EncodedKeySpec
//http://www.java2s.com/Tutorial/Java/0490__Security/useofX509EncodedKeySpec.htm

package com.huuzkee.jstut.X509E;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class x509e01 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");

    generator.initialize(128, new SecureRandom());
    KeyPair pair = generator.generateKeyPair();
    ASN1InputStream aIn = new ASN1InputStream(pair.getPublic().getEncoded());
    SubjectPublicKeyInfo info = SubjectPublicKeyInfo.getInstance(aIn.readObject());

    System.out.println(ASN1Dump.dumpAsString(info));
    System.out.println(ASN1Dump.dumpAsString(info.getPublicKey()));

    X509EncodedKeySpec x509Spec = new X509EncodedKeySpec(pair.getPublic().getEncoded());
    KeyFactory keyFact = KeyFactory.getInstance("RSA", "BC");
    PublicKey pubKey = keyFact.generatePublic(x509Spec);

    System.out.println(pubKey.equals(pair.getPublic()));
  }
}
/*
DER Sequence
    DER Sequence
        ObjectIdentifier(1.2.840.113549.1.1.1)
        NULL
    DER Bit String[26, 0]

DER Sequence
    Integer(171211678289811562909793981152149017387)
    Integer(65537)

true

 */