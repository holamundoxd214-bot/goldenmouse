package org.bouncycastle.asn1;

import java.io.InputStream;

abstract class LimitedInputStream extends InputStream {
    protected final InputStream _in;
    private int _limit;

    LimitedInputStream(InputStream arg1, int arg2) {
        super();
        this._in = arg1;
        this._limit = arg2;
    }

    int getLimit() {
        return this._limit;
    }

    protected void setParentEofDetect(boolean arg2) {
        InputStream v1 = this._in;
        if((v1 instanceof IndefiniteLengthInputStream)) {
            ((IndefiniteLengthInputStream)v1).setEofOn00(arg2);
        }
    }
}

