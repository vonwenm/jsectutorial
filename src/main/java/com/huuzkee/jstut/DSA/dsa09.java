//36.16.9.Getting the Digital Signature Algorithm (DSA) Parameters of a Key Pai
//http://www.java2s.com/Tutorial/Java/0490__Security/GettingtheDigitalSignatureAlgorithmDSAParametersofaKeyPair.htm

package com.huuzkee.jstut.DSA;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;

public class dsa09 {
  public static void main(String[] argv) throws Exception {
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
    keyGen.initialize(1024);
    KeyPair keypair = keyGen.genKeyPair();
    DSAPrivateKey privateKey = (DSAPrivateKey) keypair.getPrivate();
    DSAPublicKey publicKey = (DSAPublicKey) keypair.getPublic();

    DSAParams dsaParams = privateKey.getParams();
    BigInteger p = dsaParams.getP();
    BigInteger q = dsaParams.getQ();
    BigInteger g = dsaParams.getG();
    BigInteger x = privateKey.getX();
    BigInteger y = publicKey.getY();
  }
}