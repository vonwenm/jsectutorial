//36.8.4.Importing a Certificate from a File
//http://www.java2s.com/Tutorial/Java/0490__Security/ImportingaCertificatefromaFile.htm

import java.io.File;
import java.io.FileInputStream;
import java.security.cert.CertificateFactory;

public class cfac04 {
  public static void main(String[] argv) throws Exception {

    FileInputStream is = new FileInputStream(new File("your.keystore"));

    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    java.security.cert.Certificate cert = cf.generateCertificate(is);
  }
}