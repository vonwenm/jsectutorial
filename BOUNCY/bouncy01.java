//36.6.1.Basic class to confirm the Bouncy Castle provider is installed.
//http://www.java2s.com/Tutorial/Java/0490__Security/BasicclasstoconfirmtheBouncyCastleproviderisinstalled.htm

import java.security.Security;

public class bouncy01 {
  public static void main(String[] args) {
    String providerName = "BC";

    if (Security.getProvider(providerName) == null) {
      System.out.println(providerName + " provider not installed");
    } else {
      System.out.println(providerName + " is installed.");
    }
  }
}