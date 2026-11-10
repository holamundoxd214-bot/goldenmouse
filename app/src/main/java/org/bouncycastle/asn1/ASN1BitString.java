package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;

public abstract class ASN1BitString extends ASN1Primitive implements ASN1BitStringParser, ASN1String {
    class org.bouncycastle.asn1.ASN1BitString$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1BitString$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitConstructed(ASN1Sequence arg1) {
            return arg1.toASN1BitString();
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1BitString.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final byte[] contents;
    private static final char[] table;

    static {
        ASN1BitString.TYPE = new org.bouncycastle.asn1.ASN1BitString$1(ASN1BitString.class, 3);
        ASN1BitString.table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    ASN1BitString(byte arg3, int arg4) {
        super();
        if(arg4 <= 7 && arg4 >= 0) {
            this.contents = new byte[]{((byte)arg4), arg3};
            return;
        }

        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    }

    ASN1BitString(byte[] arg2, int arg3) {
        super();
        if(arg2 != null) {
            if(arg2.length == 0) {
                if(arg3 == 0) {
                }
                else {
                    throw new IllegalArgumentException("zero length data with non-zero pad bits");
                }
            }

            if(arg3 <= 7 && arg3 >= 0) {
                this.contents = Arrays.prepend(arg2, ((byte)arg3));
                return;
            }

            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }

        throw new NullPointerException("\'data\' cannot be null");
    }

    ASN1BitString(byte[] arg3, boolean arg4) {
        super();
        if(arg4) {
            if(arg3 == null) {
                throw new NullPointerException("\'contents\' cannot be null");
            }
            else if(arg3.length >= 1) {
                int v4 = arg3[0] & 0xFF;
                if(v4 > 0) {
                    if(arg3.length < 2) {
                        throw new IllegalArgumentException("zero length data with non-zero pad bits");
                    }
                    else if(v4 <= 7) {
                    }
                    else {
                        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                    }
                }
            }
            else {
                throw new IllegalArgumentException("\'contents\' cannot be empty");
            }
        }

        this.contents = arg3;
    }

    boolean asn1Equals(ASN1Primitive arg7) {
        if(!(arg7 instanceof ASN1BitString)) {
            return 0;
        }

        byte[] v6 = this.contents;
        byte[] v7 = ((ASN1BitString)arg7).contents;
        int v0 = v6.length;
        if(v7.length != v0) {
            return 0;
        }

        if(v0 == 1) {
            return 1;
        }

        --v0;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            if(v6[v3] != v7[v3]) {
                return 0;
            }
        }

        v3 = 0xFF << (v6[0] & 0xFF);
        if((((byte)(v6[v0] & v3))) == (((byte)(v7[v0] & v3)))) {
            return 1;
        }

        return 0;
    }

