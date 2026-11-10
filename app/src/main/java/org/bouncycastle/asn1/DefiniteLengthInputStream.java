package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

class DefiniteLengthInputStream extends LimitedInputStream {
    private static final byte[] EMPTY_BYTES;
    private final int _originalLength;
    private int _remaining;

    static {
        DefiniteLengthInputStream.EMPTY_BYTES = new byte[0];
    }

    DefiniteLengthInputStream(InputStream arg1, int arg2, int arg3) {
        super(arg1, arg3);
        if(arg2 <= 0) {
            if(arg2 >= 0) {
                this.setParentEofDetect(true);
            }
            else {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
        }

        this._originalLength = arg2;
        this._remaining = arg2;
    }

    int getRemaining() {
        return this._remaining;
    }

    public int read() throws IOException {
        if(this._remaining == 0) {
            return -1;
        }

        int v0 = this._in.read();
        if(v0 >= 0) {
            int v1 = this._remaining - 1;
            this._remaining = v1;
            if(v1 == 0) {
                this.setParentEofDetect(true);
            }

            return v0;
        }

        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    public int read(byte[] arg2, int arg3, int arg4) throws IOException {
        int v0 = this._remaining;
        if(v0 == 0) {
            return -1;
        }

        int v2 = this._in.read(arg2, arg3, Math.min(arg4, v0));
        if(v2 >= 0) {
            arg3 = this._remaining - v2;
            this._remaining = arg3;
            if(arg3 == 0) {
                this.setParentEofDetect(true);
            }

            return v2;
        }

        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    void readAllIntoByteArray(byte[] arg5) throws IOException {
        int v0 = this._remaining;
        if(v0 == arg5.length) {
            if(v0 == 0) {
                return;
            }

            v0 = this.getLimit();
            int v1 = this._remaining;
            if(v1 < v0) {
                v1 -= Streams.readFully(this._in, arg5, 0, arg5.length);
                this._remaining = v1;
                if(v1 == 0) {
                    this.setParentEofDetect(true);
                    return;
                }

                throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
            }

            throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + v0);
        }

        throw new IllegalArgumentException("buffer length not right for data");
    }

    byte[] toByteArray() throws IOException {
        if(this._remaining == 0) {
            return DefiniteLengthInputStream.EMPTY_BYTES;
        }

        int v0 = this.getLimit();
        int v1 = this._remaining;
        if(v1 < v0) {
            byte[] v0_1 = new byte[v1];
            v1 -= Streams.readFully(this._in, v0_1, 0, v1);
            this._remaining = v1;
            if(v1 == 0) {
                this.setParentEofDetect(true);
                return v0_1;
            }

            throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
        }

        throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + v0);
    }
}

