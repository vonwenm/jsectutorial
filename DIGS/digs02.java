//36.15.2.Cryptography Streams: True Mirror
//http://www.java2s.com/Tutorial/Java/0490__Security/CryptographyStreamsTrueMirror.htm

import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;

public class Main {
  public static void main(String[] args) throws Exception {
    URL source = new URL("http://www.a.com");
    URL mirror = new URL("http://www.b.com");
    byte[] sourceDigest = getDigestFromURL(source);
    byte[] mirrorDigest = getDigestFromURL(mirror);
    if (MessageDigest.isEqual(sourceDigest, mirrorDigest)) {
      System.out.println(mirror + " is up to date");
    } else {
      System.out.println(mirror + " needs to be updated");
    }
  }

  public static byte[] getDigestFromURL(URL u) throws Exception {
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    InputStream in = u.openStream();
    byte[] data = new byte[1024];
    int bytesRead = -1;
    while ((bytesRead = in.read(data)) >= 0) {
      md5.update(data, 0, bytesRead);
    }
    return md5.digest();
  }
}