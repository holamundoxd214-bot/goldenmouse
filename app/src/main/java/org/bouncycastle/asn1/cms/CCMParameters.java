package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class CCMParameters extends ASN1Object {
    private int icvLen;
    private byte[] nonce;

    private CCMParameters(ASN1Sequence arg3) {
        super();
        this.nonce = ASN1OctetString.getInstance(arg3.getObjectAt(0)).getOctets();
        int v3 = arg3.size() == 2 ? ASN1Integer.getInstance(arg3.getObjectAt(1)).intValueExact() : 12;
        this.icvLen = v3;
    }

    public CCMParameters(byte[] arg1, int arg2) {
        super();
        this.nonce = Arrays.clone(arg1);
        this.icvLen = arg2;
    }

    public int getIcvLen() {
        return this.icvLen;
    }

    public static CCMParameters getInstance(Object arg1) {
        if((arg1 instanceof CCMParameters)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CCMParameters(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public byte[] getNonce() {
        return Arrays.clone(this.nonce);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(new DEROctetString(this.nonce));
        if(this.icvLen != 12) {
            v0.add(new ASN1Integer(((long)this.icvLen)));
        }

        return new DERSequence(v0);
    }
}

