//36.6.2.Basic demonstration of precedence
//http://www.java2s.com/Tutorial/Java/0490__Security/Basicdemonstrationofprecedence.htm

package com.huuzkee.jstut.BOUNCY;

import javax.crypto.Cipher;

public class bouncy02 {
  public static void main(String[] args) throws Exception {
    Cipher cipher = Cipher.getInstance("Blowfish/ECB/NoPadding");

    System.out.println(cipher.getProvider());

    cipher = Cipher.getInstance("Blowfish/ECB/NoPadding", "BC");

    System.out.println(cipher.getProvider());
  }
}