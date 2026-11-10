package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CAKeyUpdAnnContent extends ASN1Object {
    private final CMPCertificate newWithNew;
    private final CMPCertificate newWithOld;
    private final CMPCertificate oldWithNew;

    private CAKeyUpdAnnContent(ASN1Sequence arg2) {
        super();
        this.oldWithNew = CMPCertificate.getInstance(arg2.getObjectAt(0));
        this.newWithOld = CMPCertificate.getInstance(arg2.getObjectAt(1));
        this.newWithNew = CMPCertificate.getInstance(arg2.getObjectAt(2));
    }

    public CAKeyUpdAnnContent(CMPCertificate arg1, CMPCertificate arg2, CMPCertificate arg3) {
        super();
        this.oldWithNew = arg1;
        this.newWithOld = arg2;
        this.newWithNew = arg3;
    }

    public static CAKeyUpdAnnContent getInstance(Object arg1) {
        if((arg1 instanceof CAKeyUpdAnnContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CAKeyUpdAnnContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public CMPCertificate getNewWithNew() {
        return this.newWithNew;
    }

    public CMPCertificate getNewWithOld() {
        return this.newWithOld;
    }

    public CMPCertificate getOldWithNew() {
        return this.oldWithNew;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.oldWithNew);
        v0.add(this.newWithOld);
        v0.add(this.newWithNew);
        return new DERSequence(v0);
    }
}

