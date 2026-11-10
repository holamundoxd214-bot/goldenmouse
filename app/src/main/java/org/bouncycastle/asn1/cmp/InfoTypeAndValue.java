package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class InfoTypeAndValue extends ASN1Object {
    private final ASN1ObjectIdentifier infoType;
    private final ASN1Encodable infoValue;

    public InfoTypeAndValue(ASN1ObjectIdentifier arg2) {
        this(arg2, null);
    }

    public InfoTypeAndValue(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        if(arg1 != null) {
            this.infoType = arg1;
            this.infoValue = arg2;
            return;
        }

        throw new NullPointerException("\'infoType\' cannot be null");
    }

    private InfoTypeAndValue(ASN1Sequence arg3) {
        super();
        this.infoType = ASN1ObjectIdentifier.getInstance(arg3.getObjectAt(0));
        ASN1Encodable v3 = arg3.size() > 1 ? arg3.getObjectAt(1) : null;
        this.infoValue = v3;
    }

    public ASN1ObjectIdentifier getInfoType() {
        return this.infoType;
    }

    public ASN1Encodable getInfoValue() {
        return this.infoValue;
    }

    public static InfoTypeAndValue getInstance(Object arg1) {
        if((arg1 instanceof InfoTypeAndValue)) {
            return arg1;
        }

        if(arg1 != null) {
            return new InfoTypeAndValue(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.infoType);
        ASN1Encodable v2 = this.infoValue;
        if(v2 != null) {
            v0.add(v2);
        }

        return new DERSequence(v0);
    }
}

