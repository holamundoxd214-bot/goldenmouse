package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BERSequenceGenerator extends BERGenerator {
    public BERSequenceGenerator(OutputStream arg1) throws IOException {
        super(arg1);
        this.writeBERHeader(0x30);
    }

    public BERSequenceGenerator(OutputStream arg1, int arg2, boolean arg3) throws IOException {
        super(arg1, arg2, arg3);
        this.writeBERHeader(0x30);
    }

    public void addObject(ASN1Encodable arg1) throws IOException {
        arg1.toASN1Primitive().encodeTo(this._out);
    }

    public void addObject(ASN1Primitive arg1) throws IOException {
        arg1.encodeTo(this._out);
    }

    public void close() throws IOException {
        this.writeBEREnd();
    }
}

