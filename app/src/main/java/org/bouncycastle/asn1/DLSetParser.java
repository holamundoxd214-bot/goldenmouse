package org.bouncycastle.asn1;

import java.io.IOException;

@Deprecated public class DLSetParser implements ASN1SetParser {
    private ASN1StreamParser _parser;

    DLSetParser(ASN1StreamParser arg1) {
        super();
        this._parser = arg1;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return DLFactory.createSet(this._parser.readVector());
    }

    public ASN1Encodable readObject() throws IOException {
        return this._parser.readObject();
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return this.getLoadedObject();
        }
        catch(IOException v2) {
            throw new ASN1ParsingException(v2.getMessage(), ((Throwable)v2));
        }
    }
}

