package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

@Deprecated public class DEROctetStringParser implements ASN1OctetStringParser {
    private DefiniteLengthInputStream stream;

    DEROctetStringParser(DefiniteLengthInputStream arg1) {
        super();
        this.stream = arg1;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return new DEROctetString(this.stream.toByteArray());
    }

    public InputStream getOctetStream() {
        return this.stream;
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

