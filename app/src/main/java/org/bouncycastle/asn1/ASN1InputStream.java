package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

public class ASN1InputStream extends FilterInputStream implements BERTags {
    private final boolean lazyEvaluate;
    private final int limit;
    private final byte[][] tmpBuffers;

    public ASN1InputStream(byte[] arg2) {
        this(new ByteArrayInputStream(arg2), arg2.length);
    }

    public ASN1InputStream(InputStream arg2) {
        this(arg2, StreamUtil.findLimit(arg2));
    }

    public ASN1InputStream(InputStream arg2, int arg3) {
        this(arg2, arg3, false);
    }

    public ASN1InputStream(InputStream arg2, int arg3, boolean arg4) {
        this(arg2, arg3, arg4, new byte[11][]);
    }

    private ASN1InputStream(InputStream arg1, int arg2, boolean arg3, byte[][] arg4) {
        super(arg1);
        this.limit = arg2;
        this.lazyEvaluate = arg3;
        this.tmpBuffers = arg4;
    }

    public ASN1InputStream(InputStream arg2, boolean arg3) {
        this(arg2, StreamUtil.findLimit(arg2), arg3);
    }

    public ASN1InputStream(byte[] arg2, boolean arg3) {
        this(new ByteArrayInputStream(arg2), arg2.length, arg3);
    }

    ASN1BitString buildConstructedBitString(ASN1EncodableVector arg5) throws IOException {
        ASN1Encodable v2;
        int v4 = arg5.size();
        ASN1BitString[] v0 = new ASN1BitString[v4];
        int v1;
        for(v1 = 0; true; ++v1) {
            if(v1 == v4) {
                goto label_19;
            }

            v2 = arg5.get(v1);
            if(!(v2 instanceof ASN1BitString)) {
                break;
            }

            v0[v1] = ((ASN1BitString)v2);
        }

        throw new ASN1Exception("unknown object encountered in constructed BIT STRING: " + v2.getClass());
    label_19:
        return new BERBitString(v0);
    }

    ASN1OctetString buildConstructedOctetString(ASN1EncodableVector arg5) throws IOException {
        ASN1Encodable v2;
        int v4 = arg5.size();
        ASN1OctetString[] v0 = new ASN1OctetString[v4];
        int v1;
        for(v1 = 0; true; ++v1) {
            if(v1 == v4) {
                goto label_19;
            }

            v2 = arg5.get(v1);
            if(!(v2 instanceof ASN1OctetString)) {
                break;
            }

            v0[v1] = ((ASN1OctetString)v2);
        }

        throw new ASN1Exception("unknown object encountered in constructed OCTET STRING: " + v2.getClass());
    label_19:
        return new BEROctetString(v0);
    }

    protected ASN1Primitive buildObject(int arg3, int arg4, int arg5) throws IOException {
        DefiniteLengthInputStream v0 = new DefiniteLengthInputStream(((InputStream)this), arg5, this.limit);
        if((arg3 & 0xE0) == 0) {
            return ASN1InputStream.createPrimitiveDERObject(arg4, v0, this.tmpBuffers);
        }

        arg5 = arg3 & 0xC0;
        boolean v1 = true;
        if(arg5 != 0) {
            if((arg3 & 0x20) != 0) {
            }
            else {
                v1 = false;
            }

            return this.readTaggedObjectDL(arg5, arg4, v1, v0);
        }

        if(arg4 != 3) {
            if(arg4 != 4) {
                if(arg4 != 8) {
                    if(arg4 != 16) {
                        if(arg4 == 17) {
                            return DLFactory.createSet(this.readVector(v0));
                        }

                        throw new IOException("unknown tag " + arg4 + " encountered");
                    }

                    if(v0.getRemaining() < 1) {
                        return DLFactory.EMPTY_SEQUENCE;
                    }

                    if(this.lazyEvaluate) {
                        return new LazyEncodedSequence(v0.toByteArray());
                    }

                    return DLFactory.createSequence(this.readVector(v0));
                }

                return DLFactory.createSequence(this.readVector(v0)).toASN1External();
            }

            return this.buildConstructedOctetString(this.readVector(v0));
        }

        return this.buildConstructedBitString(this.readVector(v0));
    }

