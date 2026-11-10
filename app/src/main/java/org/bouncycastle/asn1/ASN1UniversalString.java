package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public abstract class ASN1UniversalString extends ASN1Primitive implements ASN1String {
    class org.bouncycastle.asn1.ASN1UniversalString$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1UniversalString$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1UniversalString.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final byte[] contents;
    private static final char[] table;

    static {
        ASN1UniversalString.TYPE = new org.bouncycastle.asn1.ASN1UniversalString$1(ASN1UniversalString.class, 28);
        ASN1UniversalString.table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    ASN1UniversalString(byte[] arg1, boolean arg2) {
        super();
        if(arg2) {
            arg1 = Arrays.clone(arg1);
        }

        this.contents = arg1;
    }

    final boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1UniversalString)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1UniversalString)arg2).contents);
    }

    static ASN1UniversalString createPrimitive(byte[] arg2) {
        return new DERUniversalString(arg2, false);
    }

    final void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 28, this.contents);
    }

    final boolean encodeConstructed() {
        return 0;
    }

    private static void encodeHexByte(StringBuilder arg2, int arg3) {
        char[] v0 = ASN1UniversalString.table;
        arg2.append(v0[arg3 >>> 4 & 15]);
        arg2.append(v0[arg3 & 15]);
    }

    private static void encodeHexDL(StringBuilder arg6, int arg7) {
        int v4;
        int v0 = 0x80;
        if(arg7 < v0) {
            ASN1UniversalString.encodeHexByte(arg6, arg7);
            return;
        }

        int v1 = 5;
        byte[] v2 = new byte[v1];
        int v3;
        for(v3 = v1; true; v3 = v4) {
            v4 = v3 - 1;
            v2[v4] = ((byte)arg7);
            arg7 >>>= 8;
            if(arg7 == 0) {
                break;
            }
        }

        v3 += -2;
        v2[v3] = ((byte)(5 - v4 | v0));
        while(true) {
            arg7 = v3 + 1;
            ASN1UniversalString.encodeHexByte(arg6, v2[v3]);
            if(arg7 >= v1) {
                return;
            }

            v3 = arg7;
        }
    }

    final int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public static ASN1UniversalString getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1UniversalString)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1UniversalString)) {
                        return ((ASN1UniversalString)v0);
                    }
                }

                if((arg3 instanceof byte[])) {
                    try {
                        return ASN1UniversalString.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(Exception v3) {
                        throw new IllegalArgumentException("encoding error getInstance: " + v3.toString());
                    }
                }

                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1UniversalString getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1UniversalString.TYPE.getContextTagged(arg1, arg2);
    }

    public final byte[] getOctets() {
        return Arrays.clone(this.contents);
    }

    public final String getString() {
        int v0 = this.contents.length;
        StringBuilder v1 = new StringBuilder((ASN1OutputStream.getLengthOfDL(v0) + v0) * 2 + 3);
        v1.append("#1C");
        ASN1UniversalString.encodeHexDL(v1, v0);
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            ASN1UniversalString.encodeHexByte(v1, this.contents[v2]);
        }

        return v1.toString();
    }

    public static ASN1UniversalString getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1UniversalString.TYPE.getTagged(arg1, arg2);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return this.getString();
    }
}

