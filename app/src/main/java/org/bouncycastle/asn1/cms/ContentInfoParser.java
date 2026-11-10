package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.ASN1Util;

public class ContentInfoParser {
    private ASN1TaggedObjectParser content;
    private ASN1ObjectIdentifier contentType;

    public ContentInfoParser(ASN1SequenceParser arg2) throws IOException {
        super();
        this.contentType = arg2.readObject();
        this.content = arg2.readObject();
    }

    public ASN1Encodable getContent(int arg1) throws IOException {
        ASN1TaggedObjectParser v0 = this.content;
        if(v0 != null) {
            return ASN1Util.parseExplicitContextBaseObject(v0, 0);
        }

        return null;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }
}

