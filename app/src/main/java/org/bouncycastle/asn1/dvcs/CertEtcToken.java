package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.ess.ESSCertID;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.ocsp.CertStatus;
import org.bouncycastle.asn1.ocsp.OCSPResponse;
import org.bouncycastle.asn1.smime.SMIMECapabilities;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;

public class CertEtcToken extends ASN1Object implements ASN1Choice {
    public static final int TAG_ASSERTION = 3;
    public static final int TAG_CAPABILITIES = 8;
    public static final int TAG_CERTIFICATE = 0;
    public static final int TAG_CRL = 4;
    public static final int TAG_ESSCERTID = 1;
    public static final int TAG_OCSPCERTID = 6;
    public static final int TAG_OCSPCERTSTATUS = 5;
    public static final int TAG_OCSPRESPONSE = 7;
    public static final int TAG_PKISTATUS = 2;
    private static final boolean[] explicit;
    private Extension extension;
    private int tagNo;
    private ASN1Encodable value;

    static {
        CertEtcToken.explicit = new boolean[]{false, true, false, true, false, true, false, false, true};
    }

    public CertEtcToken(int arg1, ASN1Encodable arg2) {
        super();
        this.tagNo = arg1;
        this.value = arg2;
    }

    private CertEtcToken(ASN1TaggedObject arg3) {
        super();
        int v0 = arg3.getTagNo();
        this.tagNo = v0;
        switch(v0) {
            case 0: {
                goto label_35;
            }
            case 1: {
                goto label_32;
            }
            case 2: {
                goto label_30;
            }
            case 3: {
                goto label_27;
            }
            case 4: {
                goto label_25;
            }
            case 5: {
                goto label_22;
            }
            case 6: {
                goto label_20;
            }
            case 7: {
                goto label_18;
            }
            case 8: {
                goto label_14;
            }
        }

        throw new IllegalArgumentException("Unknown tag: " + this.tagNo);
    label_18:
        OCSPResponse v3 = OCSPResponse.getInstance(arg3, false);
        goto label_16;
    label_35:
        Certificate v3_1 = Certificate.getInstance(arg3, false);
        goto label_16;
    label_20:
        CertID v3_2 = CertID.getInstance(arg3, false);
        goto label_16;
    label_22:
        CertStatus v3_3 = CertStatus.getInstance(arg3.getExplicitBaseObject());
        goto label_16;
    label_25:
        CertificateList v3_4 = CertificateList.getInstance(arg3, false);
        goto label_16;
    label_27:
        ContentInfo v3_5 = ContentInfo.getInstance(arg3.getExplicitBaseObject());
        goto label_16;
    label_30:
        PKIStatusInfo v3_6 = PKIStatusInfo.getInstance(arg3, false);
        goto label_16;
    label_14:
        SMIMECapabilities v3_7 = SMIMECapabilities.getInstance(arg3.getExplicitBaseObject());
        goto label_16;
    label_32:
        ESSCertID v3_8 = ESSCertID.getInstance(arg3.getExplicitBaseObject());
    label_16:
        this.value = ((ASN1Encodable)v3_8);
    }

    public CertEtcToken(Extension arg2) {
        super();
        this.tagNo = -1;
        this.extension = arg2;
    }

    public static CertEtcToken[] arrayFromSequence(ASN1Sequence arg4) {
        int v0 = arg4.size();
        CertEtcToken[] v1 = new CertEtcToken[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = CertEtcToken.getInstance(arg4.getObjectAt(v2));
        }

        return v1;
    }

    public Extension getExtension() {
        return this.extension;
    }

    public static CertEtcToken getInstance(Object arg2) {
        if((arg2 instanceof CertEtcToken)) {
            return arg2;
        }

        if((arg2 instanceof ASN1TaggedObject)) {
            return new CertEtcToken(ASN1TaggedObject.getInstance(arg2, 0x80));
        }

        if(arg2 != null) {
            return new CertEtcToken(Extension.getInstance(arg2));
        }

        return null;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        Extension v0 = this.extension;
        if(v0 == null) {
            return new DERTaggedObject(CertEtcToken.explicit[this.tagNo], this.tagNo, this.value);
        }

        return v0.toASN1Primitive();
    }

    public String toString() {
        return "CertEtcToken {\n" + this.value + "}\n";
    }
}

