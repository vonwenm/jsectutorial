import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;

public class Main {
  public static void main(String[] argv) throws Exception {
    FileInputStream is = new FileInputStream("your.keystore");

    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
    keystore.load(is, "my-keystore-password".toCharArray());

    String alias = "myalias";
    Certificate cert = keystore.getCertificate(alias);

    CertificateFactory certFact = CertificateFactory.getInstance("X.509");
    CertPath path = certFact.generateCertPath(Arrays.asList(new Certificate[]{cert}));

  }
}
