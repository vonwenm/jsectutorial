//36.39.4.implements SecretKey
//http://www.java2s.com/Tutorial/Java/0490__Security/implementsSecretKey.htm

package com.huuzkee.jstut.SKEY;

import javax.crypto.SecretKey;

//public class XORKey implements SecretKey {
public class skey04 implements SecretKey {
  int rotValue;

  XORKey(int value) {
    rotValue = value;
  }

  public String getAlgorithm() {
    return "XOR";
  }

  public String getFormat() {
    return "XOR Special Format";
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