package org.bouncycastle.asn1;

import java.io.IOException;

public class BERBitString extends ASN1BitString {
    private static final int DEFAULT_SEGMENT_LIMIT = 1000;
    private final ASN1BitString[] elements;
    private final int segmentLimit;

    public BERBitString(ASN1BitString[] arg2) {
        this(arg2, 1000);
    }

    public BERBitString(byte arg1, int arg2) {
        super(arg1, arg2);
        this.elements = null;
        this.segmentLimit = 1000;
    }

    public BERBitString(ASN1Encodable arg2) throws IOException {
        this(arg2.toASN1Primitive().getEncoded("DER"), 0);
    }

    public BERBitString(byte[] arg2, int arg3) {
        this(arg2, arg3, 1000);
    }

    public BERBitString(byte[] arg2) {
        this(arg2, 0);
    }

    public BERBitString(byte[] arg1, int arg2, int arg3) {
        super(arg1, arg2);
        this.elements = null;
        this.segmentLimit = arg3;
    }

    BERBitString(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
        this.elements = null;
        this.segmentLimit = 1000;
    }

    public BERBitString(ASN1BitString[] arg3, int arg4) {
        super(BERBitString.flattenBitStrings(arg3), false);
        this.elements = arg3;
        this.segmentLimit = arg4;
    }

    void encode(ASN1OutputStream arg12, boolean arg13) throws IOException {
        ASN1OutputStream v2;
        if(!this.encodeConstructed()) {
            DLBitString.encode(arg12, arg13, this.contents, 0, this.contents.length);
            return;
        }

        arg12.writeIdentifier(arg13, 35);
        arg12.write(0x80);
        ASN1BitString[] v13 = this.elements;
        if(v13 != null) {
            arg12.writePrimitives(((ASN1Primitive[])v13));
            goto label_15;
        }
        else if(this.contents.length < 2) {
        label_15:
            v2 = arg12;
        }
        else {
            byte v4 = this.contents[0];
            int v13_1 = this.contents.length;
            int v0 = v13_1 - 1;
            int v10 = this.segmentLimit - 1;
            while(v0 > v10) {
                DLBitString.encode(arg12, true, 0, this.contents, v13_1 - v0, v10);
                v0 -= v10;
                arg12 = arg12;
            }

            v2 = arg12;
            DLBitString.encode(v2, true, v4, this.contents, v13_1 - v0, v0);
        }

        v2.write(0);
        v2.write(0);
    }

    boolean encodeConstructed() {
        if(this.elements == null) {
            if(this.contents.length > this.segmentLimit) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    int encodedLength(boolean arg5) throws IOException {
        if(!this.encodeConstructed()) {
            return DLBitString.encodedLength(arg5, this.contents.length);
        }

        int v5 = arg5 ? 4 : 3;
        if(this.elements != null) {
            int v0;
            for(v0 = 0; true; ++v0) {
                ASN1BitString[] v2 = this.elements;
                if(v0 >= v2.length) {
                    return v5;
                }

                v5 += v2[v0].encodedLength(true);
            }

            return v5;
        }

        int v2_1 = 2;
        if(this.contents.length < v2_1) {
            return v5;
        }

        v0 = (this.contents.length - v2_1) / (this.segmentLimit - 1);
        return v5 + DLBitString.encodedLength(true, this.segmentLimit) * v0 + DLBitString.encodedLength(true, this.contents.length - v0 * (this.segmentLimit - 1));
    }

    static byte[] flattenBitStrings(ASN1BitString[] arg8) {
        int v0 = arg8.length;
        int v1 = 0;
        if(v0 == 0) {
            goto label_43;
        }

        if(v0 == 1) {
            goto label_40;
        }

        int v3 = v0 - 1;
        int v4 = 0;
        int v5 = 0;
        while(true) {
            if(v4 >= v3) {
                goto label_22;
            }

            byte[] v6 = arg8[v4].contents;
            if(v6[0] != 0) {
                break;
            }

            v5 += v6.length - 1;
            ++v4;
        }

        throw new IllegalArgumentException("only the last nested bitstring can have padding");
    label_22:
        byte[] v3_1 = arg8[v3].contents;
        byte v4_1 = v3_1[0];
        v3_1 = new byte[v5 + v3_1.length];
        v3_1[0] = v4_1;
        v4 = 1;
        while(v1 < v0) {
            byte[] v5_1 = arg8[v1].contents;
            int v6_1 = v5_1.length - 1;
            System.arraycopy(v5_1, 1, v3_1, v4, v6_1);
            v4 += v6_1;
            ++v1;
        }

        return v3_1;
    label_40:
        return arg8[0].contents;
    label_43:
        return new byte[]{0};
    }
}

