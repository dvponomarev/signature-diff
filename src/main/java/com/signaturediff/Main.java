package com.signaturediff;

import java.security.PrivateKey;
import java.util.Objects;

/**
 * @author dvponomarev, 07.11.2018
 */
public class Main {

    //oracle jdk 1.8.0_192 value
    private static final String SIGNATURE = "J0oxOttxl/YqWp4FHyPAzm0/ZgXsLk9JYW3s3AgzLDZTj8owZeb4aER7CGSekBxPBwGnT2a6MhN+YAcML0DNGKRprsqWnuy0c27oSBDYQe6x/mhfFmtujNsS04wbeHLETho0yk2QWmfFj9ZsF3gaoabbDyXUn4POKKxgiac2QQ2iICAZOFfkwozXP4loKbYga1y8mgDwbj3rfVSdQQ/Pfnp5cz0ylWkOyT4946qcXB2uHGPU/Jr+LCblZNHpY2xMtqPgBFo4KkTLty6HKHRIFNRZEoJIDccbaaYXwzbbmrBX6sHS+ZAUJZd62PRx2XMZ4vRjNpjg4ASxNQGTYRMebA==";

    public static void main(String[] args) throws Exception {
        final PrivateKey privateKey = Signer.readPrivateKey("src/main/resources/private_pkcs8.pem");
        final String     signature  = Signer.sign(privateKey, "message1");
        System.out.println(signature);
        System.out.println();
        System.out.println(Objects.equals(SIGNATURE, signature) ? "SUCCESS" : "FAIL");
    }

}
