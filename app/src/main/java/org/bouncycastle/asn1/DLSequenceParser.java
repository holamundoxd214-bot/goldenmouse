package org.bouncycastle.asn1;

import java.io.IOException;

@Deprecated public class DLSequenceParser implements ASN1SequenceParser {
    private ASN1StreamParser _parser;

    DLSequenceParser(ASN1StreamParser arg1) {
        super();
        this._parser = arg1;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return DLFactory.createSequence(this._parser.readVector());
    }

    public ASN1Encodable readObject() throws IOException {
        return this._parser.readObject();
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return this.getLoadedObject();
        }
        catch(IOException v1) {
            throw new IllegalStateException(v1.getMessage());
        }
    }
}

