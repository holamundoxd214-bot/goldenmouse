package org.bouncycastle.asn1;

class DERFactory {
    static final DERSequence EMPTY_SEQUENCE;
    static final DERSet EMPTY_SET;

    static {
        DERFactory.EMPTY_SEQUENCE = new DERSequence();
        DERFactory.EMPTY_SET = new DERSet();
    }

    DERFactory() {
        super();
    }

    static DERSequence createSequence(ASN1EncodableVector arg2) {
        if(arg2.size() < 1) {
            return DERFactory.EMPTY_SEQUENCE;
        }

        return new DERSequence(arg2);
    }

    static DERSet createSet(ASN1EncodableVector arg2) {
        if(arg2.size() < 1) {
            return DERFactory.EMPTY_SET;
        }

        return new DERSet(arg2);
    }
}

