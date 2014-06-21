//36.27.3.Make SHA Message
//http://www.java2s.com/Tutorial/Java/0490__Security/MakeSHAMessage.htm

package com.huuzkee.jstut.MDIG;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class mdig03 {
  public static byte[] makeDigest(byte[] mush, long t2, double q2) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA");
    md.update(mush);
    //md.update(makeBytes(t2, q2));
    return md.digest();
  }

}