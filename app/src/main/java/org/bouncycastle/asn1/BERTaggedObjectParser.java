package org.bouncycastle.asn1;

import java.io.IOException;

class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    final ASN1StreamParser _parser;
    final int _tagClass;
    final int _tagNo;

    BERTaggedObjectParser(int arg1, int arg2, ASN1StreamParser arg3) {
        super();
        this._tagClass = arg1;
        this._tagNo = arg2;
        this._parser = arg3;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return this._parser.loadTaggedIL(this._tagClass, this._tagNo);
    }

    public int getTagClass() {
        return this._tagClass;
    }

    public int getTagNo() {
        return this._tagNo;
    }

    public boolean hasContextTag() {
        if(this._tagClass == 0x80) {
            return 1;
        }

        return 0;
    }

    public boolean hasContextTag(int arg3) {
        if(this._tagClass == 0x80 && this._tagNo == arg3) {
            return 1;
        }

        return 0;
    }

    public boolean hasTag(int arg2, int arg3) {
        if(this._tagClass == arg2 && this._tagNo == arg3) {
            return 1;
        }

        return 0;
    }

    public boolean hasTagClass(int arg1) {
        if(this._tagClass == arg1) {
            return 1;
        }

        return 0;
    }

    public ASN1Encodable parseBaseUniversal(boolean arg1, int arg2) throws IOException {
        ASN1StreamParser v0 = this._parser;
        if(arg1) {
            return v0.parseObject(arg2);
        }

        return v0.parseImplicitConstructedIL(arg2);
    }

    public ASN1Encodable parseExplicitBaseObject() throws IOException {
        return this._parser.readObject();
    }

    public ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException {
        return this._parser.parseTaggedObject();
    }

    public ASN1TaggedObjectParser parseImplicitBaseTagged(int arg2, int arg3) throws IOException {
        return new BERTaggedObjectParser(arg2, arg3, this._parser);
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return this.getLoadedObject();
        }
        catch(IOException v1) {
            throw new ASN1ParsingException(v1.getMessage());
        }
    }
}

