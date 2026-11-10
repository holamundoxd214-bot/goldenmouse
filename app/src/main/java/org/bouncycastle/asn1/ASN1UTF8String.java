package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1UTF8String extends ASN1Primitive implements ASN1String {
    class org.bouncycastle.asn1.ASN1UTF8String$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1UTF8String$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1UTF8String.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final byte[] contents;

    static {
        ASN1UTF8String.TYPE = new org.bouncycastle.asn1.ASN1UTF8String$1(ASN1UTF8String.class, 12);
    }

    ASN1UTF8String(String arg2) {
        this(Strings.toUTF8ByteArray(arg2), false);
    }

    ASN1UTF8String(byte[] arg1, boolean arg2) {
        super();
        if(arg2) {
            arg1 = Arrays.clone(arg1);
        }

        this.contents = arg1;
    }

    final boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1UTF8String)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1UTF8String)arg2).contents);
    }

    static ASN1UTF8String createPrimitive(byte[] arg2) {
        return new DERUTF8String(arg2, false);
    }

    final void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 12, this.contents);
    }

    final boolean encodeConstructed() {
        return 0;
    }

    final int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public static ASN1UTF8String getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1UTF8String)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1UTF8String)) {
                        return ((ASN1UTF8String)v0);
                    }
                }

                if((arg3 instanceof byte[])) {
                    try {
                        return ASN1UTF8String.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(Exception v3) {
                        throw new IllegalArgumentException("encoding error in getInstance: " + v3.toString());
                    }
                }

                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1UTF8String getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1UTF8String.TYPE.getContextTagged(arg1, arg2);
    }

    public final String getString() {
        return Strings.fromUTF8ByteArray(this.contents);
    }

    public static ASN1UTF8String getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1UTF8String.TYPE.getTagged(arg1, arg2);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return this.getString();
    }
}

