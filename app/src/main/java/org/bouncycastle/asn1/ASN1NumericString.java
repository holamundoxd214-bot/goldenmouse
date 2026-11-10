package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1NumericString extends ASN1Primitive implements ASN1String {
    class org.bouncycastle.asn1.ASN1NumericString$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1NumericString$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1NumericString.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final byte[] contents;

    static {
        ASN1NumericString.TYPE = new org.bouncycastle.asn1.ASN1NumericString$1(ASN1NumericString.class, 18);
    }

    ASN1NumericString(String arg1, boolean arg2) {
        super();
        if(arg2) {
            if(ASN1NumericString.isNumericString(arg1)) {
            }
            else {
                throw new IllegalArgumentException("string contains illegal characters");
            }
        }

        this.contents = Strings.toByteArray(arg1);
    }

    ASN1NumericString(byte[] arg1, boolean arg2) {
        super();
        if(arg2) {
            arg1 = Arrays.clone(arg1);
        }

        this.contents = arg1;
    }

    final boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1NumericString)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1NumericString)arg2).contents);
    }

    static ASN1NumericString createPrimitive(byte[] arg2) {
        return new DERNumericString(arg2, false);
    }

    final void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 18, this.contents);
    }

    final boolean encodeConstructed() {
        return 0;
    }

    final int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public static ASN1NumericString getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1NumericString)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1NumericString)) {
                        return ((ASN1NumericString)v0);
                    }
                }

                if((arg3 instanceof byte[])) {
                    try {
                        return ASN1NumericString.TYPE.fromByteArray(((byte[])arg3));
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

    public static ASN1NumericString getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1NumericString.TYPE.getContextTagged(arg1, arg2);
    }

    public final byte[] getOctets() {
        return Arrays.clone(this.contents);
    }

    public final String getString() {
        return Strings.fromByteArray(this.contents);
    }

    public static ASN1NumericString getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1NumericString.TYPE.getTagged(arg1, arg2);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public static boolean isNumericString(String arg5) {
        int v0;
        for(v0 = arg5.length() - 1; true; --v0) {
            if(v0 < 0) {
                return 1;
            }

            int v2 = arg5.charAt(v0);
            if(v2 > 0x7F) {
                return 0;
            }

            if((0x30 > v2 || v2 > 57) && v2 != 0x20) {
                return 0;
            }
        }

        return 0;
    }

    static boolean isNumericString(byte[] arg4) {
        int v1;
        for(v1 = 0; v1 < arg4.length; ++v1) {
            int v2 = arg4[v1];
            if(v2 != 0x20) {
                switch(v2) {
                    case 48: 
                    case 49: 
                    case 50: 
                    case 51: 
                    case 52: 
                    case 53: 
                    case 54: 
                    case 55: 
                    case 56: 
                    case 57: {
                        goto label_9;
                    }
                    default: {
                        return 0;
                    }
                }
            }

        label_9:
        }

        return 1;
    }

    public String toString() {
        return this.getString();
    }
}

