package org.bouncycastle.asn1;

final class ASN1Tag {
    private final int tagClass;
    private final int tagNumber;

    private ASN1Tag(int arg1, int arg2) {
        super();
        this.tagClass = arg1;
        this.tagNumber = arg2;
    }

    static ASN1Tag create(int arg1, int arg2) {
        return new ASN1Tag(arg1, arg2);
    }

    int getTagClass() {
        return this.tagClass;
    }

    int getTagNumber() {
        return this.tagNumber;
    }
}

