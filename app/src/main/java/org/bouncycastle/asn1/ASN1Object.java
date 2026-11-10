package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Encodable;

public abstract class ASN1Object implements ASN1Encodable, Encodable {
    public ASN1Object() {
        super();
    }

    public void encodeTo(OutputStream arg1) throws IOException {
        this.toASN1Primitive().encodeTo(arg1);
    }

    public void encodeTo(OutputStream arg1, String arg2) throws IOException {
        this.toASN1Primitive().encodeTo(arg1, arg2);
    }

    public boolean equals(Object arg2) {
        if(this == (((ASN1Object)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof ASN1Encodable)) {
            return 0;
        }

        return this.toASN1Primitive().equals(((ASN1Encodable)arg2).toASN1Primitive());
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        this.toASN1Primitive().encodeTo(((OutputStream)v0));
        return v0.toByteArray();
    }

    public byte[] getEncoded(String arg2) throws IOException {
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        this.toASN1Primitive().encodeTo(((OutputStream)v0), arg2);
        return v0.toByteArray();
    }

    protected static boolean hasEncodedTagValue(Object arg2, int arg3) {
        if(((arg2 instanceof byte[])) && arg2[0] == arg3) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.toASN1Primitive().hashCode();
    }

    public abstract ASN1Primitive toASN1Primitive();
}

