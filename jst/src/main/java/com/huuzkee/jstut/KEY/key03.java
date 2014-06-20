//36.20.3.Key Agreement
//http://www.java2s.com/Tutorial/Java/0490__Security/KeyAgreement.htm

package com.huuzkee.jstut.KEY;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

public class key03 {
  public static void main(String[] args) throws Exception {
    String s = "F488FD584E49DBCD20B49DE49107366B336C380D451D0F7C88"
        + "11111111111111111111111111111111111111111111111111"
        + "11111111111111111111111111111111111111111111111111"
        + "11111111111111111111111111111111111111111111111111"
        + "11111111111111111111111111111111111111111111111111" + "2F78C7";
    BigInteger base = BigInteger.valueOf(2);
    BigInteger modulus = new BigInteger(s, 16);
    DHParameterSpec skipParameterSpec = new DHParameterSpec(modulus, base);

    KeyPairGenerator kpg1 = KeyPairGenerator.getInstance("DH");
    kpg1.initialize(skipParameterSpec);
    KeyPair kp1 = kpg1.generateKeyPair();

    KeyAgreement ka1 = KeyAgreement.getInstance("DH");
    DHPrivateKey privateKey1 = (DHPrivateKey) kp1.getPrivate();
    DHPublicKey publicKey1 = (DHPublicKey) kp1.getPublic();
    ka1.init(privateKey1);
    System.out.println("1 is using " + publicKey1.getY() + " for its public key");
    KeyPairGenerator kpg2 = KeyPairGenerator.getInstance("DH");
    kpg2.initialize(skipParameterSpec);
    KeyPair kp2 = kpg2.generateKeyPair();

    KeyAgreement ka2 = KeyAgreement.getInstance("DH");
    DHPrivateKey privateKey2 = (DHPrivateKey) kp2.getPrivate();
    DHPublicKey publicKey2 = (DHPublicKey) kp2.getPublic();
    ka2.init(privateKey2);
    System.out.println("2 is using " + publicKey2.getY() + " for its public key");
    ka1.doPhase(publicKey2, true);
    byte[] sharedKey1 = ka1.generateSecret();
    System.out.println("1 is using " + new BigInteger(1, sharedKey1) + " for its shared key");

    ka2.doPhase(publicKey1, true);
    byte[] sharedKey2 = ka2.generateSecret();
    System.out.println("2 is using " + new BigInteger(1, sharedKey2) + " for its shared key");
  }

}