    static ASN1BitString createPrimitive(byte[] arg6) {
        int v0 = arg6.length;
        if(v0 >= 1) {
            int v4 = 0xFF;
            int v3 = arg6[0] & v4;
            if(v3 > 0) {
                if(v3 <= 7 && v0 >= 2) {
                    if(arg6[v0 - 1] != (((byte)(v4 << v3 & arg6[v0 - 1])))) {
                        return new DLBitString(arg6, false);
                    }
                    else {
                        goto label_25;
                    }
                }

                throw new IllegalArgumentException("invalid pad bits detected");
            }

        label_25:
            return new DERBitString(arg6, false);
        }

        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public InputStream getBitStream() throws IOException {
        return new ByteArrayInputStream(this.contents, 1, this.contents.length - 1);
    }

    protected static byte[] getBytes(int arg5) {
        int v3;
        int v0 = 0;
        if(arg5 == 0) {
            return new byte[0];
        }

        int v1 = 4;
        int v2 = 3;
        while(true) {
            v3 = 0xFF;
            if(v2 >= 1) {
                if((v3 << v2 * 8 & arg5) != 0) {
                }
                else {
                    --v1;
                    --v2;
                    continue;
                }
            }

            break;
        }

        byte[] v2_1 = new byte[v1];
        while(v0 < v1) {
            v2_1[v0] = ((byte)(arg5 >> v0 * 8 & v3));
            ++v0;
        }

        return v2_1;
    }

    public byte[] getBytes() {
        byte[] v4 = this.contents;
        if(v4.length == 1) {
            return ASN1OctetString.EMPTY_OCTETS;
        }

        int v0 = v4[0] & 0xFF;
        v4 = Arrays.copyOfRange(v4, 1, v4.length);
        int v3 = v4.length - 1;
        v4[v3] = ((byte)((((byte)(0xFF << v0))) & v4[v3]));
        return v4;
    }

    public int getBytesLength() {
        return this.contents.length - 1;
    }

    public static ASN1BitString getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1BitString)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1BitString)) {
                        return ((ASN1BitString)v0);
                    }
                }
                else if((arg3 instanceof byte[])) {
                    try {
                        return ASN1BitString.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException v3) {
                        throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + v3.getMessage());
                    }
                }

                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1BitString getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1BitString.TYPE.getContextTagged(arg1, arg2);
    }

    public ASN1Primitive getLoadedObject() {
        return this.toASN1Primitive();
    }

    public InputStream getOctetStream() throws IOException {
        int v0 = this.contents[0] & 0xFF;
        if(v0 == 0) {
            return this.getBitStream();
        }

        throw new IOException("expected octet-aligned bitstring, but found padBits: " + v0);
    }

    public byte[] getOctets() {
        byte[] v2 = this.contents;
        if(v2[0] == 0) {
            return Arrays.copyOfRange(v2, 1, v2.length);
        }

        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    protected static int getPadBits(int arg3) {
        int v0;
        for(v0 = 3; v0 >= 0; --v0) {
            if(v0 != 0) {
                int v2 = arg3 >> v0 * 8;
                if(v2 != 0) {
                    arg3 = v2 & 0xFF;
                    goto label_15;
                }
            }
            else if(arg3 != 0) {
                arg3 &= 0xFF;
                goto label_15;
            }
        }

        arg3 = 0;
    label_15:
        if(arg3 == 0) {
            return 0;
        }

        int v1;
        for(v1 = 1; true; ++v1) {
            arg3 <<= 1;
            if((arg3 & 0xFF) == 0) {
                break;
            }
        }

        return 8 - v1;
    }

    public int getPadBits() {
        return this.contents[0] & 0xFF;
    }

    public String getString() {
        byte[] v5_1;
        try {
            v5_1 = this.getEncoded();
        }
        catch(IOException v5) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + v5.getMessage(), ((Throwable)v5));
        }

        StringBuilder v0 = new StringBuilder(v5_1.length * 2 + 1);
        v0.append('#');
        int v1;
        for(v1 = 0; v1 != v5_1.length; ++v1) {
            int v2 = v5_1[v1];
            char[] v3 = ASN1BitString.table;
            v0.append(v3[v2 >>> 4 & 15]);
            v0.append(v3[v2 & 15]);
        }

        return v0.toString();
    }

    public static ASN1BitString getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1BitString.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        byte[] v5 = this.contents;
        if(v5.length < 2) {
            return 1;
        }

        int v1 = v5[0] & 0xFF;
        int v4 = v5.length - 1;
        return Arrays.hashCode(v5, 0, v4) * 0x101 ^ (((byte)(0xFF << v1 & v5[v4])));
    }

    public int intValue() {
        int v6;
        int v2 = 5;
        int v0 = Math.min(v2, this.contents.length - 1);
        int v4 = 1;
        int v5 = 0;
        while(true) {
            v6 = 0xFF;
            if(v4 >= v0) {
                break;
            }

            v5 |= (v6 & this.contents[v4]) << (v4 - 1) * 8;
            ++v4;
        }

        if(1 <= v0 && v0 < v2) {
            return ((((byte)(this.contents[v0] & v6 << (this.contents[0] & v6)))) & v6) << (v0 - 1) * 8 | v5;
        }

        return v5;
    }

    public boolean isOctetAligned() {
        if(this.getPadBits() == 0) {
            return 1;
        }

        return 0;
    }

    public ASN1BitStringParser parser() {
        return this;
    }

    ASN1Primitive toDERObject() {
        return new DERBitString(this.contents, false);
    }

    ASN1Primitive toDLObject() {
        return new DLBitString(this.contents, false);
    }

    public String toString() {
        return this.getString();
    }
}

