package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CertResponse extends ASN1Object {
    private final ASN1Integer certReqId;
    private CertifiedKeyPair certifiedKeyPair;
    private ASN1OctetString rspInfo;
    private final PKIStatusInfo status;

    public CertResponse(ASN1Integer arg2, PKIStatusInfo arg3) {
        this(arg2, arg3, null, null);
    }

    public CertResponse(ASN1Integer arg1, PKIStatusInfo arg2, CertifiedKeyPair arg3, ASN1OctetString arg4) {
        super();
        if(arg1 != null) {
            if(arg2 != null) {
                this.certReqId = arg1;
                this.status = arg2;
                this.certifiedKeyPair = arg3;
                this.rspInfo = arg4;
                return;
            }

            throw new IllegalArgumentException("\'status\' cannot be null");
        }

        throw new IllegalArgumentException("\'certReqId\' cannot be null");
    }

    private CertResponse(ASN1Sequence arg4) {
        super();
        this.certReqId = ASN1Integer.getInstance(arg4.getObjectAt(0));
        this.status = PKIStatusInfo.getInstance(arg4.getObjectAt(1));
        int v1 = 3;
        if(arg4.size() >= v1) {
            int v2 = 2;
            if(arg4.size() == v1) {
                ASN1Encodable v4 = arg4.getObjectAt(v2);
                if((v4 instanceof ASN1OctetString)) {
                    this.rspInfo = ASN1OctetString.getInstance(v4);
                    return;
                }
                else {
                    this.certifiedKeyPair = CertifiedKeyPair.getInstance(v4);
                    return;
                }
            }
            else {
                this.certifiedKeyPair = CertifiedKeyPair.getInstance(arg4.getObjectAt(v2));
                this.rspInfo = ASN1OctetString.getInstance(arg4.getObjectAt(v1));
            }
        }
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public CertifiedKeyPair getCertifiedKeyPair() {
        return this.certifiedKeyPair;
    }

    public static CertResponse getInstance(Object arg1) {
        if((arg1 instanceof CertResponse)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertResponse(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1OctetString getRspInfo() {
        return this.rspInfo;
    }

    public PKIStatusInfo getStatus() {
        return this.status;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.certReqId);
        v0.add(this.status);
        CertifiedKeyPair v1 = this.certifiedKeyPair;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        ASN1OctetString v2 = this.rspInfo;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

