import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

public class cyph01 {
  public static void main(String args[]) throws Exception {
    KeyGenerator kg = KeyGenerator.getInstance("DES");
    Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
    Key key = kg.generateKey();

    c.init(Cipher.ENCRYPT_MODE, key);
    byte input[] = "Stand and unfold yourself".getBytes();
    byte encrypted[] = c.doFinal(input);
    byte iv[] = c.getIV();

    IvParameterSpec dps = new IvParameterSpec(iv);
    c.init(Cipher.DECRYPT_MODE, key, dps);
    byte output[] = c.doFinal(encrypted);
    System.out.println(new String(output));
  }
}