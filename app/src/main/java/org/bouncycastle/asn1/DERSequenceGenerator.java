package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DERSequenceGenerator extends DERGenerator {
    private final ByteArrayOutputStream _bOut;

    public DERSequenceGenerator(OutputStream arg1) throws IOException {
        super(arg1);
        this._bOut = new ByteArrayOutputStream();
    }

    public DERSequenceGenerator(OutputStream arg1, int arg2, boolean arg3) throws IOException {
        super(arg1, arg2, arg3);
        this._bOut = new ByteArrayOutputStream();
    }

    public void addObject(ASN1Encodable arg2) throws IOException {
        arg2.toASN1Primitive().encodeTo(this._bOut, "DER");
    }

    public void addObject(ASN1Primitive arg2) throws IOException {
        arg2.encodeTo(this._bOut, "DER");
    }

    public void close() throws IOException {
        this.writeDEREncoded(0x30, this._bOut.toByteArray());
    }

    public OutputStream getRawOutputStream() {
        return this._bOut;
    }
}

