//6.11.1.Using CipherInputStream
//http://www.java2s.com/Tutorial/Java/0490__Security/UsingCipherInputStream.htm

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class cyst01 {
  public static void main(String args[]) throws Exception {
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("keyfile.txt"));
    DESKeySpec ks = new DESKeySpec((byte[]) ois.readObject());
    SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
    SecretKey key = skf.generateSecret(ks);

    Cipher c = Cipher.getInstance("DES/CFB8/NoPadding");
    c.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec((byte[]) ois.readObject()));
    CipherInputStream cis = new CipherInputStream(new FileInputStream("ciphertext.txt"), c);
    BufferedReader br = new BufferedReader(new InputStreamReader(cis));
    System.out.println(br.readLine());
  }
}