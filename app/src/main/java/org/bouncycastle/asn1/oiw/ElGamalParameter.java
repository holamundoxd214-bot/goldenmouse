package org.bouncycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ElGamalParameter extends ASN1Object {
    ASN1Integer g;
    ASN1Integer p;

    public ElGamalParameter(BigInteger arg2, BigInteger arg3) {
        super();
        this.p = new ASN1Integer(arg2);
        this.g = new ASN1Integer(arg3);
    }

    private ElGamalParameter(ASN1Sequence arg2) {
        super();
        Enumeration v2 = arg2.getObjects();
        this.p = v2.nextElement();
        this.g = v2.nextElement();
    }

    public BigInteger getG() {
        return this.g.getPositiveValue();
    }

    public static ElGamalParameter getInstance(Object arg1) {
        if((arg1 instanceof ElGamalParameter)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ElGamalParameter(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public BigInteger getP() {
        return this.p.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.p, this.g);
    }
}

