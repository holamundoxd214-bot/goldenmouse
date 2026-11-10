package org.bouncycastle.asn1;

import java.io.IOException;

public class DERExternalParser implements ASN1ExternalParser {
    private ASN1StreamParser _parser;

    public DERExternalParser(ASN1StreamParser arg1) {
        super();
        this._parser = arg1;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return DERExternalParser.parse(this._parser);
    }

    static DLExternal parse(ASN1StreamParser arg2) throws IOException {
        try {
            return new DLExternal(new DLSequence(arg2.readVector()));
        }
        catch(IllegalArgumentException v2) {
            throw new ASN1Exception(v2.getMessage(), ((Throwable)v2));
        }
    }

    public ASN1Encodable readObject() throws IOException {
        return this._parser.readObject();
    }

    public ASN1Primitive toASN1Primitive() {
        String v0 = "unable to get DER object";
        try {
            return this.getLoadedObject();
        }
        catch(IllegalArgumentException v2) {
            throw new ASN1ParsingException(v0, ((Throwable)v2));
        }
        catch(IOException v2_1) {
            throw new ASN1ParsingException(v0, ((Throwable)v2_1));
        }
    }
}

