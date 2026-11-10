package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
    private final InputStream _in;
    private final int _limit;
    private final byte[][] tmpBuffers;

    ASN1StreamParser(InputStream arg1, int arg2, byte[][] arg3) {
        super();
        this._in = arg1;
        this._limit = arg2;
        this.tmpBuffers = arg3;
    }

    public ASN1StreamParser(InputStream arg2) {
        this(arg2, StreamUtil.findLimit(arg2));
    }

    public ASN1StreamParser(InputStream arg2, int arg3) {
        this(arg2, arg3, new byte[11][]);
    }

    public ASN1StreamParser(byte[] arg2) {
        this(new ByteArrayInputStream(arg2), arg2.length);
    }

    ASN1Encodable implParseObject(int arg8) throws IOException {
        int v7;
        ASN1StreamParser v2_2;
        boolean v0 = false;
        this.set00Check(false);
        int v1 = ASN1InputStream.readTagNumber(this._in, arg8);
        InputStream v2 = this._in;
        int v3 = this._limit;
        boolean v4 = v1 == 3 || v1 == 4 || v1 == 16 || v1 == 17 || v1 == 8 ? true : false;
        int v2_1 = ASN1InputStream.readLength(v2, v3, v4);
        if(v2_1 < 0) {
            if((arg8 & 0x20) != 0) {
                v2_2 = new ASN1StreamParser(new IndefiniteLengthInputStream(this._in, this._limit), this._limit, this.tmpBuffers);
                v7 = arg8 & 0xC0;
                if(v7 != 0) {
                    return new BERTaggedObjectParser(v7, v1, v2_2);
                }

                return v2_2.parseImplicitConstructedIL(v1);
            }

            throw new IOException("indefinite-length primitive encoding encountered");
        }

        DefiniteLengthInputStream v3_1 = new DefiniteLengthInputStream(this._in, v2_1, this._limit);
        if((arg8 & 0xE0) == 0) {
            return this.parseImplicitPrimitive(v1, v3_1);
        }

        v2_2 = new ASN1StreamParser(((InputStream)v3_1), v3_1.getLimit(), this.tmpBuffers);
        v7 = arg8 & 0xC0;
        if(v7 != 0) {
            if((arg8 & 0x20) != 0) {
                v0 = true;
            }

            return new DLTaggedObjectParser(v7, v1, v0, v2_2);
        }

        return v2_2.parseImplicitConstructedDL(v1);
    }

    ASN1Primitive loadTaggedDL(int arg1, int arg2, boolean arg3) throws IOException {
        if(!arg3) {
            return ASN1TaggedObject.createPrimitive(arg1, arg2, this._in.toByteArray());
        }

        return ASN1TaggedObject.createConstructedDL(arg1, arg2, this.readVector());
    }

    ASN1Primitive loadTaggedIL(int arg1, int arg2) throws IOException {
        return ASN1TaggedObject.createConstructedIL(arg1, arg2, this.readVector());
    }

    ASN1Encodable parseImplicitConstructedDL(int arg3) throws IOException {
        if(arg3 != 3) {
            if(arg3 != 4) {
                if(arg3 != 8) {
                    if(arg3 != 16) {
                        if(arg3 == 17) {
                            return new DLSetParser(this);
                        }

                        throw new ASN1Exception("unknown DL object encountered: 0x" + Integer.toHexString(arg3));
                    }

                    return new DLSequenceParser(this);
                }

                return new DERExternalParser(this);
            }

            return new BEROctetStringParser(this);
        }

        return new BERBitStringParser(this);
    }

    ASN1Encodable parseImplicitConstructedIL(int arg3) throws IOException {
        if(arg3 != 3) {
            if(arg3 != 4) {
                if(arg3 != 8) {
                    if(arg3 != 16) {
                        if(arg3 == 17) {
                            return new BERSetParser(this);
                        }

                        throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(arg3));
                    }

                    return new BERSequenceParser(this);
                }

                return new DERExternalParser(this);
            }

            return new BEROctetStringParser(this);
        }

        return new BERBitStringParser(this);
    }

    ASN1Encodable parseImplicitPrimitive(int arg2, DefiniteLengthInputStream arg3) throws IOException {
        if(arg2 != 3) {
            if(arg2 != 4) {
                if(arg2 != 8) {
                    if(arg2 != 16) {
                        if(arg2 != 17) {
                            try {
                                return ASN1InputStream.createPrimitiveDERObject(arg2, arg3, this.tmpBuffers);
                            }
                            catch(IllegalArgumentException v1) {
                                throw new ASN1Exception("corrupted stream detected", ((Throwable)v1));
                            }
                        }

                        throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
                    }

                    throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
                }

                throw new ASN1Exception("externals must use constructed encoding (see X.690 8.18)");
            }

            return new DEROctetStringParser(arg3);
        }

        return new DLBitStringParser(arg3);
    }

    ASN1Encodable parseImplicitPrimitive(int arg2) throws IOException {
        return this.parseImplicitPrimitive(arg2, this._in);
    }

    ASN1Encodable parseObject(int arg3) throws IOException {
        if(arg3 >= 0 && arg3 <= 30) {
            int v0 = this._in.read();
            if(v0 < 0) {
                return null;
            }
            else if((v0 & -33) == arg3) {
                return this.implParseObject(v0);
            }
            else {
                throw new IOException("unexpected identifier encountered: " + v0);
            }
        }

        throw new IllegalArgumentException("invalid universal tag number: " + arg3);
    }

    ASN1TaggedObjectParser parseTaggedObject() throws IOException {
        int v0 = this._in.read();
        if(v0 < 0) {
            return null;
        }

        if((v0 & 0xC0) != 0) {
            return this.implParseObject(v0);
        }

        throw new ASN1Exception("no tagged object found");
    }

    public ASN1Encodable readObject() throws IOException {
        int v0 = this._in.read();
        if(v0 < 0) {
            return null;
        }

        return this.implParseObject(v0);
    }

    ASN1EncodableVector readVector() throws IOException {
        int v0 = this._in.read();
        if(v0 < 0) {
            return new ASN1EncodableVector(0);
        }

        ASN1EncodableVector v1 = new ASN1EncodableVector();
        do {
            ASN1Encodable v0_1 = this.implParseObject(v0);
            ASN1Primitive v0_2 = (v0_1 instanceof InMemoryRepresentable) ? ((InMemoryRepresentable)v0_1).getLoadedObject() : v0_1.toASN1Primitive();
            v1.add(((ASN1Encodable)v0_2));
            v0 = this._in.read();
        }
        while(v0 >= 0);

        return v1;
    }

    private void set00Check(boolean arg2) {
        InputStream v1 = this._in;
        if((v1 instanceof IndefiniteLengthInputStream)) {
            ((IndefiniteLengthInputStream)v1).setEofOn00(arg2);
        }
    }
}

