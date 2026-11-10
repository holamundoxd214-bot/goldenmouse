package org.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Absent extends ASN1Primitive {
    public static final ASN1Absent INSTANCE;

    static {
        ASN1Absent.INSTANCE = new ASN1Absent();
    }

    private ASN1Absent() {
        super();
    }

    boolean asn1Equals(ASN1Primitive arg1) {
        if((((ASN1Absent)arg1)) == this) {
            return 1;
        }

        return 0;
    }

    void encode(ASN1OutputStream arg1, boolean arg2) throws IOException {
    }

    boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) throws IOException {
        return 0;
    }

    public int hashCode() {
        return 0;
    }
}

