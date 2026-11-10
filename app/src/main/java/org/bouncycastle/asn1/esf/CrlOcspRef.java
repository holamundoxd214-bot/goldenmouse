package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CrlOcspRef extends ASN1Object {
    private CrlListID crlids;
    private OcspListID ocspids;
    private OtherRevRefs otherRev;

    private CrlOcspRef(ASN1Sequence arg4) {
        super();
        Enumeration v4 = arg4.getObjects();
        while(v4.hasMoreElements()) {
            ASN1TaggedObject v0 = ASN1TaggedObject.getInstance(v4.nextElement(), 0x80);
            int v1 = v0.getTagNo();
            if(v1 != 0) {
                if(v1 != 1) {
                    if(v1 == 2) {
                        this.otherRev = OtherRevRefs.getInstance(v0.getExplicitBaseObject());
                        continue;
                    }

                    throw new IllegalArgumentException("illegal tag");
                }

                this.ocspids = OcspListID.getInstance(v0.getExplicitBaseObject());
                continue;
            }

            this.crlids = CrlListID.getInstance(v0.getExplicitBaseObject());
        }
    }

    public CrlOcspRef(CrlListID arg1, OcspListID arg2, OtherRevRefs arg3) {
        super();
        this.crlids = arg1;
        this.ocspids = arg2;
        this.otherRev = arg3;
    }

    public CrlListID getCrlids() {
        return this.crlids;
    }

    public static CrlOcspRef getInstance(Object arg1) {
        if((arg1 instanceof CrlOcspRef)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CrlOcspRef(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public OcspListID getOcspids() {
        return this.ocspids;
    }

    public OtherRevRefs getOtherRev() {
        return this.otherRev;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        if(this.crlids != null) {
            v0.add(new DERTaggedObject(true, 0, this.crlids.toASN1Primitive()));
        }

        if(this.ocspids != null) {
            v0.add(new DERTaggedObject(true, 1, this.ocspids.toASN1Primitive()));
        }

        if(this.otherRev != null) {
            v0.add(new DERTaggedObject(true, 2, this.otherRev.toASN1Primitive()));
        }

        return new DERSequence(v0);
    }
}

