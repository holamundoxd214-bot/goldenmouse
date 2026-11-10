package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class AdmissionSyntax extends ASN1Object {
    private GeneralName admissionAuthority;
    private ASN1Sequence contentsOfAdmissions;

    private AdmissionSyntax(ASN1Sequence arg5) {
        ASN1Encodable v5;
        super();
        int v0 = arg5.size();
        if(v0 == 1) {
            v5 = arg5.getObjectAt(0);
        }
        else if(v0 == 2) {
            this.admissionAuthority = GeneralName.getInstance(arg5.getObjectAt(0));
            v5 = arg5.getObjectAt(1);
        }
        else {
            throw new IllegalArgumentException("Bad sequence size: " + arg5.size());
        }

        this.contentsOfAdmissions = DERSequence.getInstance(v5);
    }

    public AdmissionSyntax(GeneralName arg1, ASN1Sequence arg2) {
        super();
        this.admissionAuthority = arg1;
        this.contentsOfAdmissions = arg2;
    }

    public GeneralName getAdmissionAuthority() {
        return this.admissionAuthority;
    }

    public Admissions[] getContentsOfAdmissions() {
        Admissions[] v0 = new Admissions[this.contentsOfAdmissions.size()];
        Enumeration v4 = this.contentsOfAdmissions.getObjects();
        int v1;
        for(v1 = 0; v4.hasMoreElements(); ++v1) {
            v0[v1] = Admissions.getInstance(v4.nextElement());
        }

        return v0;
    }

    public static AdmissionSyntax getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof AdmissionSyntax)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new AdmissionSyntax(((ASN1Sequence)arg3));
            }
            else {
                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        GeneralName v1 = this.admissionAuthority;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        v0.add(this.contentsOfAdmissions);
        return new DERSequence(v0);
    }
}

