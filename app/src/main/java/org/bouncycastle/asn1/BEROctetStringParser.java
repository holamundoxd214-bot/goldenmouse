package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

@Deprecated public class BEROctetStringParser implements ASN1OctetStringParser {
    private ASN1StreamParser _parser;

    BEROctetStringParser(ASN1StreamParser arg1) {
        super();
        this._parser = arg1;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return BEROctetStringParser.parse(this._parser);
    }

    public InputStream getOctetStream() {
        return new ConstructedOctetStream(this._parser);
    }

    static BEROctetString parse(ASN1StreamParser arg2) throws IOException {
        return new BEROctetString(Streams.readAll(new ConstructedOctetStream(arg2)));
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

