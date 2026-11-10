package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

class ConstructedOctetStream extends InputStream {
    private InputStream _currentStream;
    private boolean _first;
    private final ASN1StreamParser _parser;

    ConstructedOctetStream(ASN1StreamParser arg2) {
        super();
        this._first = true;
        this._parser = arg2;
    }

    private ASN1OctetStringParser getNextParser() throws IOException {
        ASN1Encodable v3 = this._parser.readObject();
        if(v3 == null) {
            return null;
        }

        if((v3 instanceof ASN1OctetStringParser)) {
            return ((ASN1OctetStringParser)v3);
        }

        throw new IOException("unknown object encountered: " + v3.getClass());
    }

    public int read() throws IOException {
        ASN1OctetStringParser v0;
        int v1 = -1;
        if(this._currentStream == null) {
            if(!this._first) {
                return v1;
            }
            else {
                v0 = this.getNextParser();
                if(v0 == null) {
                    return v1;
                }
                else {
                    this._first = false;
                label_21:
                    this._currentStream = v0.getOctetStream();
                }
            }
        }

        int v0_1 = this._currentStream.read();
        if(v0_1 >= 0) {
            return v0_1;
        }

        v0 = this.getNextParser();
        if(v0 != null) {
            goto label_21;
        }

        this._currentStream = null;
        return v1;
    }

    public int read(byte[] arg6, int arg7, int arg8) throws IOException {
        ASN1OctetStringParser v0;
        int v1 = 0;
        int v2 = -1;
        if(this._currentStream == null) {
            if(!this._first) {
                return v2;
            }
            else {
                v0 = this.getNextParser();
                if(v0 == null) {
                    return v2;
                }
                else {
                    this._first = false;
                label_11:
                    this._currentStream = v0.getOctetStream();
                }
            }
        }

        do {
            int v0_1 = this._currentStream.read(arg6, arg7 + v1, arg8 - v1);
            if(v0_1 < 0) {
                goto label_21;
            }

            v1 += v0_1;
        }
        while(v1 != arg8);

        return v1;
    label_21:
        v0 = this.getNextParser();
        if(v0 != null) {
            goto label_11;
        }

        this._currentStream = null;
        if(v1 < 1) {
            return v2;
        }

        return v1;
    }
}

