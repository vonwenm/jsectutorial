//36.27.4.Make SHA Message with update methods
//http://www.java2s.com/Tutorial/Java/0490__Security/MakeSHAMessagewithupdatemethods.htm

package com.huuzkee.jstut.MDIG;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class mdig04 {
  public static byte[] makeDigest(String user, String password, long t1, double q1)
      throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA");
    md.update(user.getBytes());
    md.update(password.getBytes());
    //md.update(makeBytes(t1, q1));
    return md.digest();
  }

}