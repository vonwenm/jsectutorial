//36.25.4.Generating a MAC from a text input using a random key.
//http://www.java2s.com/Tutorial/Java/0490__Security/GeneratingaMACfromatextinputusingarandomkey.htm

package com.huuzkee.jstut.MAC;

import javax.crypto.Mac;
   import javax.crypto.spec.SecretKeySpec;
   import java.security.SecureRandom;
   import sun.misc.*;

   public class mac04 {

     public static void main (String[] args) throws Exception {

       SecureRandom random = new SecureRandom();
       byte[] keyBytes = new byte[20];
       random.nextBytes(keyBytes);
       SecretKeySpec key = new SecretKeySpec(keyBytes, "HMACSHA1");

       System.out.println("Key:"+new
                           BASE64Encoder().encode(key.getEncoded()));

       Mac mac = Mac.getInstance("HmacSHA1");
       mac.init(key);

       mac.update("test".getBytes("UTF8"));
       byte[] result = mac.doFinal();

       System.out.println("MAC: "+new BASE64Encoder().encode(result));
     }
   }
