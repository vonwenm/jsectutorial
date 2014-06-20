//36.13.2.Sealed Objects
//http://www.java2s.com/Tutorial/Java/0490__Security/SealedObjects.htm

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;

public class dsed02 {
  public static void main(String[] args) throws Exception {
    String creditCard = "1234567890";

    KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");

    Key key = keyGenerator.generateKey();
    Cipher cipher = Cipher.getInstance("DESede");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    SealedObject so = new SealedObject(creditCard, cipher);

    String unencryptedCreditCard = (String) so.getObject(key);

    System.out.println(unencryptedCreditCard);
  }
}