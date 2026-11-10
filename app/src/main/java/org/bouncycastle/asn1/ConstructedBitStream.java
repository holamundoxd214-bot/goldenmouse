package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

class ConstructedBitStream extends InputStream {
    private ASN1BitStringParser _currentParser;
    private InputStream _currentStream;
    private boolean _first;
    private final boolean _octetAligned;
    private int _padBits;
    private final ASN1StreamParser _parser;

    ConstructedBitStream(ASN1StreamParser arg2, boolean arg3) {
        super();
        this._first = true;
        this._padBits = 0;
        this._parser = arg2;
        this._octetAligned = arg3;
    }

    private ASN1BitStringParser getNextParser() throws IOException {
        ASN1Encodable v0 = this._parser.readObject();
        if(v0 == null) {
            if(this._octetAligned) {
                if(this._padBits == 0) {
                }
                else {
                    throw new IOException("expected octet-aligned bitstring, but found padBits: " + this._padBits);
                }
            }

            return null;
        }

        if((v0 instanceof ASN1BitStringParser)) {
            if(this._padBits == 0) {
                return ((ASN1BitStringParser)v0);
            }

            throw new IOException("only the last nested bitstring can have padding");
        }

        throw new IOException("unknown object encountered: " + v0.getClass());
    }

    int getPadBits() {
        return this._padBits;
    }

    public int read() throws IOException {
        ASN1BitStringParser v0;
        int v1 = -1;
        if(this._currentStream == null) {
            if(!this._first) {
                return v1;
            }
            else {
                v0 = this.getNextParser();
                this._currentParser = v0;
                if(v0 == null) {
                    return v1;
                }
                else {
                    this._first = false;
                label_26:
                    this._currentStream = v0.getBitStream();
                }
            }
        }

        int v0_1 = this._currentStream.read();
        if(v0_1 >= 0) {
            return v0_1;
        }

        this._padBits = this._currentParser.getPadBits();
        v0 = this.getNextParser();
        this._currentParser = v0;
        if(v0 != null) {
            goto label_26;
        }

        this._currentStream = null;
        return v1;
    }

    public int read(byte[] arg6, int arg7, int arg8) throws IOException {
        ASN1BitStringParser v0;
        int v1 = 0;
        int v2 = -1;
        if(this._currentStream == null) {
            if(!this._first) {
                return v2;
            }
            else {
                v0 = this.getNextParser();
                this._currentParser = v0;
                if(v0 == null) {
                    return v2;
                }
                else {
                    this._first = false;
                label_12:
                    this._currentStream = v0.getBitStream();
                }
            }
        }

        do {
            int v0_1 = this._currentStream.read(arg6, arg7 + v1, arg8 - v1);
            if(v0_1 < 0) {
                goto label_22;
            }

            v1 += v0_1;
        }
        while(v1 != arg8);

        return v1;
    label_22:
        this._padBits = this._currentParser.getPadBits();
        v0 = this.getNextParser();
        this._currentParser = v0;
        if(v0 != null) {
            goto label_12;
        }

        this._currentStream = null;
        if(v1 < 1) {
            return v2;
        }

        return v1;
    }
}

