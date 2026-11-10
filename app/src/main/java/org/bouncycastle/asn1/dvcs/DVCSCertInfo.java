package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class DVCSCertInfo extends ASN1Object {
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

    private DVCSCertInfo(ASN1Sequence arg8) {
        int v4;
        super();
        this.version = 1;
        ASN1Encodable v2 = arg8.getObjectAt(0);
        int v3 = 2;
        try {
            this.version = ASN1Integer.getInstance(v2).intValueExact();
        }
        catch(IllegalArgumentException ) {
            v4 = 1;
            goto label_13;
        }

        try {
            v2 = arg8.getObjectAt(1);
            goto label_10;
        }
        catch(IllegalArgumentException ) {
        label_10:
            v4 = v3;
        }

    label_13:
        this.dvReqInfo = DVCSRequestInformation.getInstance(v2);
        this.messageImprint = DigestInfo.getInstance(arg8.getObjectAt(v4));
        int v5 = v4 + 2;
        this.serialNumber = ASN1Integer.getInstance(arg8.getObjectAt(v4 + 1));
        int v2_1 = 3;
        v4 += v2_1;
        this.responseTime = DVCSTime.getInstance(arg8.getObjectAt(v5));
        while(v4 < arg8.size()) {
            v5 = v4 + 1;
            ASN1Encodable v4_1 = arg8.getObjectAt(v4);
            if((v4_1 instanceof ASN1TaggedObject)) {
                ASN1TaggedObject v4_2 = ASN1TaggedObject.getInstance(v4_1);
                int v6 = v4_2.getTagNo();
                if(v6 == 0) {
                    this.dvStatus = PKIStatusInfo.getInstance(v4_2, false);
                }
                else if(v6 == 1) {
                    this.policy = PolicyInformation.getInstance(ASN1Sequence.getInstance(v4_2, false));
                }
                else if(v6 == v3) {
                    this.reqSignature = ASN1Set.getInstance(v4_2, false);
                }
                else if(v6 == v2_1) {
                    this.certs = ASN1Sequence.getInstance(v4_2, false);
                }
                else {
                    throw new IllegalArgumentException("Unknown tag encountered: " + v6);
                }
            }
            else {
                try {
                    this.extensions = Extensions.getInstance(v4_1);
                    goto label_63;
                }
                catch(IllegalArgumentException ) {
                label_63:
                    v4 = v5;
                    continue;
                }
            }

            goto label_63;
        }
    }

    public DVCSCertInfo(DVCSRequestInformation arg2, DigestInfo arg3, ASN1Integer arg4, DVCSTime arg5) {
        super();
        this.version = 1;
        this.dvReqInfo = arg2;
        this.messageImprint = arg3;
        this.serialNumber = arg4;
        this.responseTime = arg5;
    }

    public TargetEtcChain[] getCerts() {
        ASN1Sequence v0 = this.certs;
        if(v0 != null) {
            return TargetEtcChain.arrayFromSequence(v0);
        }

        return null;
    }

    public DVCSRequestInformation getDvReqInfo() {
        return this.dvReqInfo;
    }

    public PKIStatusInfo getDvStatus() {
        return this.dvStatus;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public static DVCSCertInfo getInstance(Object arg1) {
        if((arg1 instanceof DVCSCertInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new DVCSCertInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static DVCSCertInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return DVCSCertInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public DigestInfo getMessageImprint() {
        return this.messageImprint;
    }

    public PolicyInformation getPolicy() {
        return this.policy;
    }

    public ASN1Set getReqSignature() {
        return this.reqSignature;
    }

    public DVCSTime getResponseTime() {
        return this.responseTime;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public int getVersion() {
        return this.version;
    }

    private void setDvReqInfo(DVCSRequestInformation arg1) {
        this.dvReqInfo = arg1;
    }

    private void setMessageImprint(DigestInfo arg1) {
        this.messageImprint = arg1;
    }

    private void setVersion(int arg1) {
        this.version = arg1;
    }

    public ASN1Primitive toASN1Primitive() {
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

        return new DERSequence(v0);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("DVCSCertInfo {\n");
        String v3 = "\n";
        if(this.version != 1) {
            v0.append("version: " + this.version + v3);
        }

        v0.append("dvReqInfo: " + this.dvReqInfo + v3);
        v0.append("messageImprint: " + this.messageImprint + v3);
        v0.append("serialNumber: " + this.serialNumber + v3);
        v0.append("responseTime: " + this.responseTime + v3);
        if(this.dvStatus != null) {
            v0.append("dvStatus: " + this.dvStatus + v3);
        }

        if(this.policy != null) {
            v0.append("policy: " + this.policy + v3);
        }

        if(this.reqSignature != null) {
            v0.append("reqSignature: " + this.reqSignature + v3);
        }

        if(this.certs != null) {
            v0.append("certs: " + this.certs + v3);
        }

        if(this.extensions != null) {
            v0.append("extensions: " + this.extensions + v3);
        }

        v0.append("}\n");
        return v0.toString();
    }
}

