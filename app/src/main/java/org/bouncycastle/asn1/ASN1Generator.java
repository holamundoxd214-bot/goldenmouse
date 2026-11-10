package org.bouncycastle.asn1;

import java.io.OutputStream;

public abstract class ASN1Generator {
    protected OutputStream _out;

    public ASN1Generator(OutputStream arg1) {
        super();
        this._out = arg1;
    }

    public abstract OutputStream getRawOutputStream();
}

