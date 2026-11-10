package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1T61String extends ASN1Primitive implements ASN1String {
    class org.bouncycastle.asn1.ASN1T61String$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1T61String$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1T61String.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final byte[] contents;

    static {
        ASN1T61String.TYPE = new org.bouncycastle.asn1.ASN1T61String$1(ASN1T61String.class, 20);
    }

    ASN1T61String(String arg1) {
        super();
        this.contents = Strings.toByteArray(arg1);
    }

    ASN1T61String(byte[] arg1, boolean arg2) {
        super();
        if(arg2) {
            arg1 = Arrays.clone(arg1);
        }

        this.contents = arg1;
    }

    final boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1T61String)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1T61String)arg2).contents);
    }

    static ASN1T61String createPrimitive(byte[] arg2) {
        return new DERT61String(arg2, false);
    }

    final void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 20, this.contents);
    }

    final boolean encodeConstructed() {
        return 0;
    }

    final int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public static ASN1T61String getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1T61String)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1T61String)) {
                        return ((ASN1T61String)v0);
                    }
                }

                if((arg3 instanceof byte[])) {
                    try {
                        return ASN1T61String.TYPE.fromByteArray(((byte[])arg3));
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

    public static ASN1T61String getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1T61String.TYPE.getContextTagged(arg1, arg2);
    }

    public final byte[] getOctets() {
        return Arrays.clone(this.contents);
    }

    public final String getString() {
        return Strings.fromByteArray(this.contents);
    }

    public static ASN1T61String getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1T61String.TYPE.getTagged(arg1, arg2);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return this.getString();
    }
}

