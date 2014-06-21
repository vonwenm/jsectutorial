//36.36.1.Basic class for exploring PKCS #1 V1.5 Signatures.
//http://www.java2s.com/Tutorial/Java/0490__Security/BasicclassforexploringPKCS1V15Signatures.htm

package com.huuzkee.jstut.PKCS;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;

import javax.crypto.Cipher;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.util.ASN1Dump;

public class pkcs01 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
    keyGen.initialize(512, new SecureRandom());
    KeyPair keyPair = keyGen.generateKeyPair();

    Signature signature = Signature.getInstance("SHA256withRSA", "BC");
    signature.initSign(keyPair.getPrivate());

    byte[] message = "abc".getBytes();
    signature.update(message);

    byte[] sigBytes = signature.sign();
    Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", "BC");
    cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());

    byte[] decSig = cipher.doFinal(sigBytes);
    ASN1InputStream aIn = new ASN1InputStream(decSig);
    ASN1Sequence seq = (ASN1Sequence) aIn.readObject();

    System.out.println(ASN1Dump.dumpAsString(seq));

    MessageDigest hash = MessageDigest.getInstance("SHA-256", "BC");
    hash.update(message);

    ASN1OctetString sigHash = (ASN1OctetString) seq.getObjectAt(1);
    System.out.println(MessageDigest.isEqual(hash.digest(), sigHash.getOctets()));
  }
}