import java.security.AlgorithmParameters;
import java.security.Security;

import javax.crypto.spec.IvParameterSpec;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.util.ASN1Dump;

public class MainClass {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    AlgorithmParameters params = AlgorithmParameters.getInstance("AES", "BC");
    IvParameterSpec ivSpec = new IvParameterSpec(new byte[16]);
    params.init(ivSpec);
    ASN1InputStream aIn = new ASN1InputStream(params.getEncoded("ASN.1"));

    System.out.println(ASN1Dump.dumpAsString(aIn.readObject()));
  }
}