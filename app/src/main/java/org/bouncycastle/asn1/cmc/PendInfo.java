package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class PendInfo extends ASN1Object {
    private final ASN1GeneralizedTime pendTime;
    private final byte[] pendToken;

    private PendInfo(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.pendToken = Arrays.clone(ASN1OctetString.getInstance(arg3.getObjectAt(0)).getOctets());
            this.pendTime = ASN1GeneralizedTime.getInstance(arg3.getObjectAt(1));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public PendInfo(byte[] arg1, ASN1GeneralizedTime arg2) {
        super();
        this.pendToken = Arrays.clone(arg1);
        this.pendTime = arg2;
    }

    public static PendInfo getInstance(Object arg1) {
        if((arg1 instanceof PendInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PendInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1GeneralizedTime getPendTime() {
        return this.pendTime;
    }

    public byte[] getPendToken() {
        return Arrays.clone(this.pendToken);
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new DEROctetString(this.pendToken), this.pendTime);
    }
}

