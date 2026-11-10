package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

@Deprecated public class DLBitStringParser implements ASN1BitStringParser {
    private int padBits;
    private final DefiniteLengthInputStream stream;

    DLBitStringParser(DefiniteLengthInputStream arg2) {
        super();
        this.padBits = 0;
        this.stream = arg2;
    }

    private InputStream getBitStream(boolean arg4) throws IOException {
        int v0 = this.stream.getRemaining();
        if(v0 >= 1) {
            int v1 = this.stream.read();
            this.padBits = v1;
            if(v1 > 0) {
                if(v0 < 2) {
                    throw new IllegalStateException("zero length data with non-zero pad bits");
                }
                else if(v1 > 7) {
                    throw new IllegalStateException("pad bits cannot be greater than 7 or less than 0");
                }
                else if(!arg4) {
                }
                else {
                    throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.padBits);
                }
            }

            return this.stream;
        }

        throw new IllegalStateException("content octets cannot be empty");
    }

    public InputStream getBitStream() throws IOException {
        return this.getBitStream(false);
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return ASN1BitString.createPrimitive(this.stream.toByteArray());
    }

    public InputStream getOctetStream() throws IOException {
        return this.getBitStream(true);
    }

    public int getPadBits() {
        return this.padBits;
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return this.getLoadedObject();
        }
        catch(IOException v3) {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + v3.getMessage(), ((Throwable)v3));
        }
    }
}

