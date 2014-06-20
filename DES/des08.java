import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class des08 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    SecureRandom random = new SecureRandom();
    IvParameterSpec ivSpec = createCtrIvForAES();
    Key key = createKeyForAES(256, random);
    Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding", "BC");
    String input = "12345678";
    Mac mac = Mac.getInstance("DES", "BC");
    byte[] macKeyBytes = new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08 };
    Key macKey = new SecretKeySpec(macKeyBytes, "DES");

    cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

    byte[] cipherText = new byte[cipher.getOutputSize(input.length() + mac.getMacLength())];

    int ctLength = cipher.update(input.getBytes(), 0, input.length(), cipherText, 0);

    mac.init(macKey);
    mac.update(input.getBytes());

    ctLength += cipher.doFinal(mac.doFinal(), 0, mac.getMacLength(), cipherText, ctLength);

    cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

    byte[] plainText = cipher.doFinal(cipherText, 0, ctLength);
    int messageLength = plainText.length - mac.getMacLength();

    mac.init(macKey);
    mac.update(plainText, 0, messageLength);

    byte[] messageHash = new byte[mac.getMacLength()];
    System.arraycopy(plainText, messageLength, messageHash, 0, messageHash.length);

    System.out.println("plain : " + new String(plainText) + " verified: "
        + MessageDigest.isEqual(mac.doFinal(), messageHash));

  }

  public static SecretKey createKeyForAES(int bitLength, SecureRandom random)
      throws NoSuchAlgorithmException, NoSuchProviderException {
    KeyGenerator generator = KeyGenerator.getInstance("AES", "BC");

    generator.init(128, random);

    return generator.generateKey();
  }

  public static IvParameterSpec createCtrIvForAES() {
    return new IvParameterSpec("1234567812345678".getBytes());
  }

}