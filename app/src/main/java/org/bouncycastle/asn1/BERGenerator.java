package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public abstract class BERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged;

    protected BERGenerator(OutputStream arg1) {
        super(arg1);
        this._tagged = false;
    }

    protected BERGenerator(OutputStream arg1, int arg2, boolean arg3) {
        super(arg1);
        this._tagged = true;
        this._isExplicit = arg3;
        this._tagNo = arg2;
    }

    public OutputStream getRawOutputStream() {
        return this._out;
    }

    protected void writeBEREnd() throws IOException {
        this._out.write(0);
        this._out.write(0);
        if((this._tagged) && (this._isExplicit)) {
            this._out.write(0);
            this._out.write(0);
        }
    }

    protected void writeBERHeader(int arg4) throws IOException {
        if(!this._tagged) {
            goto label_16;
        }

        int v0 = this._tagNo;
        int v1 = v0 | 0x80;
        if(this._isExplicit) {
            this.writeHdr(v0 | 0xA0);
        }
        else if((arg4 & 0x20) != 0) {
            arg4 = v0 | 0xA0;
        }
        else {
            goto label_14;
        }

        this.writeHdr(arg4);
        return;
    label_14:
        this.writeHdr(v1);
        return;
    label_16:
        this.writeHdr(arg4);
    }

    private void writeHdr(int arg2) throws IOException {
        this._out.write(arg2);
        this._out.write(0x80);
    }
}

