
package com.huuzkee.jstut.KTOOL;

import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class ktool01 {
  public static void main(String[] args) throws Exception {

    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

	char[] password = "some password".toCharArray();
	ks.load(null, password);

	// Store away the keystore.
	FileOutputStream fos = new FileOutputStream("newKeyStoreFileName");
	ks.store(fos, password);
	fos.close();


  }
}
