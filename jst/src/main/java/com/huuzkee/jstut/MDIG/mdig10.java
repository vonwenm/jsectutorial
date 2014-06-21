//36.27.10.Cryptography Streams: URLDigest
//http://www.java2s.com/Tutorial/Java/0490__Security/CryptographyStreamsURLDigest.htm

package com.huuzkee.jstut.MDIG;

import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Arrays;

public class mdig10 {

  public static void main(String[] args) throws Exception {
    URL u = new URL("http://www.google.com");
    InputStream in = u.openStream();
    MessageDigest sha = MessageDigest.getInstance("SHA");
    byte[] data = new byte[1024];
    int bytesRead = -1;
    while ((bytesRead = in.read(data)) >= 0) {
      sha.update(data, 0, bytesRead);
    }
    byte[] result = sha.digest();
    System.out.println(Arrays.toString(result));
    System.out.println(new BigInteger(result));
  }
}