    static ASN1Primitive createPrimitiveDERObject(int arg4, DefiniteLengthInputStream arg5, byte[][] arg6) throws IOException {
        String v0 = "unsupported tag ";
        String v1 = "unknown tag ";
        String v2 = " encountered";
        switch(arg4) {
            case 1: {
                goto label_83;
            }
            case 2: {
                goto label_80;
            }
            case 3: {
                goto label_77;
            }
            case 4: {
                goto label_74;
            }
            case 5: {
                goto label_70;
            }
            case 6: {
                goto label_65;
            }
            case 7: {
                goto label_62;
            }
            case 10: {
                goto label_59;
            }
            case 12: {
                goto label_56;
            }
            case 13: {
                goto label_51;
            }
            case 18: {
                goto label_40;
            }
            case 19: {
                goto label_37;
            }
            case 20: {
                goto label_34;
            }
            case 21: {
                goto label_31;
            }
            case 22: {
                goto label_28;
            }
            case 23: {
                goto label_25;
            }
            case 24: {
                goto label_22;
            }
            case 25: {
                goto label_19;
            }
            case 26: {
                goto label_16;
            }
            case 27: {
                goto label_13;
            }
            case 28: {
                goto label_10;
            }
            case 30: {
                goto label_7;
            }
            case 14: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: {
                goto label_43;
            }
        }

        try {
            throw new IOException(v1 + arg4 + v2);
        label_34:
            return ASN1T61String.createPrimitive(arg5.toByteArray());
        label_37:
            return ASN1PrintableString.createPrimitive(arg5.toByteArray());
        label_40:
            return ASN1NumericString.createPrimitive(arg5.toByteArray());
        label_43:
            throw new IOException(v0 + arg4 + v2);
        label_51:
            ASN1RelativeOID.checkContentsLength(arg5.getRemaining());
            return ASN1RelativeOID.createPrimitive(ASN1InputStream.getBuffer(arg5, arg6), true);
        label_56:
            return ASN1UTF8String.createPrimitive(arg5.toByteArray());
        label_59:
            return ASN1Enumerated.createPrimitive(ASN1InputStream.getBuffer(arg5, arg6), true);
        label_62:
            return ASN1ObjectDescriptor.createPrimitive(arg5.toByteArray());
        label_65:
            ASN1ObjectIdentifier.checkContentsLength(arg5.getRemaining());
            return ASN1ObjectIdentifier.createPrimitive(ASN1InputStream.getBuffer(arg5, arg6), true);
        label_70:
            ASN1Null.checkContentsLength(arg5.getRemaining());
            return ASN1Null.createPrimitive();
        label_7:
            return ASN1BMPString.createPrimitive(ASN1InputStream.getBMPCharBuffer(arg5));
        label_74:
            return ASN1OctetString.createPrimitive(arg5.toByteArray());
        label_10:
            return ASN1UniversalString.createPrimitive(arg5.toByteArray());
        label_77:
            return ASN1BitString.createPrimitive(arg5.toByteArray());
        label_13:
            return ASN1GeneralString.createPrimitive(arg5.toByteArray());
        label_80:
            return ASN1Integer.createPrimitive(arg5.toByteArray());
        label_16:
            return ASN1VisibleString.createPrimitive(arg5.toByteArray());
        label_83:
            return ASN1Boolean.createPrimitive(ASN1InputStream.getBuffer(arg5, arg6));
        label_19:
            return ASN1GraphicString.createPrimitive(arg5.toByteArray());
        label_22:
            return ASN1GeneralizedTime.createPrimitive(arg5.toByteArray());
        label_25:
            return ASN1UTCTime.createPrimitive(arg5.toByteArray());
        label_28:
            return ASN1IA5String.createPrimitive(arg5.toByteArray());
        label_31:
            return ASN1VideotexString.createPrimitive(arg5.toByteArray());
        }
        catch(IllegalStateException v4) {
            throw new ASN1Exception(v4.getMessage(), ((Throwable)v4));
        }
        catch(IllegalArgumentException v4_1) {
            throw new ASN1Exception(v4_1.getMessage(), ((Throwable)v4_1));
        }
    }

