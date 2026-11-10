package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public abstract class ASN1Primitive extends ASN1Object {
    ASN1Primitive() {
        super();
    }

    abstract boolean asn1Equals(ASN1Primitive arg1);

    abstract void encode(ASN1OutputStream arg1, boolean arg2) throws IOException;

    abstract boolean encodeConstructed();

    public void encodeTo(OutputStream arg2) throws IOException {
        ASN1OutputStream v2 = ASN1OutputStream.create(arg2);
        v2.writePrimitive(this, true);
        v2.flushInternal();
    }

    public void encodeTo(OutputStream arg1, String arg2) throws IOException {
        ASN1OutputStream v1 = ASN1OutputStream.create(arg1, arg2);
        v1.writePrimitive(this, true);
        v1.flushInternal();
    }

    abstract int encodedLength(boolean arg1) throws IOException;

    public final boolean equals(ASN1Primitive arg1) {
        if(this != arg1) {
            if(this.asn1Equals(arg1)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean equals(Object arg3) {
        if(this == (((ASN1Primitive)arg3))) {
            return 1;
        }

        if(((arg3 instanceof ASN1Encodable)) && (this.asn1Equals(((ASN1Encodable)arg3).toASN1Primitive()))) {
            return 1;
        }

        return 0;
    }

    public final boolean equals(ASN1Encodable arg1) {
        if(this != (((ASN1Primitive)arg1)) && (arg1 == null || !this.asn1Equals(arg1.toASN1Primitive()))) {
            return 0;
        }

        return 1;
    }

    public static ASN1Primitive fromByteArray(byte[] arg1) throws IOException {
        ASN1InputStream v0 = new ASN1InputStream(arg1);
        try {
            ASN1Primitive v1 = v0.readObject();
            if(v0.available() == 0) {
                return v1;
            }

            throw new IOException("Extra data detected in stream");
        }
        catch(ClassCastException ) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public abstract int hashCode();

    public final ASN1Primitive toASN1Primitive() {
        return this;
    }

    ASN1Primitive toDERObject() {
        return this;
    }

    ASN1Primitive toDLObject() {
        return this;
    }
}

