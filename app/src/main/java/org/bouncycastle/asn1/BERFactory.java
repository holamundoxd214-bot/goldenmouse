package org.bouncycastle.asn1;

class BERFactory {
    static final BERSequence EMPTY_SEQUENCE;
    static final BERSet EMPTY_SET;

    static {
        BERFactory.EMPTY_SEQUENCE = new BERSequence();
        BERFactory.EMPTY_SET = new BERSet();
    }

    BERFactory() {
        super();
    }

    static BERSequence createSequence(ASN1EncodableVector arg2) {
        if(arg2.size() < 1) {
            return BERFactory.EMPTY_SEQUENCE;
        }

        return new BERSequence(arg2);
    }

    static BERSet createSet(ASN1EncodableVector arg2) {
        if(arg2.size() < 1) {
            return BERFactory.EMPTY_SET;
        }

        return new BERSet(arg2);
    }
}

