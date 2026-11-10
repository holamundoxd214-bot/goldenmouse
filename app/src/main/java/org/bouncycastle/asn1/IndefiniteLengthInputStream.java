package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class IndefiniteLengthInputStream extends LimitedInputStream {
    private int _b1;
    private int _b2;
    private boolean _eofOn00;
    private boolean _eofReached;

    IndefiniteLengthInputStream(InputStream arg1, int arg2) throws IOException {
        super(arg1, arg2);
        this._eofReached = false;
        this._eofOn00 = true;
        this._b1 = arg1.read();
        int v1 = arg1.read();
        this._b2 = v1;
        if(v1 >= 0) {
            this.checkForEof();
            return;
        }

        throw new EOFException();
    }

    private boolean checkForEof() {
        if(!this._eofReached && (this._eofOn00) && this._b1 == 0 && this._b2 == 0) {
            this._eofReached = true;
            this.setParentEofDetect(true);
        }

        return this._eofReached;
    }

    public int read() throws IOException {
        if(this.checkForEof()) {
            return -1;
        }

        int v0 = this._in.read();
        if(v0 >= 0) {
            int v1 = this._b1;
            this._b1 = this._b2;
            this._b2 = v0;
            return v1;
        }

        throw new EOFException();
    }

    public int read(byte[] arg3, int arg4, int arg5) throws IOException {
        if(!this._eofOn00) {
            if(arg5 < 3) {
            }
            else if(this._eofReached) {
                return -1;
            }
            else {
                arg5 = this._in.read(arg3, arg4 + 2, arg5 - 2);
                if(arg5 >= 0) {
                    arg3[arg4] = ((byte)this._b1);
                    arg3[arg4 + 1] = ((byte)this._b2);
                    this._b1 = this._in.read();
                    int v3 = this._in.read();
                    this._b2 = v3;
                    if(v3 >= 0) {
                        return arg5 + 2;
                    }
                    else {
                        throw new EOFException();
                    }
                }
                else {
                    throw new EOFException();
                }
            }
        }

        return super.read(arg3, arg4, arg5);
    }

    void setEofOn00(boolean arg1) {
        this._eofOn00 = arg1;
        this.checkForEof();
    }
}

