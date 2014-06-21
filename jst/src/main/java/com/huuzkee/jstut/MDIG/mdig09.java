//36.27.9.Create an encrypted string for password
//http://www.java2s.com/Tutorial/Java/0490__Security/Createanencryptedstringforpassword.htm

package com.huuzkee.jstut.MDIG;

import java.security.MessageDigest;

public class mdig09 {
  public static void main(String[] args) throws Exception {
    String password = "secret";
    String algorithm = "SHA";

    byte[] plainText = password.getBytes();

    MessageDigest md = MessageDigest.getInstance(algorithm);

    md.reset();
    md.update(plainText);
    byte[] encodedPassword = md.digest();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < encodedPassword.length; i++) {
      if ((encodedPassword[i] & 0xff) < 0x10) {
        sb.append("0");
      }
      sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
    }
    System.out.println("Plain    : " + password);
    System.out.println("Encrypted: " + sb.toString());
  }
}