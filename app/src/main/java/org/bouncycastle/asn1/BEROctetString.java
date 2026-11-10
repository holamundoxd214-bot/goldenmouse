package org.bouncycastle.asn1;

import java.io.IOException;

public class BEROctetString extends ASN1OctetString {
    private static final int DEFAULT_SEGMENT_LIMIT = 1000;
    private final ASN1OctetString[] elements;
    private final int segmentLimit;

    public BEROctetString(ASN1OctetString[] arg2) {
        this(arg2, 1000);
    }

    public BEROctetString(byte[] arg2) {
        this(arg2, 1000);
    }

    public BEROctetString(byte[] arg2, int arg3) {
        this(arg2, null, arg3);
    }

    private BEROctetString(byte[] arg1, ASN1OctetString[] arg2, int arg3) {
        super(arg1);
        this.elements = arg2;
        this.segmentLimit = arg3;
    }

    public BEROctetString(ASN1OctetString[] arg2, int arg3) {
        this(BEROctetString.flattenOctetStrings(arg2), arg2, arg3);
    }

    void encode(ASN1OutputStream arg5, boolean arg6) throws IOException {
        arg5.writeIdentifier(arg6, 36);
        arg5.write(0x80);
        ASN1OctetString[] v6 = this.elements;
        if(v6 != null) {
            arg5.writePrimitives(((ASN1Primitive[])v6));
        }
        else {
            int v6_1;
            for(v6_1 = 0; v6_1 < this.string.length; v6_1 += v1) {
                int v1 = Math.min(this.string.length - v6_1, this.segmentLimit);
                DEROctetString.encode(arg5, true, this.string, v6_1, v1);
            }
        }

        arg5.write(0);
        arg5.write(0);
    }

    boolean encodeConstructed() {
        return 1;
    }

    int encodedLength(boolean arg5) throws IOException {
        int v5 = arg5 ? 4 : 3;
        if(this.elements != null) {
            int v0;
            for(v0 = 0; true; ++v0) {
                ASN1OctetString[] v2 = this.elements;
                if(v0 >= v2.length) {
                    return v5;
                }

                v5 += v2[v0].encodedLength(true);
            }

            return v5;
        }

        v0 = this.string.length / this.segmentLimit;
        v5 += DEROctetString.encodedLength(true, this.segmentLimit) * v0;
        int v2_1 = this.string.length - v0 * this.segmentLimit;
        if(v2_1 > 0) {
            v5 += DEROctetString.encodedLength(true, v2_1);
        }

        return v5;
    }

    static byte[] flattenOctetStrings(ASN1OctetString[] arg7) {
        int v0 = arg7.length;
        if(v0 != 0) {
            if(v0 != 1) {
                int v1 = 0;
                int v3 = 0;
                while(v1 < v0) {
                    v3 += arg7[v1].string.length;
                    ++v1;
                }

                byte[] v1_1 = new byte[v3];
                v3 = 0;
                int v4 = 0;
                while(v3 < v0) {
                    byte[] v5 = arg7[v3].string;
                    System.arraycopy(v5, 0, v1_1, v4, v5.length);
                    v4 += v5.length;
                    ++v3;
                }

                return v1_1;
            }

            return arg7[0].string;
        }

        return BEROctetString.EMPTY_OCTETS;
    }
}

