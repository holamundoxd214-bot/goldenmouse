package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1IA5String extends ASN1Primitive implements ASN1String {
    class org.bouncycastle.asn1.ASN1IA5String$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1IA5String$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1IA5String.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final byte[] contents;

    static {
        ASN1IA5String.TYPE = new org.bouncycastle.asn1.ASN1IA5String$1(ASN1IA5String.class, 22);
    }

    ASN1IA5String(String arg1, boolean arg2) {
        super();
        if(arg1 != null) {
            if(arg2) {
                if(ASN1IA5String.isIA5String(arg1)) {
                }
                else {
                    throw new IllegalArgumentException("\'string\' contains illegal characters");
                }
            }

            this.contents = Strings.toByteArray(arg1);
            return;
        }

        throw new NullPointerException("\'string\' cannot be null");
    }

    ASN1IA5String(byte[] arg1, boolean arg2) {
        super();
        if(arg2) {
            arg1 = Arrays.clone(arg1);
        }

        this.contents = arg1;
    }

    final boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1IA5String)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1IA5String)arg2).contents);
    }

    static ASN1IA5String createPrimitive(byte[] arg2) {
        return new DERIA5String(arg2, false);
    }

    final void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 22, this.contents);
    }

    final boolean encodeConstructed() {
        return 0;
    }

    final int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public static ASN1IA5String getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1IA5String)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1IA5String)) {
                        return ((ASN1IA5String)v0);
                    }
                }

                if((arg3 instanceof byte[])) {
                    try {
                        return ASN1IA5String.TYPE.fromByteArray(((byte[])arg3));
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

    public static ASN1IA5String getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1IA5String.TYPE.getContextTagged(arg1, arg2);
    }

    public final byte[] getOctets() {
        return Arrays.clone(this.contents);
    }

    public final String getString() {
        return Strings.fromByteArray(this.contents);
    }

    public static ASN1IA5String getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1IA5String.TYPE.getTagged(arg1, arg2);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public static boolean isIA5String(String arg4) {
        int v0;
        for(v0 = arg4.length() - 1; v0 >= 0; --v0) {
            if(arg4.charAt(v0) > 0x7F) {
                return 0;
            }
        }

        return 1;
    }

    public String toString() {
        return this.getString();
    }
}

