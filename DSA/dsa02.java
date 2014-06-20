//36.16.2.Signed Object
//http://www.java2s.com/Tutorial/Java/0490__Security/SignedObject.htm

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.SignedObject;
import java.util.Vector;

public class dsa02 {
  public static void main(String[] args) throws Exception {
    String alg = "DSA";
    KeyPairGenerator kg = KeyPairGenerator.getInstance(alg);
    KeyPair keyPair = kg.genKeyPair();

    Vector v = new Vector();
    v.add("This is a test!");
    Signature sign = Signature.getInstance(alg);
    SignedObject so = new SignedObject(v, keyPair.getPrivate(), sign);
    System.out.println(so.verify(keyPair.getPublic(), sign));
  }
}
