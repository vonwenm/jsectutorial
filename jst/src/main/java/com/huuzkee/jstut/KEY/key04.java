//36.20.4.Use DSAKey
//http://www.java2s.com/Tutorial/Java/0490__Security/UseDSAKey.htm

package com.huuzkee.jstut.KEY;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.DSAPublicKeySpec;

public class key04 {
  public static void main(String args[]) throws Exception {
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
    SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
    random.setSeed(101L);
    keyGen.initialize(1024, random);
    KeyPair keypair = keyGen.generateKeyPair();

    KeyFactory kfactory = KeyFactory.getInstance("DSA");

    DSAPublicKeySpec kspec = (DSAPublicKeySpec) kfactory.getKeySpec(keypair.getPublic(),
        DSAPublicKeySpec.class);

    System.out.println(keypair.getPublic());
    FileOutputStream fos = new FileOutputStream("publicKeys");
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.writeObject(kspec.getY());
    oos.writeObject(kspec.getP());
    oos.writeObject(kspec.getQ());
    oos.writeObject(kspec.getG());

    FileInputStream fin = new FileInputStream("publicKeys");
    ObjectInputStream ois = new ObjectInputStream(fin);

    BigInteger Y = (BigInteger) ois.readObject();
    BigInteger P = (BigInteger) ois.readObject();
    BigInteger Q = (BigInteger) ois.readObject();
    BigInteger G = (BigInteger) ois.readObject();

    DSAPublicKeySpec keyspec = new DSAPublicKeySpec(Y, P, Q, G);
    PublicKey pkey = kfactory.generatePublic(keyspec);
    System.out.println(pkey);
  }
}
/*Sun DSA Public Key
    Parameters:
    p:
    fd7f5381 1d751229 52df4a9c 2eece4e7 f611b752 3cef4400 c31e3f80 b6512669
    455d4022 51fb593d 8d58fabf c5f5ba30 f6cb9b55 6cd7813b 801d346f f26660b7
    6b9950a5 a49f9fe8 047b1022 c24fbba9 d7feb7c6 1bf83b57 e7c6a8a6 150f04fb
    83f6d3c5 1ec30235 54135a16 9132f675 f3ae2b61 d72aeff2 2203199d d14801c7
    q:
    9760508f 15230bcc b292b982 a2eb840b f0581cf5
    g:
    f7e1a085 d69b3dde cbbcab5c 36b857b9 7994afbb fa3aea82 f9574c0b 3d078267
    5159578e bad4594f e6710710 8180b449 167123e8 4c281613 b7cf0932 8cc8a6e1
    3c167a8b 547c8d28 e0a3ae1e 2bb3a675 916ea37f 0bfa2135 62f1fb62 7a01243b
    cca4f1be a8519089 a883dfe1 5ae59f06 928b665e 807b5525 64014c3b fecf492a

  y:
    ab67aa43 9e8ea5c8 904b1afe 89ae185a 4ef595cf ca9b9114 f05373dc 193cddd3
    baefb0f8 8bd858ea d78632c2 6481c9e0 a4f56878 8f4b0f10 d505ee57 4b1c7d5d
    1196ddf0 1003578f 16272cb6 94f92796 57efd826 50287f9d b6f7e512 75fa4316
    5961aef6 ba663ab8 81c57606 554e4fb6 830b9a7b ce32d5a3 a708d09b 3b6aa8ff

Sun DSA Public Key
    Parameters:
    p:
    fd7f5381 1d751229 52df4a9c 2eece4e7 f611b752 3cef4400 c31e3f80 b6512669
    455d4022 51fb593d 8d58fabf c5f5ba30 f6cb9b55 6cd7813b 801d346f f26660b7
    6b9950a5 a49f9fe8 047b1022 c24fbba9 d7feb7c6 1bf83b57 e7c6a8a6 150f04fb
    83f6d3c5 1ec30235 54135a16 9132f675 f3ae2b61 d72aeff2 2203199d d14801c7
    q:
    9760508f 15230bcc b292b982 a2eb840b f0581cf5
    g:
    f7e1a085 d69b3dde cbbcab5c 36b857b9 7994afbb fa3aea82 f9574c0b 3d078267
    5159578e bad4594f e6710710 8180b449 167123e8 4c281613 b7cf0932 8cc8a6e1
    3c167a8b 547c8d28 e0a3ae1e 2bb3a675 916ea37f 0bfa2135 62f1fb62 7a01243b
    cca4f1be a8519089 a883dfe1 5ae59f06 928b665e 807b5525 64014c3b fecf492a

  y:
    ab67aa43 9e8ea5c8 904b1afe 89ae185a 4ef595cf ca9b9114 f05373dc 193cddd3
    baefb0f8 8bd858ea d78632c2 6481c9e0 a4f56878 8f4b0f10 d505ee57 4b1c7d5d
    1196ddf0 1003578f 16272cb6 94f92796 57efd826 50287f9d b6f7e512 75fa4316
    5961aef6 ba663ab8 81c57606 554e4fb6 830b9a7b ce32d5a3 a708d09b 3b6aa8ff

*/