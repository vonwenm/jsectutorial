//36.22.2.Adding Extensions to a Certification Request
//http://www.java2s.com/Tutorial/Java/0490__Security/AddingExtensionstoaCertificationRequest.htm

package com.huuzkee.jstut.KPG;

import java.io.OutputStreamWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Vector;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.jce.PKCS10CertificationRequest;
import org.bouncycastle.openssl.PEMWriter;

public class kpg02 {
  public static PKCS10CertificationRequest generateRequest(KeyPair pair) throws Exception {
    GeneralNames subjectAltName = new GeneralNames(new GeneralName(GeneralName.rfc822Name,
        "test@test.test"));
    Vector oids = new Vector();
    Vector values = new Vector();

    oids.add(X509Extensions.SubjectAlternativeName);
    values.add(new X509Extension(false, new DEROctetString(subjectAltName)));

    X509Extensions extensions = new X509Extensions(oids, values);

    Attribute attribute = new Attribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest,
        new DERSet(extensions));

    return new PKCS10CertificationRequest("SHA256withRSA", new X500Principal(
        "CN=Requested Test Certificate"), pair.getPublic(), new DERSet(attribute), pair
        .getPrivate());
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
MIIBkDCB+gIBADAlMSMwIQYDVQQDExpSZXF1ZXN0ZWQgVGVzdCBDZXJ0aWZpY2F0
ZTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEArbtf7LlFX+hg/kYX0a6dLmLW
UHHpiHH6UW4CF0X240kAsThW8xpFe+rHMDW0NlpHCotQ6NVAJqNm+y6FInvu0+fO
4tq4GKJVw0ewEL//IsD+1lBWBDSmeUq3P2ONRDft7gyW5R3NAja3ihoTJaSd3SWZ
GBdhFZdx75WsomPMmtkCAwEAAaAsMCoGCSqGSIb3DQEJDjEdMBswGQYDVR0RBBIw
EIEOdGVzdEB0ZXN0LnRlc3QwDQYJKoZIhvcNAQELBQADgYEAbDa0nbtl57NDYyc8
yxuXLrDNrcG9qaDXR9bcWsvk6dR9zg1aTr9KtBT8iKoS41xW25ndRN/xH0ft2oWN
UzD4ADDUu48Jtc9lk52ei44w4u2pQk4BhY1lgO8eZY9y4SCuT6C28mqxNZ4Jq8lb
wQzxBmdTgd8873ebGdi5ZdpIlMI=
-----END CERTIFICATE REQUEST-----
*/
