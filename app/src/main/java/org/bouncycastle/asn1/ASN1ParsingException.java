package org.bouncycastle.asn1;

public class ASN1ParsingException extends IllegalStateException {
    private Throwable cause;

    public ASN1ParsingException(String arg1, Throwable arg2) {
        super(arg1);
        this.cause = arg2;
    }

    public ASN1ParsingException(String arg1) {
        super(arg1);
    }

    public Throwable getCause() {
        return this.cause;
    }
}

