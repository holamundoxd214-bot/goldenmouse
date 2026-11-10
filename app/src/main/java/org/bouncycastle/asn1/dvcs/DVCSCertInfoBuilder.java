package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class DVCSCertInfoBuilder {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_CERTS = 3;
    private static final int TAG_DV_STATUS = 0;
    private static final int TAG_POLICY = 1;
    private static final int TAG_REQ_SIGNATURE = 2;
    private ASN1Sequence certs;
    private DVCSRequestInformation dvReqInfo;
    private PKIStatusInfo dvStatus;
    private Extensions extensions;
    private DigestInfo messageImprint;
    private PolicyInformation policy;
    private ASN1Set reqSignature;
    private DVCSTime responseTime;
    private ASN1Integer serialNumber;
    private int version;

    public DVCSCertInfoBuilder(DVCSRequestInformation arg2, DigestInfo arg3, ASN1Integer arg4, DVCSTime arg5) {
        super();
        this.version = 1;
        this.dvReqInfo = arg2;
        this.messageImprint = arg3;
        this.serialNumber = arg4;
        this.responseTime = arg5;
    }

    public DVCSCertInfo build() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(10);
        if(this.version != 1) {
            v0.add(new ASN1Integer(((long)this.version)));
        }

        v0.add(this.dvReqInfo);
        v0.add(this.messageImprint);
        v0.add(this.serialNumber);
        v0.add(this.responseTime);
        if(this.dvStatus != null) {
            v0.add(new DERTaggedObject(false, 0, this.dvStatus));
        }

        if(this.policy != null) {
            v0.add(new DERTaggedObject(false, 1, this.policy));
        }

        if(this.reqSignature != null) {
            v0.add(new DERTaggedObject(false, 2, this.reqSignature));
        }

        if(this.certs != null) {
            v0.add(new DERTaggedObject(false, 3, this.certs));
        }

        Extensions v5 = this.extensions;
        if(v5 != null) {
            v0.add(((ASN1Encodable)v5));
        }

        return DVCSCertInfo.getInstance(new DERSequence(v0));
    }

    public void setCerts(TargetEtcChain[] arg2) {
        this.certs = new DERSequence(((ASN1Encodable[])arg2));
    }

    public void setDvReqInfo(DVCSRequestInformation arg1) {
        this.dvReqInfo = arg1;
    }

    public void setDvStatus(PKIStatusInfo arg1) {
        this.dvStatus = arg1;
    }

    public void setExtensions(Extensions arg1) {
        this.extensions = arg1;
    }

    public void setMessageImprint(DigestInfo arg1) {
        this.messageImprint = arg1;
    }

    public void setPolicy(PolicyInformation arg1) {
        this.policy = arg1;
    }

    public void setReqSignature(ASN1Set arg1) {
        this.reqSignature = arg1;
    }

    public void setResponseTime(DVCSTime arg1) {
        this.responseTime = arg1;
    }

    public void setSerialNumber(ASN1Integer arg1) {
        this.serialNumber = arg1;
    }

    public void setVersion(int arg1) {
        this.version = arg1;
    }
}

