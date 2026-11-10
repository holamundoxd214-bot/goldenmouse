package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class DERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged;

    protected DERGenerator(OutputStream arg1) {
        super(arg1);
        this._tagged = false;
    }

    public DERGenerator(OutputStream arg1, int arg2, boolean arg3) {
        super(arg1);
        this._tagged = true;
        this._isExplicit = arg3;
        this._tagNo = arg2;
    }

    void writeDEREncoded(int arg4, byte[] arg5) throws IOException {
        if(this._tagged) {
            int v0 = this._tagNo;
            int v1 = v0 | 0x80;
            if(this._isExplicit) {
                ByteArrayOutputStream v1_1 = new ByteArrayOutputStream();
                this.writeDEREncoded(((OutputStream)v1_1), arg4, arg5);
                this.writeDEREncoded(this._out, v0 | 0xA0, v1_1.toByteArray());
                return;
            }

            if((arg4 & 0x20) != 0) {
                this.writeDEREncoded(this._out, v0 | 0xA0, arg5);
                return;
            }

            this.writeDEREncoded(this._out, v1, arg5);
            return;
        }

        this.writeDEREncoded(this._out, arg4, arg5);
    }

    void writeDEREncoded(OutputStream arg1, int arg2, byte[] arg3) throws IOException {
        arg1.write(arg2);
        this.writeLength(arg1, arg3.length);
        arg1.write(arg3);
    }

    private void writeLength(OutputStream arg3, int arg4) throws IOException {
        if(arg4 > 0x7F) {
            int v1 = 1;
            int v0 = arg4;
            while(true) {
                v0 >>>= 8;
                if(v0 == 0) {
                    break;
                }

                ++v1;
            }

            arg3.write(((byte)(v1 | 0x80)));
            for(v1 = (v1 - 1) * 8; v1 >= 0; v1 += -8) {
                arg3.write(((byte)(arg4 >> v1)));
            }

            return;
        }

        arg3.write(((byte)arg4));
    }
}