    private static char[] getBMPCharBuffer(DefiniteLengthInputStream arg11) throws IOException {
        int v8;
        String v7;
        int v0 = arg11.getRemaining();
        if((v0 & 1) != 0) {
            goto label_83;
        }

        int v1 = v0 / 2;
        char[] v2 = new char[v1];
        int v3 = 8;
        byte[] v4 = new byte[v3];
        int v5 = 0;
        int v6 = 0;
        while(true) {
            v7 = "EOF encountered in middle of BMPString";
            v8 = 2;
            if(v0 < v3) {
                goto label_57;
            }

            if(Streams.readFully(((InputStream)arg11), v4, 0, v3) != v3) {
                break;
            }

            v2[v6] = ((char)(v4[0] << v3 | v4[1] & 0xFF));
            v2[v6 + 1] = ((char)(v4[v8] << v3 | v4[3] & 0xFF));
            v2[v6 + 2] = ((char)(v4[4] << v3 | v4[5] & 0xFF));
            v2[v6 + 3] = ((char)(v4[6] << v3 | v4[7] & 0xFF));
            v6 += 4;
            v0 += -8;
        }

        throw new EOFException(v7);
    label_57:
        if(v0 > 0) {
            if(Streams.readFully(((InputStream)arg11), v4, 0, v0) != v0) {
                throw new EOFException(v7);
            }

            do {
                int v7_1 = v5 + 1;
                int v9 = v4[v5] << v3;
                v5 += v8;
                v2[v6] = ((char)(v4[v7_1] & 0xFF | v9));
                ++v6;
            }
            while(v5 < v0);
        }

        if(arg11.getRemaining() == 0 && v1 == v6) {
            return v2;
        }

        throw new IllegalStateException();
    label_83:
        throw new IOException("malformed BMPString encoding encountered");
    }

    private static byte[] getBuffer(DefiniteLengthInputStream arg2, byte[][] arg3) throws IOException {
        int v0 = arg2.getRemaining();
        if(v0 >= arg3.length) {
            return arg2.toByteArray();
        }

        byte[] v1 = arg3[v0];
        if(v1 == null) {
            v1 = new byte[v0];
            arg3[v0] = v1;
        }

        arg2.readAllIntoByteArray(v1);
        return v1;
    }

    int getLimit() {
        return this.limit;
    }

    protected void readFully(byte[] arg3) throws IOException {
        if(Streams.readFully(((InputStream)this), arg3, 0, arg3.length) == arg3.length) {
            return;
        }

        throw new EOFException("EOF encountered in middle of object");
    }

    static int readLength(InputStream arg5, int arg6, boolean arg7) throws IOException {
        int v0 = arg5.read();
        if(v0 >>> 7 == 0) {
            return v0;
        }

        if(0x80 == v0) {
            return -1;
        }

        if(v0 < 0) {
            goto label_49;
        }

        if(0xFF == v0) {
            goto label_45;
        }

        v0 &= 0x7F;
        int v1 = 0;
        int v2 = 0;
        do {
            int v3 = arg5.read();
            if(v3 < 0) {
                goto label_41;
            }

            if(v1 >>> 23 != 0) {
                goto label_37;
            }

            v1 = (v1 << 8) + v3;
            ++v2;
        }
        while(v2 < v0);

        if(v1 >= arg6) {
            if(arg7) {
            }
            else {
                throw new IOException("corrupted stream - out of bounds length found: " + v1 + " >= " + arg6);
            }
        }

        return v1;
    label_37:
        throw new IOException("long form definite-length more than 31 bits");
    label_41:
        throw new EOFException("EOF found reading length");
    label_45:
        throw new IOException("invalid long form definite-length 0xFF");
    label_49:
        throw new EOFException("EOF found when length expected");
    }

