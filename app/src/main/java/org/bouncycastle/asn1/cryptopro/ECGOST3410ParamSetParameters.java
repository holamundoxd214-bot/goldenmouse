package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class ECGOST3410ParamSetParameters extends ASN1Object {
    ASN1Integer a;
    ASN1Integer b;
    ASN1Integer p;
    ASN1Integer q;
    ASN1Integer x;
    ASN1Integer y;

    public ECGOST3410ParamSetParameters(BigInteger arg2, BigInteger arg3, BigInteger arg4, BigInteger arg5, int arg6, BigInteger arg7) {
        super();
        this.a = new ASN1Integer(arg2);
        this.b = new ASN1Integer(arg3);
        this.p = new ASN1Integer(arg4);
        this.q = new ASN1Integer(arg5);
        this.x = new ASN1Integer(((long)arg6));
        this.y = new ASN1Integer(arg7);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence arg2) {
        super();
        Enumeration v2 = arg2.getObjects();
        this.a = v2.nextElement();
        this.b = v2.nextElement();
        this.p = v2.nextElement();
        this.q = v2.nextElement();
        this.x = v2.nextElement();
        this.y = v2.nextElement();
    }

    public BigInteger getA() {
        return this.a.getPositiveValue();
    }

    public static ECGOST3410ParamSetParameters getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ECGOST3410ParamSetParameters)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new ECGOST3410ParamSetParameters(((ASN1Sequence)arg3));
            }
            else {
                throw new IllegalArgumentException("Invalid GOST3410Parameter: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return ECGOST3410ParamSetParameters.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public BigInteger getP() {
        return this.p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.q.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(6);
        v0.add(this.a);
        v0.add(this.b);
        v0.add(this.p);
        v0.add(this.q);
        v0.add(this.x);
        v0.add(this.y);
        return new DERSequence(v0);
    }
}

