import java.io.FileInputStream;
import java.security.cert.CertStore;
import java.security.cert.CertStoreParameters;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
  public static void main(String args[]) throws Exception {

    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    List mylist = new ArrayList();
    for (int i = 0; i < args.length; i++) {
      FileInputStream in = new FileInputStream(args[i]);
      Certificate c = cf.generateCertificate(in);
      mylist.add(c);
    }
    CertStoreParameters cparam = new CollectionCertStoreParameters(mylist);
    CertStore cs = CertStore.getInstance("Collection", cparam);
    System.out.println(cs.getCertStoreParameters());
    System.out.println(cs.getProvider());
    System.out.println(cs.getType());

  }
}