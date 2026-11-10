package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.Extensions;

public class RevAnnContent extends ASN1Object {
    private final ASN1GeneralizedTime badSinceDate;
    private final CertId certId;
    private Extensions crlDetails;
    private final PKIStatus status;
    private final ASN1GeneralizedTime willBeRevokedAt;

    private RevAnnContent(ASN1Sequence arg3) {
        super();
        this.status = PKIStatus.getInstance(arg3.getObjectAt(0));
        this.certId = CertId.getInstance(arg3.getObjectAt(1));
        this.willBeRevokedAt = ASN1GeneralizedTime.getInstance(arg3.getObjectAt(2));
        this.badSinceDate = ASN1GeneralizedTime.getInstance(arg3.getObjectAt(3));
        int v1 = 4;
        if(arg3.size() > v1) {
            this.crlDetails = Extensions.getInstance(arg3.getObjectAt(v1));
        }
    }

    public RevAnnContent(PKIStatus arg7, CertId arg8, ASN1GeneralizedTime arg9, ASN1GeneralizedTime arg10) {
        this(arg7, arg8, arg9, arg10, null);
    }

    public RevAnnContent(PKIStatus arg1, CertId arg2, ASN1GeneralizedTime arg3, ASN1GeneralizedTime arg4, Extensions arg5) {
        super();
        this.status = arg1;
        this.certId = arg2;
        this.willBeRevokedAt = arg3;
        this.badSinceDate = arg4;
        this.crlDetails = arg5;
    }

    public ASN1GeneralizedTime getBadSinceDate() {
        return this.badSinceDate;
    }

    public CertId getCertId() {
        return this.certId;
    }

    public Extensions getCrlDetails() {
        return this.crlDetails;
    }

    public static RevAnnContent getInstance(Object arg1) {
        if((arg1 instanceof RevAnnContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RevAnnContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public PKIStatus getStatus() {
        return this.status;
    }

    public ASN1GeneralizedTime getWillBeRevokedAt() {
        return this.willBeRevokedAt;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(5);
        v0.add(this.status);
        v0.add(this.certId);
        v0.add(this.willBeRevokedAt);
        v0.add(this.badSinceDate);
        Extensions v2 = this.crlDetails;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

