package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

public class SingleResponse extends ASN1Object {
    private CertID certID;
    private CertStatus certStatus;
    private ASN1GeneralizedTime nextUpdate;
    private Extensions singleExtensions;
    private ASN1GeneralizedTime thisUpdate;

    private SingleResponse(ASN1Sequence arg5) {
        super();
        this.certID = CertID.getInstance(arg5.getObjectAt(0));
        this.certStatus = CertStatus.getInstance(arg5.getObjectAt(1));
        this.thisUpdate = ASN1GeneralizedTime.getInstance(arg5.getObjectAt(2));
        int v2 = 3;
        int v3 = 4;
        if(arg5.size() > v3) {
            this.nextUpdate = ASN1GeneralizedTime.getInstance(arg5.getObjectAt(v2), true);
            this.singleExtensions = Extensions.getInstance(arg5.getObjectAt(v3), true);
            return;
        }

        if(arg5.size() > v2) {
            ASN1Encodable v5 = arg5.getObjectAt(v2);
            if(((ASN1TaggedObject)v5).getTagNo() == 0) {
                this.nextUpdate = ASN1GeneralizedTime.getInstance(((ASN1TaggedObject)v5), true);
                return;
            }
            else {
                this.singleExtensions = Extensions.getInstance(((ASN1TaggedObject)v5), true);
            }
        }
    }

    public SingleResponse(CertID arg1, CertStatus arg2, ASN1GeneralizedTime arg3, ASN1GeneralizedTime arg4, Extensions arg5) {
        super();
        this.certID = arg1;
        this.certStatus = arg2;
        this.thisUpdate = arg3;
        this.nextUpdate = arg4;
        this.singleExtensions = arg5;
    }

    public SingleResponse(CertID arg1, CertStatus arg2, ASN1GeneralizedTime arg3, ASN1GeneralizedTime arg4, X509Extensions arg5) {
        this(arg1, arg2, arg3, arg4, Extensions.getInstance(arg5));
    }

    public CertID getCertID() {
        return this.certID;
    }

    public CertStatus getCertStatus() {
        return this.certStatus;
    }

    public static SingleResponse getInstance(Object arg1) {
        if((arg1 instanceof SingleResponse)) {
            return arg1;
        }

        if(arg1 != null) {
            return new SingleResponse(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static SingleResponse getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return SingleResponse.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1GeneralizedTime getNextUpdate() {
        return this.nextUpdate;
    }

    public Extensions getSingleExtensions() {
        return this.singleExtensions;
    }

    public ASN1GeneralizedTime getThisUpdate() {
        return this.thisUpdate;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(5);
        v0.add(this.certID);
        v0.add(this.certStatus);
        v0.add(this.thisUpdate);
        if(this.nextUpdate != null) {
            v0.add(new DERTaggedObject(true, 0, this.nextUpdate));
        }

        if(this.singleExtensions != null) {
            v0.add(new DERTaggedObject(true, 1, this.singleExtensions));
        }

        return new DERSequence(v0);
    }
}

