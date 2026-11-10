package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BEROctetStringGenerator extends BERGenerator {
    class BufferedBEROctetStream extends OutputStream {
        private byte[] _buf;
        private DEROutputStream _derOut;
        private int _off;

        BufferedBEROctetStream(BEROctetStringGenerator arg1, byte[] arg2) {
            BEROctetStringGenerator.this = arg1;
            super();
            this._buf = arg2;
            this._off = 0;
            this._derOut = new DEROutputStream(arg1._out);
        }

        public void close() throws IOException {
            int v0 = this._off;
            if(v0 != 0) {
                DEROctetString.encode(this._derOut, true, this._buf, 0, v0);
            }

            this._derOut.flushInternal();
            BEROctetStringGenerator.this.writeBEREnd();
        }

        public void write(int arg5) throws IOException {
            byte[] v0 = this._buf;
            int v1 = this._off;
            int v2 = v1 + 1;
            this._off = v2;
            v0[v1] = ((byte)arg5);
            if(v2 == v0.length) {
                DEROctetString.encode(this._derOut, true, v0, 0, v0.length);
                this._off = 0;
            }
        }

        public void write(byte[] arg7, int arg8, int arg9) throws IOException {
            int v0_1;
            byte[] v0 = this._buf;
            int v1 = v0.length;
            int v2 = this._off;
            int v3 = v1 - v2;
            if(arg9 < v3) {
                System.arraycopy(arg7, arg8, v0, v2, arg9);
                this._off += arg9;
                return;
            }

            if(v2 > 0) {
                System.arraycopy(arg7, arg8, v0, v2, v3);
                DEROctetString.encode(this._derOut, true, this._buf, 0, v1);
            }
            else {
                v3 = 0;
            }

            while(true) {
                v0_1 = arg9 - v3;
                if(v0_1 < v1) {
                    break;
                }

                DEROctetString.encode(this._derOut, true, arg7, arg8 + v3, v1);
                v3 += v1;
            }

            System.arraycopy(arg7, arg8 + v3, this._buf, 0, v0_1);
            this._off = v0_1;
        }
    }

    public BEROctetStringGenerator(OutputStream arg1) throws IOException {
        super(arg1);
        this.writeBERHeader(36);
    }

    public BEROctetStringGenerator(OutputStream arg1, int arg2, boolean arg3) throws IOException {
        super(arg1, arg2, arg3);
        this.writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream() {
        return this.getOctetOutputStream(new byte[1000]);
    }

    public OutputStream getOctetOutputStream(byte[] arg2) {
        return new BufferedBEROctetStream(this, arg2);
    }
}

