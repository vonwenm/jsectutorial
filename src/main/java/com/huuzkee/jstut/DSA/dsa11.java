//36.16.11.Create the DSA private key from a Set of Digital Signature Algorithm (DSA) Parameters
//http://www.java2s.com/Tutorial/Java/0490__Security/CreatetheDSAprivatekeyfromaSetofDigitalSignatureAlgorithmDSAParameters.htm

package com.huuzkee.jstut.DSA;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.KeySpec;

public class dsa11 {
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

    KeyFactory keyFactory = KeyFactory.getInstance("DSA");
    KeySpec privateKeySpec = new DSAPrivateKeySpec(x, p, q, g);
    PrivateKey privateKey1 = keyFactory.generatePrivate(privateKeySpec);
  }
}