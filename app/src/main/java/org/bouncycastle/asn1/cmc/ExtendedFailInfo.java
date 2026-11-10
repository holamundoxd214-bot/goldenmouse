package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ExtendedFailInfo extends ASN1Object {
    private final ASN1ObjectIdentifier failInfoOID;
    private final ASN1Encodable failInfoValue;

    public ExtendedFailInfo(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        this.failInfoOID = arg1;
        this.failInfoValue = arg2;
    }

    private ExtendedFailInfo(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.failInfoOID = ASN1ObjectIdentifier.getInstance(arg3.getObjectAt(0));
            this.failInfoValue = arg3.getObjectAt(1);
            return;
        }

        throw new IllegalArgumentException("Sequence must be 2 elements.");
    }

    public ASN1ObjectIdentifier getFailInfoOID() {
        return this.failInfoOID;
    }

    public ASN1Encodable getFailInfoValue() {
        return this.failInfoValue;
    }

    public static ExtendedFailInfo getInstance(Object arg1) {
        if((arg1 instanceof ExtendedFailInfo)) {
            return arg1;
        }

        if((arg1 instanceof ASN1Encodable)) {
            ASN1Primitive v1 = ((ASN1Encodable)arg1).toASN1Primitive();
            if((v1 instanceof ASN1Sequence)) {
                return new ExtendedFailInfo(((ASN1Sequence)v1));
            }
        }
        else if((arg1 instanceof byte[])) {
            return ExtendedFailInfo.getInstance(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.failInfoOID, this.failInfoValue});
    }
}

