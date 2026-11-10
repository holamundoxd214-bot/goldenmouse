package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.GeneralName;

public class Admissions extends ASN1Object {
    private GeneralName admissionAuthority;
    private NamingAuthority namingAuthority;
    private ASN1Sequence professionInfos;

    private Admissions(ASN1Sequence arg5) {
        super();
        if(arg5.size() <= 3) {
            Enumeration v5 = arg5.getObjects();
            Object v0 = v5.nextElement();
            String v2 = "Bad tag number: ";
            if((v0 instanceof ASN1TaggedObject)) {
                int v1 = ((ASN1TaggedObject)v0).getTagNo();
                if(v1 == 0) {
                    this.admissionAuthority = GeneralName.getInstance(((ASN1TaggedObject)v0), true);
                }
                else if(v1 == 1) {
                    this.namingAuthority = NamingAuthority.getInstance(((ASN1TaggedObject)v0), true);
                }
                else {
                    throw new IllegalArgumentException(v2 + ((ASN1TaggedObject)v0).getTagNo());
                }

                v0 = v5.nextElement();
            }

            if((v0 instanceof ASN1TaggedObject)) {
                if(((ASN1TaggedObject)v0).getTagNo() == 1) {
                    this.namingAuthority = NamingAuthority.getInstance(((ASN1TaggedObject)v0), true);
                    v0 = v5.nextElement();
                }
                else {
                    throw new IllegalArgumentException(v2 + ((ASN1TaggedObject)v0).getTagNo());
                }
            }

            this.professionInfos = ASN1Sequence.getInstance(v0);
            if(!v5.hasMoreElements()) {
                return;
            }

            throw new IllegalArgumentException("Bad object encountered: " + v5.nextElement().getClass());
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg5.size());
    }

    public Admissions(GeneralName arg1, NamingAuthority arg2, ProfessionInfo[] arg3) {
        super();
        this.admissionAuthority = arg1;
        this.namingAuthority = arg2;
        this.professionInfos = new DERSequence(((ASN1Encodable[])arg3));
    }

    public GeneralName getAdmissionAuthority() {
        return this.admissionAuthority;
    }

    public static Admissions getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof Admissions)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new Admissions(((ASN1Sequence)arg3));
            }
            else {
                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public NamingAuthority getNamingAuthority() {
        return this.namingAuthority;
    }

    public ProfessionInfo[] getProfessionInfos() {
        ProfessionInfo[] v0 = new ProfessionInfo[this.professionInfos.size()];
        Enumeration v4 = this.professionInfos.getObjects();
        int v1;
        for(v1 = 0; v4.hasMoreElements(); ++v1) {
            v0[v1] = ProfessionInfo.getInstance(v4.nextElement());
        }

        return v0;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        if(this.admissionAuthority != null) {
            v0.add(new DERTaggedObject(true, 0, this.admissionAuthority));
        }

        if(this.namingAuthority != null) {
            v0.add(new DERTaggedObject(true, 1, this.namingAuthority));
        }

        v0.add(this.professionInfos);
        return new DERSequence(v0);
    }
}

