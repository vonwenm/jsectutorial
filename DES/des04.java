//36.12.4.Encrypt an object with DES
//http://www.java2s.com/Tutorial/Java/0490__Security/EncryptanobjectwithDES.htm


import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class des04 {
  private static void writeToFile(String filename, Object object) throws Exception {
   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filename)));
    oos.writeObject(object);
    oos.flush();
    oos.close();
  }

  public static void main(String[] args) throws Exception {
    SecretKey key = KeyGenerator.getInstance("DES").generateKey();
    writeToFile("secretkey.dat", key);
    Cipher cipher = Cipher.getInstance("DES");
    cipher.init(Cipher.ENCRYPT_MODE, key);
    SealedObject sealedObject = new SealedObject("THIS IS A SECRET MESSAGE!", cipher);
    writeToFile("sealed.dat", sealedObject);
  }
}