//36.14.1.Diffie-Hellman Key Agreement
//http://www.java2s.com/Tutorial/Java/0490__Security/DiffieHellmanKeyAgreement.htm

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.KeyAgreement;
import javax.crypto.spec.DHParameterSpec;

public class dhka01 {
  private static BigInteger g512 = new BigInteger("1234567890", 16);

  private static BigInteger p512 = new BigInteger("1234567890", 16);

  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    DHParameterSpec dhParams = new DHParameterSpec(p512, g512);
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH", "BC");

    keyGen.initialize(dhParams, new SecureRandom());

    KeyAgreement aKeyAgree = KeyAgreement.getInstance("DH", "BC");
    KeyPair aPair = keyGen.generateKeyPair();
    KeyAgreement bKeyAgree = KeyAgreement.getInstance("DH", "BC");
    KeyPair bPair = keyGen.generateKeyPair();

    aKeyAgree.init(aPair.getPrivate());
    bKeyAgree.init(bPair.getPrivate());

    aKeyAgree.doPhase(bPair.getPublic(), true);
    bKeyAgree.doPhase(aPair.getPublic(), true);

    MessageDigest hash = MessageDigest.getInstance("SHA1", "BC");
    System.out.println(new String(hash.digest(aKeyAgree.generateSecret())));
    System.out.println(new String(hash.digest(bKeyAgree.generateSecret())));
  }
}