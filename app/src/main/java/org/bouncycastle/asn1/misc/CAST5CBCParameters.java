package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class CAST5CBCParameters extends ASN1Object {
    ASN1OctetString iv;
    ASN1Integer keyLength;

    private CAST5CBCParameters(ASN1Sequence arg2) {
        super();
        this.iv = arg2.getObjectAt(0);
        this.keyLength = arg2.getObjectAt(1);
    }

    public CAST5CBCParameters(byte[] arg3, int arg4) {
        super();
        this.iv = new DEROctetString(Arrays.clone(arg3));
        this.keyLength = new ASN1Integer(((long)arg4));
    }

    public byte[] getIV() {
        return Arrays.clone(this.iv.getOctets());
    }

    public static CAST5CBCParameters getInstance(Object arg1) {
        if((arg1 instanceof CAST5CBCParameters)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CAST5CBCParameters(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public int getKeyLength() {
        return this.keyLength.intValueExact();
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.iv, this.keyLength);
    }
}

