import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ces01 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    byte[] input = "input".getBytes();
    byte[] keyBytes = "input123".getBytes();
    byte[] msgNumber = "input".getBytes();

    IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);

    SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");

    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS7Padding", "BC");

    cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);

    IvParameterSpec encryptionIv = new IvParameterSpec(cipher.doFinal(msgNumber), 0, 8);

    cipher.init(Cipher.ENCRYPT_MODE, key, encryptionIv);

    byte[] cipherText = new byte[cipher.getOutputSize(input.length)];

    int ctLength = cipher.update(input, 0, input.length, cipherText, 0);

    ctLength += cipher.doFinal(cipherText, ctLength);

    System.out.println("cipher: " + new String(cipherText) + " bytes: " + ctLength);
    cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);

    IvParameterSpec decryptionIv = new IvParameterSpec(cipher.doFinal(msgNumber), 0, 8);

    cipher.init(Cipher.DECRYPT_MODE, key, decryptionIv);

    byte[] plainText = new byte[cipher.getOutputSize(ctLength)];

    int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);

    ptLength += cipher.doFinal(plainText, ptLength);

    System.out.println("plain : " + new String(plainText, ptLength));
  }
}