//36.20.6.implements Key, PublicKey, PrivateKey
//http://www.java2s.com/Tutorial/Java/0490__Security/implementsKeyPublicKeyPrivateKey.htm

package com.huuzkee.jstut.KEY;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

public class key06 implements Key, PublicKey, PrivateKey {
  int rotValue;

  public String getAlgorithm() {
    return "XYZ";
  }

  public String getFormat() {
    return "XYZ Special Format";
  }

  public byte[] getEncoded() {
    byte b[] = new byte[4];
    b[3] = (byte) ((rotValue << 24) & 0xff);
    b[2] = (byte) ((rotValue << 16) & 0xff);
    b[1] = (byte) ((rotValue << 8) & 0xff);
    b[0] = (byte) ((rotValue << 0) & 0xff);
    return b;
  }
}