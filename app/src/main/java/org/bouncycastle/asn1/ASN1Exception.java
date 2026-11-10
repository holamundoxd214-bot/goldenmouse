package org.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Exception extends IOException {
    private Throwable cause;

    ASN1Exception(String arg1) {
        super(arg1);
    }

    ASN1Exception(String arg1, Throwable arg2) {
        super(arg1);
        this.cause = arg2;
    }

    public Throwable getCause() {
        return this.cause;
    }
}

