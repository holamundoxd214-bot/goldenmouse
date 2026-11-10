package org.bouncycastle.asn1;

import java.io.IOException;

class DLTaggedObjectParser extends BERTaggedObjectParser {
    private final boolean _constructed;

    DLTaggedObjectParser(int arg1, int arg2, boolean arg3, ASN1StreamParser arg4) {
        super(arg1, arg2, arg4);
        this._constructed = arg3;
    }

    private ASN1StreamParser checkConstructed() throws IOException {
        if(this._constructed) {
            return this._parser;
        }

        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return this._parser.loadTaggedDL(this._tagClass, this._tagNo, this._constructed);
    }

    public ASN1Encodable parseBaseUniversal(boolean arg1, int arg2) throws IOException {
        if(arg1) {
            return this.checkConstructed().parseObject(arg2);
        }

        arg1 = this._constructed;
        ASN1StreamParser v0 = this._parser;
        if(arg1) {
            return v0.parseImplicitConstructedDL(arg2);
        }

        return v0.parseImplicitPrimitive(arg2);
    }

    public ASN1Encodable parseExplicitBaseObject() throws IOException {
        return this.checkConstructed().readObject();
    }

    public ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException {
        return this.checkConstructed().parseTaggedObject();
    }

    public ASN1TaggedObjectParser parseImplicitBaseTagged(int arg3, int arg4) throws IOException {
        return new DLTaggedObjectParser(arg3, arg4, this._constructed, this._parser);
    }
}

