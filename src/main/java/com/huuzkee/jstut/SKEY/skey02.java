//36.39.2.Create a 192 bit secret key from raw bytes
//http://www.java2s.com/Tutorial/Java/0490__Security/Createa192bitsecretkeyfromrawbytes.htm

package com.huuzkee.jstut.SKEY;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class skey02 {
  public static void main(String[] args) throws Exception {
    byte[] data = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };

    Cipher c = Cipher.getInstance("Blowfish/ECB/NoPadding");

    SecretKey key192 = new SecretKeySpec(new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06,
        0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15,
        0x16, 0x17 }, "Blowfish");

    c.init(Cipher.ENCRYPT_MODE, key192);
    c.doFinal(data);
  }
}