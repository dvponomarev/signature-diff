package com.signaturediff;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * @author dvponomarev, 07.11.2018
 */
public class Signer {

    public static String sign(PrivateKey privateKey, String message) throws GeneralSecurityException {
        Signature sign = Signature.getInstance("SHA1withRSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.getEncoder().encode(sign.sign()), StandardCharsets.UTF_8);
    }

    public static PrivateKey readPrivateKey(String filename) throws GeneralSecurityException, IOException {
        String privateKeyPEM = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
        privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----", "");
        privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
        privateKeyPEM = privateKeyPEM.replace("\n", "");

        KeyFactory          kf           = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyPEM));
        return kf.generatePrivate(keySpecPKCS8);
    }

}
