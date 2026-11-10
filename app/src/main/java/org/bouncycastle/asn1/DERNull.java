package org.bouncycastle.asn1;

import java.io.IOException;

public class DERNull extends ASN1Null {
    public static final DERNull INSTANCE;
    private static final byte[] zeroBytes;

    static {
        DERNull.INSTANCE = new DERNull();
        DERNull.zeroBytes = new byte[0];
    }

    private DERNull() {
        super();
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 5, DERNull.zeroBytes);
    }

    boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, 0);
    }
}

