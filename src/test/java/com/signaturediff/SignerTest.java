package com.signaturediff;

import org.junit.Test;

import java.security.PrivateKey;

import static org.junit.Assert.assertEquals;

/**
 * @author dvponomarev, 07.11.2018
 */
public class SignerTest {

    @Test
    public void test() throws Exception {
        final PrivateKey privateKey = Signer.readPrivateKey("src/test/resources/private_pkcs8.pem");
        final String     signature  = Signer.sign(privateKey, "message1");
        System.out.println(signature);
        assertEquals(
                //oracle jdk 1.8.0_192 value
                "J0oxOttxl/YqWp4FHyPAzm0/ZgXsLk9JYW3s3AgzLDZTj8owZeb4aER7CGSekBxPBwGnT2a6MhN+YAcML0DNGKRprsqWnuy0c27oSBDYQe6x/mhfFmtujNsS04wbeHLETho0yk2QWmfFj9ZsF3gaoabbDyXUn4POKKxgiac2QQ2iICAZOFfkwozXP4loKbYga1y8mgDwbj3rfVSdQQ/Pfnp5cz0ylWkOyT4946qcXB2uHGPU/Jr+LCblZNHpY2xMtqPgBFo4KkTLty6HKHRIFNRZEoJIDccbaaYXwzbbmrBX6sHS+ZAUJZd62PRx2XMZ4vRjNpjg4ASxNQGTYRMebA==",
                signature
        );
    }

}