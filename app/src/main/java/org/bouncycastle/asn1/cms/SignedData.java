package org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DLSequence;

public class SignedData extends ASN1Object {
    private static final ASN1Integer VERSION_1;
    private static final ASN1Integer VERSION_3;
    private static final ASN1Integer VERSION_4;
    private static final ASN1Integer VERSION_5;
    private ASN1Set certificates;
    private boolean certsBer;
    private final ContentInfo contentInfo;
    private ASN1Set crls;
    private boolean crlsBer;
    private final ASN1Set digestAlgorithms;
    private final boolean digsBer;
    private final ASN1Set signerInfos;
    private final boolean sigsBer;
    private final ASN1Integer version;

    static {
        SignedData.VERSION_1 = new ASN1Integer(1);
        SignedData.VERSION_3 = new ASN1Integer(3);
        SignedData.VERSION_4 = new ASN1Integer(4);
        SignedData.VERSION_5 = new ASN1Integer(5);
    }

    private SignedData(ASN1Sequence arg6) {
        super();
        Enumeration v6 = arg6.getObjects();
        this.version = ASN1Integer.getInstance(v6.nextElement());
        this.digestAlgorithms = v6.nextElement();
        this.contentInfo = ContentInfo.getInstance(v6.nextElement());
        Object v0;
        for(v0 = null; true; v0 = v1) {
        label_11:
            if(!v6.hasMoreElements()) {
                goto label_48;
            }

            Object v1 = v6.nextElement();
            if((v1 instanceof ASN1TaggedObject)) {
                int v2 = ((ASN1TaggedObject)v1).getTagNo();
                if(v2 != 0) {
                    if(v2 == 1) {
                        this.crlsBer = v1 instanceof BERTaggedObject;
                        this.crls = ASN1Set.getInstance(((ASN1TaggedObject)v1), false);
                        goto label_11;
                    }

                    throw new IllegalArgumentException("unknown tag value " + ((ASN1TaggedObject)v1).getTagNo());
                }

                this.certsBer = v1 instanceof BERTaggedObject;
                this.certificates = ASN1Set.getInstance(((ASN1TaggedObject)v1), false);
                goto label_11;
            }

            if(!(v1 instanceof ASN1Set)) {
                break;
            }
        }

        throw new IllegalArgumentException("SET expected, not encountered");
    label_48:
        if(v0 != null) {
            this.signerInfos = ((ASN1Set)v0);
            this.digsBer = this.digestAlgorithms instanceof BERSet;
            this.sigsBer = v0 instanceof BERSet;
            return;
        }

        throw new IllegalArgumentException("signerInfos not set");
    }

    public SignedData(ASN1Set arg2, ContentInfo arg3, ASN1Set arg4, ASN1Set arg5, ASN1Set arg6) {
        super();
        this.version = this.calculateVersion(arg3.getContentType(), arg4, arg5, arg6);
        this.digestAlgorithms = arg2;
        this.contentInfo = arg3;
        this.certificates = arg4;
        this.crls = arg5;
        this.signerInfos = arg6;
        this.digsBer = arg2 instanceof BERSet;
        this.crlsBer = arg5 instanceof BERSet;
        this.certsBer = arg4 instanceof BERSet;
        this.sigsBer = arg6 instanceof BERSet;
    }

    private ASN1Integer calculateVersion(ASN1ObjectIdentifier arg9, ASN1Set arg10, ASN1Set arg11, ASN1Set arg12) {
        int v4;
        int v3;
        int v2;
        Enumeration v10;
        int v1 = 0;
        if(arg10 != null) {
            v10 = arg10.getObjects();
            v2 = 0;
            v3 = 0;
            v4 = 0;
            while(v10.hasMoreElements()) {
                Object v5 = v10.nextElement();
                if(!(v5 instanceof ASN1TaggedObject)) {
                    continue;
                }

                ASN1TaggedObject v5_1 = ASN1TaggedObject.getInstance(v5);
                if(v5_1.getTagNo() == 1) {
                    v3 = 1;
                }
                else if(v5_1.getTagNo() == 2) {
                    v4 = 1;
                }
                else {
                    if(v5_1.getTagNo() != 3) {
                        continue;
                    }

                    v2 = 1;
                }
            }
        }
        else {
            v2 = 0;
            v3 = 0;
            v4 = 0;
        }

        if(v2 != 0) {
            return new ASN1Integer(5);
        }

        if(arg11 != null) {
            v10 = arg11.getObjects();
            while(v10.hasMoreElements()) {
                if(!(v10.nextElement() instanceof ASN1TaggedObject)) {
                    continue;
                }

                v1 = 1;
            }
        }

        if(v1 != 0) {
            return SignedData.VERSION_5;
        }

        if(v4 != 0) {
            return SignedData.VERSION_4;
        }

        if(v3 != 0) {
            return SignedData.VERSION_3;
        }

        if(this.checkForVersion3(arg12)) {
            return SignedData.VERSION_3;
        }

        if(!CMSObjectIdentifiers.data.equals(((ASN1Primitive)arg9))) {
            return SignedData.VERSION_3;
        }

        return SignedData.VERSION_1;
    }

    private boolean checkForVersion3(ASN1Set arg2) {
        Enumeration v1 = arg2.getObjects();
        do {
            if(!v1.hasMoreElements()) {
                return 0;
            }
        }
        while(!SignerInfo.getInstance(v1.nextElement()).getVersion().hasValue(3));

        return 1;
    }

    public ASN1Set getCRLs() {
        return this.crls;
    }

    public ASN1Set getCertificates() {
        return this.certificates;
    }

    public ASN1Set getDigestAlgorithms() {
        return this.digestAlgorithms;
    }

    public ContentInfo getEncapContentInfo() {
        return this.contentInfo;
    }

    public static SignedData getInstance(Object arg1) {
        if((arg1 instanceof SignedData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new SignedData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Set getSignerInfos() {
        return this.signerInfos;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        DERTaggedObject v1_1;
        BERTaggedObject v1;
        ASN1EncodableVector v0 = new ASN1EncodableVector(6);
        v0.add(this.version);
        v0.add(this.digestAlgorithms);
        v0.add(this.contentInfo);
        if(this.certificates != null) {
            if(this.certsBer) {
                v1 = new BERTaggedObject(false, 0, this.certificates);
            }
            else {
                v1_1 = new DERTaggedObject(false, 0, this.certificates);
            }

            v0.add(((ASN1Encodable)v1));
        }

        if(this.crls != null) {
            if(this.crlsBer) {
                v1 = new BERTaggedObject(false, 1, this.crls);
            }
            else {
                v1_1 = new DERTaggedObject(false, 1, this.crls);
            }

            v0.add(((ASN1Encodable)v1));
        }

        v0.add(this.signerInfos);
        if((this.contentInfo.isDefiniteLength()) && !this.digsBer && !this.sigsBer && !this.crlsBer) {
            if(this.certsBer) {
            }
            else {
                return new DLSequence(v0);
            }
        }

        return new BERSequence(v0);
    }
}

