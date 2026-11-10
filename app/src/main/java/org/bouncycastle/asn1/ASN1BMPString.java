package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public abstract class ASN1BMPString extends ASN1Primitive implements ASN1String {
    class org.bouncycastle.asn1.ASN1BMPString$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1BMPString$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1BMPString.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final char[] string;

    static {
        ASN1BMPString.TYPE = new org.bouncycastle.asn1.ASN1BMPString$1(ASN1BMPString.class, 30);
    }

    ASN1BMPString(String arg1) {
        super();
        if(arg1 != null) {
            this.string = arg1.toCharArray();
            return;
        }

        throw new NullPointerException("\'string\' cannot be null");
    }

    ASN1BMPString(byte[] arg6) {
        super();
        if(arg6 != null) {
            int v0 = arg6.length;
            if((v0 & 1) == 0) {
                v0 /= 2;
                char[] v1 = new char[v0];
                int v2;
                for(v2 = 0; v2 != v0; ++v2) {
                    int v3 = v2 * 2;
                    v1[v2] = ((char)(arg6[v3 + 1] & 0xFF | arg6[v3] << 8));
                }

                this.string = v1;
                return;
            }

            throw new IllegalArgumentException("malformed BMPString encoding encountered");
        }

        throw new NullPointerException("\'string\' cannot be null");
    }

    ASN1BMPString(char[] arg1) {
        super();
        if(arg1 != null) {
            this.string = arg1;
            return;
        }

        throw new NullPointerException("\'string\' cannot be null");
    }

    final boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1BMPString)) {
            return 0;
        }

        return Arrays.areEqual(this.string, ((ASN1BMPString)arg2).string);
    }

    static ASN1BMPString createPrimitive(byte[] arg1) {
        return new DERBMPString(arg1);
    }

    static ASN1BMPString createPrimitive(char[] arg1) {
        return new DERBMPString(arg1);
    }

    final void encode(ASN1OutputStream arg13, boolean arg14) throws IOException {
        int v7_1;
        int v6;
        int v0 = this.string.length;
        arg13.writeIdentifier(arg14, 30);
        arg13.writeDL(v0 * 2);
        int v14 = 8;
        byte[] v1 = new byte[v14];
        int v2 = v0 & -4;
        int v4 = 0;
        while(true) {
            v6 = 2;
            if(v4 >= v2) {
                break;
            }

            char[] v7 = this.string;
            int v8 = v7[v4];
            int v9 = v7[v4 + 1];
            int v10 = v7[v4 + 2];
            v7_1 = v7[v4 + 3];
            v4 += 4;
            v1[0] = ((byte)(v8 >> 8));
            v1[1] = ((byte)v8);
            v1[v6] = ((byte)(v9 >> 8));
            v1[3] = ((byte)v9);
            v1[4] = ((byte)(v10 >> 8));
            v1[5] = ((byte)v10);
            v1[6] = ((byte)(v7_1 >> 8));
            v1[7] = ((byte)v7_1);
            arg13.write(v1, 0, v14);
        }

        if(v4 < v0) {
            v14 = 0;
            do {
                v2 = this.string[v4];
                ++v4;
                v7_1 = v14 + 1;
                v1[v14] = ((byte)(v2 >> 8));
                v14 += v6;
                v1[v7_1] = ((byte)v2);
            }
            while(v4 < v0);

            arg13.write(v1, 0, v14);
        }
    }

    final boolean encodeConstructed() {
        return 0;
    }

    final int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.string.length * 2);
    }

    public static ASN1BMPString getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1BMPString)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1BMPString)) {
                        return ((ASN1BMPString)v0);
                    }
                }

                if((arg3 instanceof byte[])) {
                    try {
                        return ASN1BMPString.TYPE.fromByteArray(((byte[])arg3));
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

    public static ASN1BMPString getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1BMPString.TYPE.getContextTagged(arg1, arg2);
    }

    public final String getString() {
        return new String(this.string);
    }

    public static ASN1BMPString getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1BMPString.TYPE.getTagged(arg1, arg2);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.string);
    }

    public String toString() {
        return this.getString();
    }
}

