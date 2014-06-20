//36.6.2.Basic demonstration of precedence
//http://www.java2s.com/Tutorial/Java/0490__Security/Basicdemonstrationofprecedence.htm

import javax.crypto.Cipher;

public class MainClass {
  public static void main(String[] args) throws Exception {
    Cipher cipher = Cipher.getInstance("Blowfish/ECB/NoPadding");

    System.out.println(cipher.getProvider());

    cipher = Cipher.getInstance("Blowfish/ECB/NoPadding", "BC");

    System.out.println(cipher.getProvider());
  }
}