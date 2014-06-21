//36.39.1.Create a 64 bit secret key from raw bytes
//http://www.java2s.com/Tutorial/Java/0490__Security/Createa64bitsecretkeyfromrawbytes.htm

package com.huuzkee.jstut.SKEY;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class  skey01 {
  public static void main(String[] args) throws Exception {
    byte[] data = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };

    SecretKey key64 = new SecretKeySpec(
        new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 }, "Blowfish");

    Cipher c = Cipher.getInstance("Blowfish/ECB/NoPadding");

    c.init(Cipher.ENCRYPT_MODE, key64);
    c.doFinal(data);

  }
}