package org.bouncycastle.asn1;

class DLFactory {
    static final DLSequence EMPTY_SEQUENCE;
    static final DLSet EMPTY_SET;

    static {
        DLFactory.EMPTY_SEQUENCE = new DLSequence();
        DLFactory.EMPTY_SET = new DLSet();
    }

    DLFactory() {
        super();
    }

    static DLSequence createSequence(ASN1EncodableVector arg2) {
        if(arg2.size() < 1) {
            return DLFactory.EMPTY_SEQUENCE;
        }

        return new DLSequence(arg2);
    }

    static DLSet createSet(ASN1EncodableVector arg2) {
        if(arg2.size() < 1) {
            return DLFactory.EMPTY_SET;
        }

        return new DLSet(arg2);
    }
}

