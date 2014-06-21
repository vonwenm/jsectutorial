//36.22.1.Creating a Certification Request
//http://www.java2s.com/Tutorial/Java/0490__Security/CreatingaCertificationRequest.htm

package com.huuzkee.jstut.KPG;

import java.io.OutputStreamWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.jce.PKCS10CertificationRequest;
import org.bouncycastle.openssl.PEMWriter;

public class kpg01 {
  public static PKCS10CertificationRequest generateRequest(KeyPair pair) throws Exception {
    return new PKCS10CertificationRequest("SHA256withRSA", new X500Principal(
        "CN=Requested Test Certificate"), pair.getPublic(), null, pair.getPrivate());
  }

  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA", "BC");

    kpGen.initialize(1024, new SecureRandom());
    KeyPair pair = kpGen.generateKeyPair();
    PKCS10CertificationRequest request = generateRequest(pair);
    PEMWriter pemWrt = new PEMWriter(new OutputStreamWriter(System.out));
    pemWrt.writeObject(request);
    pemWrt.close();
  }
}
/*-----BEGIN CERTIFICATE REQUEST-----
MIIBYjCBzAIBADAlMSMwIQYDVQQDExpSZXF1ZXN0ZWQgVGVzdCBDZXJ0aWZpY2F0
ZTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAnIGtHELGBMJe9LUTDfMktFOG
2mlu9QKuCqpOB3lwsOg1AK4MkD+Bez6KVSOASvbjWCqqdmHAJsGWcpUpjJqm4tfg
r9KGSjDN4LJzR6cd0RZTHWzgud9t7peUBlowVZVJen0962wx6AeYNr8RG9jbcBPe
Ma4mbA3EeWvmZCo4aQcCAwEAATANBgkqhkiG9w0BAQsFAAOBgQCPRr5QBLH0Zfz5
j+MUO7NN+vZMu0bPxQiiZEAWiSbJ63Zp6UK6TV8SYTxjmSGS27KILY+oSHR7lSz0
XNEkLSCuJRRdtAF0GSz7MmSWFt8mwMr0i0ntbSWDVpZShH3pRi/8E+J3KnqT+Cs5
oVhUVFYBLncrinDPgDzVR98CapCI6g==
-----END CERTIFICATE REQUEST-----*/