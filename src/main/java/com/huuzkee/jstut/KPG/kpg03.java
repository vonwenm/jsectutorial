//36.22.3.Creating a Certificate from a Certification Request
//http://www.java2s.com/Tutorial/Java/0490__Security/CreatingaCertificatefromaCertificationRequest.htm

package com.huuzkee.jstut.KPG;

/*
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.jce.PKCS10CertificationRequest;
import org.bouncycastle.openssl.PEMWriter;
import org.bouncycastle.x509.X509V1CertificateGenerator;
import org.bouncycastle.x509.X509V3CertificateGenerator;
import org.bouncycastle.x509.extension.AuthorityKeyIdentifierStructure;
import org.bouncycastle.x509.extension.SubjectKeyIdentifierStructure;

public class kpg03 {
  public static KeyPair generateRSAKeyPair() throws Exception {
    KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA", "BC");
    kpGen.initialize(1024, new SecureRandom());
    return kpGen.generateKeyPair();
  }

  public static PKCS10CertificationRequest generateRequest(KeyPair pair) throws Exception {
    return new PKCS10CertificationRequest("SHA256withRSA", new X500Principal(
        "CN=Requested Test Certificate"), pair.getPublic(), null, pair.getPrivate());
  }

  public static X509Certificate generateV1Certificate(KeyPair pair) throws InvalidKeyException,
      NoSuchProviderException, SignatureException {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    X509V1CertificateGenerator certGen = new X509V1CertificateGenerator();

    certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
    certGen.setIssuerDN(new X500Principal("CN=Test Certificate"));
    certGen.setNotBefore(new Date(System.currentTimeMillis() - 10000));
    certGen.setNotAfter(new Date(System.currentTimeMillis() + 10000));
    certGen.setSubjectDN(new X500Principal("CN=Test Certificate"));
    certGen.setPublicKey(pair.getPublic());
    certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

    return certGen.generateX509Certificate(pair.getPrivate(), "BC");
  }

  public static X509Certificate[] buildChain() throws Exception {
    KeyPair pair = generateRSAKeyPair();
    PKCS10CertificationRequest request = generateRequest(pair);

    KeyPair rootPair = generateRSAKeyPair();
    X509Certificate rootCert = generateV1Certificate(rootPair);

    X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();

    certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
    certGen.setIssuerDN(rootCert.getSubjectX500Principal());
    certGen.setNotBefore(new Date(System.currentTimeMillis()));
    certGen.setNotAfter(new Date(System.currentTimeMillis() + 10000));
    certGen.setSubjectDN(request.getCertificationRequestInfo().getSubject());
    certGen.setPublicKey(request.getPublicKey("BC"));
    certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

    certGen.addExtension(X509Extensions.AuthorityKeyIdentifier, false,
        new AuthorityKeyIdentifierStructure(rootCert));

    certGen.addExtension(X509Extensions.SubjectKeyIdentifier,

    false, new SubjectKeyIdentifierStructure(request.getPublicKey("BC")));

    certGen.addExtension(X509Extensions.BasicConstraints, true, new BasicConstraints(false));

    certGen.addExtension(X509Extensions.KeyUsage, true, new KeyUsage(KeyUsage.digitalSignature
        | KeyUsage.keyEncipherment));

    certGen.addExtension(X509Extensions.ExtendedKeyUsage, true, new ExtendedKeyUsage(
        KeyPurposeId.id_kp_serverAuth));

    ASN1Set attributes = request.getCertificationRequestInfo().getAttributes();

    for (int i = 0; i != attributes.size(); i++) {
      Attribute attr = Attribute.getInstance(attributes.getObjectAt(i));

      if (attr.getAttrType().equals(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest)) {
        X509Extensions extensions = X509Extensions.getInstance(attr.getAttrValues().getObjectAt(0));

        Enumeration e = extensions.oids();
        while (e.hasMoreElements()) {
          DERObjectIdentifier oid = (DERObjectIdentifier) e.nextElement();
          X509Extension ext = extensions.getExtension(oid);

          certGen.addExtension(oid, ext.isCritical(), ext.getValue().getOctets());
        }
      }
    }
    X509Certificate issuedCert = certGen.generateX509Certificate(rootPair.getPrivate());

    return new X509Certificate[] { issuedCert, rootCert };
  }

  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    X509Certificate[] chain = buildChain();

    PEMWriter pemWrt = new PEMWriter(new OutputStreamWriter(System.out));

    pemWrt.writeObject(chain[0]);
    pemWrt.writeObject(chain[1]);

    pemWrt.close();
  }
}
*/