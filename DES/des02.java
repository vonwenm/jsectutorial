//36.12.2.Basic symmetric encryption example with CTR using DES
//http://www.java2s.com/Tutorial/Java/0490__Security/BasicsymmetricencryptionexamplewithCTRusingDES.htm

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class des02 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    byte[] input = "input".getBytes();
    byte[] keyBytes = "12345678".getBytes();
    byte[] ivBytes = "input123".getBytes();

    SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
    IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
    Cipher cipher = Cipher.getInstance("DES/CTR/NoPadding", "BC");

    cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

    byte[] cipherText = new byte[cipher.getOutputSize(input.length)];

    int ctLength = cipher.update(input, 0, input.length, cipherText, 0);

    ctLength += cipher.doFinal(cipherText, ctLength);

    System.out.println("cipher: " + new String(cipherText));

    cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

    byte[] plainText = new byte[cipher.getOutputSize(ctLength)];

    int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);

    ptLength += cipher.doFinal(plainText, ptLength);

    System.out.println("plain : " + new String(plainText));
  }
}