package org.bouncycastle.asn1.crmf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Time;

public class OptionalValidity extends ASN1Object {
    private Time notAfter;
    private Time notBefore;

    private OptionalValidity(ASN1Sequence arg4) {
        super();
        Enumeration v4 = arg4.getObjects();
        while(v4.hasMoreElements()) {
            Object v0 = v4.nextElement();
            int v1 = ((ASN1TaggedObject)v0).getTagNo();
            Time v0_1 = Time.getInstance(((ASN1TaggedObject)v0), true);
            if(v1 == 0) {
                this.notBefore = v0_1;
                continue;
            }

            this.notAfter = v0_1;
        }
    }

    public OptionalValidity(Time arg1, Time arg2) {
        super();
        if(arg1 == null) {
            if(arg2 != null) {
            }
            else {
                throw new IllegalArgumentException("at least one of notBefore/notAfter MUST be present.");
            }
        }

        this.notBefore = arg1;
        this.notAfter = arg2;
    }

    public static OptionalValidity getInstance(Object arg1) {
        if((arg1 instanceof OptionalValidity)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OptionalValidity(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static OptionalValidity getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return new OptionalValidity(ASN1Sequence.getInstance(arg1, arg2));
    }

    public Time getNotAfter() {
        return this.notAfter;
    }

    public Time getNotBefore() {
        return this.notBefore;
    }

    public static OptionalValidity getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return new OptionalValidity(ASN1Sequence.getTagged(arg1, arg2));
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        if(this.notBefore != null) {
            v0.add(new DERTaggedObject(true, 0, this.notBefore));
        }

        if(this.notAfter != null) {
            v0.add(new DERTaggedObject(true, 1, this.notAfter));
        }

        return new DERSequence(v0);
    }
}

