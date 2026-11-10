package org.bouncycastle.asn1;

import java.io.IOException;

public interface ASN1TaggedObjectParser extends ASN1Encodable, InMemoryRepresentable {
    int getTagClass();

    int getTagNo();

    boolean hasContextTag();

    boolean hasContextTag(int arg1);

    boolean hasTag(int arg1, int arg2);

    boolean hasTagClass(int arg1);

    ASN1Encodable parseBaseUniversal(boolean arg1, int arg2) throws IOException;

    ASN1Encodable parseExplicitBaseObject() throws IOException;

    ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException;

    ASN1TaggedObjectParser parseImplicitBaseTagged(int arg1, int arg2) throws IOException;
}