    protected int readLength() throws IOException {
        return ASN1InputStream.readLength(((InputStream)this), this.limit, false);
    }

    public ASN1Primitive readObject() throws IOException {
        int v0 = this.read();
        if(v0 <= 0) {
            if(v0 != 0) {
                return null;
            }

            throw new IOException("unexpected end-of-contents marker");
        }

        int v1 = ASN1InputStream.readTagNumber(((InputStream)this), v0);
        int v2 = this.readLength();
        if(v2 >= 0) {
            try {
                return this.buildObject(v0, v1, v2);
            }
            catch(IllegalArgumentException v5) {
                throw new ASN1Exception("corrupted stream detected", ((Throwable)v5));
            }
        }

        if((v0 & 0x20) != 0) {
            ASN1StreamParser v3 = new ASN1StreamParser(new IndefiniteLengthInputStream(((InputStream)this), this.limit), this.limit, this.tmpBuffers);
            int v5_1 = v0 & 0xC0;
            if(v5_1 != 0) {
                return v3.loadTaggedIL(v5_1, v1);
            }

            if(v1 != 3) {
                if(v1 != 4) {
                    if(v1 != 8) {
                        if(v1 != 16) {
                            if(v1 == 17) {
                                return BERSetParser.parse(v3);
                            }

                            throw new IOException("unknown BER object encountered");
                        }

                        return BERSequenceParser.parse(v3);
                    }

                    return DERExternalParser.parse(v3);
                }

                return BEROctetStringParser.parse(v3);
            }

            return BERBitStringParser.parse(v3);
        }

        throw new IOException("indefinite-length primitive encoding encountered");
    }

    static int readTagNumber(InputStream arg4, int arg5) throws IOException {
        int v0 = 0x1F;
        arg5 &= v0;
        if(arg5 != v0) {
            return arg5;
        }

        arg5 = arg4.read();
        String v1 = "EOF found inside tag value.";
        if(arg5 < v0) {
            if(arg5 < 0) {
                throw new EOFException(v1);
            }

            throw new IOException("corrupted stream - high tag number < 31 found");
        }

        v0 = arg5 & 0x7F;
        if(v0 == 0) {
            goto label_37;
        }

        while(true) {
            if((arg5 & 0x80) == 0) {
                return v0;
            }

            if(v0 >>> 24 != 0) {
                goto label_32;
            }

            arg5 = v0 << 7;
            v0 = arg4.read();
            if(v0 < 0) {
                break;
            }

            int v3 = v0;
            v0 = arg5 | v0 & 0x7F;
            arg5 = v3;
        }

        throw new EOFException(v1);
    label_32:
        throw new IOException("Tag number more than 31 bits");
        return v0;
    label_37:
        throw new IOException("corrupted stream - invalid high tag number found");
        return arg5;
    }

    ASN1Primitive readTaggedObjectDL(int arg1, int arg2, boolean arg3, DefiniteLengthInputStream arg4) throws IOException {
        if(!arg3) {
            return ASN1TaggedObject.createPrimitive(arg1, arg2, arg4.toByteArray());
        }

        return ASN1TaggedObject.createConstructedDL(arg1, arg2, this.readVector(arg4));
    }

    ASN1EncodableVector readVector(DefiniteLengthInputStream arg4) throws IOException {
        int v0 = arg4.getRemaining();
        if(v0 < 1) {
            return new ASN1EncodableVector(0);
        }

        return new ASN1InputStream(((InputStream)arg4), v0, this.lazyEvaluate, this.tmpBuffers).readVector();
    }

    ASN1EncodableVector readVector() throws IOException {
        ASN1Primitive v0 = this.readObject();
        if(v0 == null) {
            return new ASN1EncodableVector(0);
        }

        ASN1EncodableVector v1 = new ASN1EncodableVector();
        do {
            v1.add(((ASN1Encodable)v0));
            v0 = this.readObject();
        }
        while(v0 != null);

        return v1;
    }
}

