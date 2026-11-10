package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class GenMsgContent extends ASN1Object {
    private final ASN1Sequence content;

    private GenMsgContent(ASN1Sequence arg1) {
        super();
        this.content = arg1;
    }

    public GenMsgContent(InfoTypeAndValue arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable)arg2));
    }

    public GenMsgContent(InfoTypeAndValue[] arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable[])arg2));
    }

    public static GenMsgContent getInstance(Object arg1) {
        if((arg1 instanceof GenMsgContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new GenMsgContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public InfoTypeAndValue[] toInfoTypeAndValueArray() {
        int v0 = this.content.size();
        InfoTypeAndValue[] v1 = new InfoTypeAndValue[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = InfoTypeAndValue.getInstance(this.content.getObjectAt(v2));
        }

        return v1;
    }
}

