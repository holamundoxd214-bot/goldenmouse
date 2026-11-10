package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class ASN1OutputStream {
    private OutputStream os;

    ASN1OutputStream(OutputStream arg1) {
        super();
        this.os = arg1;
    }

    public void close() throws IOException {
        this.os.close();
    }

    public static ASN1OutputStream create(OutputStream arg1) {
        return new ASN1OutputStream(arg1);
    }

    public static ASN1OutputStream create(OutputStream arg1, String arg2) {
        if(arg2.equals("DER")) {
            return new DEROutputStream(arg1);
        }

        if(arg2.equals("DL")) {
            return new DLOutputStream(arg1);
        }

        return new ASN1OutputStream(arg1);
    }

    public void flush() throws IOException {
        this.os.flush();
    }

    void flushInternal() throws IOException {
    }

    DEROutputStream getDERSubStream() {
        return new DEROutputStream(this.os);
    }

    DLOutputStream getDLSubStream() {
        return new DLOutputStream(this.os);
    }

    static int getLengthOfDL(int arg1) {
        if(arg1 < 0x80) {
            return 1;
        }

        int v0;
        for(v0 = 2; true; ++v0) {
            arg1 >>>= 8;
            if(arg1 == 0) {
                return v0;
            }
        }

        return v0;
    }

    static int getLengthOfEncodingDL(boolean arg1, int arg2) {
        return (((int)arg1)) + ASN1OutputStream.getLengthOfDL(arg2) + arg2;
    }

    static int getLengthOfIdentifier(int arg1) {
        if(arg1 < 0x1F) {
            return 1;
        }

        int v0;
        for(v0 = 2; true; ++v0) {
            arg1 >>>= 7;
            if(arg1 == 0) {
                return v0;
            }
        }

        return v0;
    }

    final void write(byte[] arg1, int arg2, int arg3) throws IOException {
        this.os.write(arg1, arg2, arg3);
    }

    final void write(int arg1) throws IOException {
        this.os.write(arg1);
    }

    final void writeDL(int arg6) throws IOException {
        int v3;
        int v0 = 0x80;
        if(arg6 < v0) {
            this.write(arg6);
            return;
        }

        int v1 = 5;
        byte[] v2 = new byte[v1];
        while(true) {
            v3 = v1 - 1;
            v2[v3] = ((byte)arg6);
            arg6 >>>= 8;
            if(arg6 == 0) {
                break;
            }

            v1 = v3;
        }

        v1 += -2;
        v2[v1] = ((byte)(5 - v3 | v0));
        this.write(v2, v1, 6 - v3);
    }

    void writeElements(ASN1Encodable[] arg5) throws IOException {
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5[v1].toASN1Primitive().encode(this, true);
        }
    }

    final void writeEncodingDL(boolean arg1, int arg2, byte arg3) throws IOException {
        this.writeIdentifier(arg1, arg2);
        this.writeDL(1);
        this.write(arg3);
    }

    final void writeEncodingDL(boolean arg1, int arg2, byte[] arg3) throws IOException {
        this.writeIdentifier(arg1, arg2);
        this.writeDL(arg3.length);
        this.write(arg3, 0, arg3.length);
    }

    final void writeEncodingDL(boolean arg1, int arg2, byte arg3, byte[] arg4, int arg5, int arg6) throws IOException {
        this.writeIdentifier(arg1, arg2);
        this.writeDL(arg6 + 1);
        this.write(arg3);
        this.write(arg4, arg5, arg6);
    }

    final void writeEncodingDL(boolean arg1, int arg2, int arg3, byte[] arg4) throws IOException {
        this.writeIdentifier(arg1, arg2, arg3);
        this.writeDL(arg4.length);
        this.write(arg4, 0, arg4.length);
    }

    final void writeEncodingDL(boolean arg1, int arg2, byte[] arg3, int arg4, int arg5) throws IOException {
        this.writeIdentifier(arg1, arg2);
        this.writeDL(arg5);
        this.write(arg3, arg4, arg5);
    }

    final void writeEncodingDL(boolean arg1, int arg2, byte[] arg3, int arg4, int arg5, byte arg6) throws IOException {
        this.writeIdentifier(arg1, arg2);
        this.writeDL(arg5 + 1);
        this.write(arg3, arg4, arg5);
        this.write(arg6);
    }

    final void writeEncodingIL(boolean arg1, int arg2, ASN1Encodable[] arg3) throws IOException {
        this.writeIdentifier(arg1, arg2);
        this.write(0x80);
        this.writeElements(arg3);
        this.write(0);
        this.write(0);
    }

    final void writeIdentifier(boolean arg1, int arg2) throws IOException {
        if(arg1) {
            this.write(arg2);
        }
    }

    final void writeIdentifier(boolean arg4, int arg5, int arg6) throws IOException {
        if(!arg4) {
            return;
        }

        int v4 = 0x1F;
        if(arg6 < v4) {
            this.write(arg5 | arg6);
            return;
        }

        byte[] v0 = new byte[6];
        int v2 = 5;
        v0[v2] = ((byte)(arg6 & 0x7F));
        while(arg6 > 0x7F) {
            arg6 >>>= 7;
            --v2;
            v0[v2] = ((byte)(arg6 & 0x7F | 0x80));
        }

        --v2;
        v0[v2] = ((byte)(v4 | arg5));
        this.write(v0, v2, 6 - v2);
    }

    public final void writeObject(ASN1Encodable arg2) throws IOException {
        if(arg2 != null) {
            this.writePrimitive(arg2.toASN1Primitive(), true);
            this.flushInternal();
            return;
        }

        throw new IOException("null object detected");
    }

    public final void writeObject(ASN1Primitive arg2) throws IOException {
        if(arg2 != null) {
            this.writePrimitive(arg2, true);
            this.flushInternal();
            return;
        }

        throw new IOException("null object detected");
    }

    void writePrimitive(ASN1Primitive arg1, boolean arg2) throws IOException {
        arg1.encode(this, arg2);
    }

    void writePrimitives(ASN1Primitive[] arg5) throws IOException {
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5[v1].encode(this, true);
        }
    }
}

