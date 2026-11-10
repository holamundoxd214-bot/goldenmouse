package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

@Deprecated public class BERBitStringParser implements ASN1BitStringParser {
    private ConstructedBitStream _bitStream;
    private ASN1StreamParser _parser;

    BERBitStringParser(ASN1StreamParser arg1) {
        super();
        this._parser = arg1;
    }

    public InputStream getBitStream() throws IOException {
        ConstructedBitStream v0 = new ConstructedBitStream(this._parser, false);
        this._bitStream = v0;
        return ((InputStream)v0);
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return BERBitStringParser.parse(this._parser);
    }

    public InputStream getOctetStream() throws IOException {
        ConstructedBitStream v0 = new ConstructedBitStream(this._parser, true);
        this._bitStream = v0;
        return ((InputStream)v0);
    }

    public int getPadBits() {
        return this._bitStream.getPadBits();
    }

    static BERBitString parse(ASN1StreamParser arg2) throws IOException {
        ConstructedBitStream v0 = new ConstructedBitStream(arg2, false);
        return new BERBitString(Streams.readAll(((InputStream)v0)), v0.getPadBits());
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

