package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.Time;

public class CRLStatus extends ASN1Object {
    private final CRLSource source;
    private final Time thisUpdate;

    private CRLStatus(ASN1Sequence arg4) {
        super();
        int v1 = 2;
        if(arg4.size() != 1) {
            if(arg4.size() == v1) {
            }
            else {
                throw new IllegalArgumentException("expected sequence size of 1 or 2, got " + arg4.size());
            }
        }

        this.source = CRLSource.getInstance(arg4.getObjectAt(0));
        Time v4 = arg4.size() == v1 ? Time.getInstance(arg4.getObjectAt(1)) : null;
        this.thisUpdate = v4;
    }

    public CRLStatus(CRLSource arg1, Time arg2) {
        super();
        this.source = arg1;
        this.thisUpdate = arg2;
    }

    public static CRLStatus getInstance(Object arg1) {
        if((arg1 instanceof CRLStatus)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CRLStatus(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public CRLSource getSource() {
        return this.source;
    }

    public Time getThisUpdate() {
        return this.thisUpdate;
    }

    public Time getTime() {
        return this.thisUpdate;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.source);
        Time v2 = this.thisUpdate;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

