package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Sequence;

public class NestedMessageContent extends PKIMessages {
    public NestedMessageContent(ASN1Sequence arg1) {
        super(arg1);
    }

    public NestedMessageContent(PKIMessage arg1) {
        super(arg1);
    }

    public NestedMessageContent(PKIMessage[] arg1) {
        super(arg1);
    }

    public static NestedMessageContent getInstance(Object arg1) {
        if((arg1 instanceof NestedMessageContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new NestedMessageContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }
}

