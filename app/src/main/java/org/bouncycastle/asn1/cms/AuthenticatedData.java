package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class AuthenticatedData extends ASN1Object {
    private ASN1Set authAttrs;
    private AlgorithmIdentifier digestAlgorithm;
    private ContentInfo encapsulatedContentInfo;
    private ASN1OctetString mac;
    private AlgorithmIdentifier macAlgorithm;
    private OriginatorInfo originatorInfo;
    private ASN1Set recipientInfos;
    private ASN1Set unauthAttrs;
    private ASN1Integer version;

    private AuthenticatedData(ASN1Sequence arg8) {
        int v2;
        super();
        this.version = arg8.getObjectAt(0);
        ASN1Encodable v1 = arg8.getObjectAt(1);
        int v3 = 3;
        int v4 = 2;
        if((v1 instanceof ASN1TaggedObject)) {
            this.originatorInfo = OriginatorInfo.getInstance(((ASN1TaggedObject)v1), false);
            v1 = arg8.getObjectAt(v4);
            v2 = v3;
        }
        else {
            v2 = v4;
        }

        this.recipientInfos = ASN1Set.getInstance(v1);
        this.macAlgorithm = AlgorithmIdentifier.getInstance(arg8.getObjectAt(v2));
        int v5 = v2 + 2;
        v1 = arg8.getObjectAt(v2 + 1);
        if((v1 instanceof ASN1TaggedObject)) {
            this.digestAlgorithm = AlgorithmIdentifier.getInstance(((ASN1TaggedObject)v1), false);
            v1 = arg8.getObjectAt(v5);
            v5 = v2 + v3;
        }

        this.encapsulatedContentInfo = ContentInfo.getInstance(v1);
        int v1_1 = v5 + 1;
        ASN1Encodable v2_1 = arg8.getObjectAt(v5);
        if((v2_1 instanceof ASN1TaggedObject)) {
            this.authAttrs = ASN1Set.getInstance(((ASN1TaggedObject)v2_1), false);
            v2_1 = arg8.getObjectAt(v1_1);
            v1_1 = v5 + v4;
        }

        this.mac = ASN1OctetString.getInstance(v2_1);
        if(arg8.size() > v1_1) {
            this.unauthAttrs = ASN1Set.getInstance(arg8.getObjectAt(v1_1), false);
        }
    }

    public AuthenticatedData(OriginatorInfo arg4, ASN1Set arg5, AlgorithmIdentifier arg6, AlgorithmIdentifier arg7, ContentInfo arg8, ASN1Set arg9, ASN1OctetString arg10, ASN1Set arg11) {
        super();
        if(arg7 == null && arg9 == null || arg7 != null && arg9 != null) {
            this.version = new ASN1Integer(((long)AuthenticatedData.calculateVersion(arg4)));
            this.originatorInfo = arg4;
            this.macAlgorithm = arg6;
            this.digestAlgorithm = arg7;
            this.recipientInfos = arg5;
            this.encapsulatedContentInfo = arg8;
            this.authAttrs = arg9;
            this.mac = arg10;
            this.unauthAttrs = arg11;
            return;
        }

        throw new IllegalArgumentException("digestAlgorithm and authAttrs must be set together");
    }

    public static int calculateVersion(OriginatorInfo arg8) {
        ASN1Encodable v6;
        int v4;
        if(arg8 != null) {
            ASN1Set v1 = arg8.getCRLs();
            int v2 = 3;
            if(v1 != null) {
                v4 = v1.size();
                int v5;
                for(v5 = 0; v5 < v4; ++v5) {
                    v6 = v1.getObjectAt(v5);
                    if(((v6 instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)v6).hasContextTag(1))) {
                        return v2;
                    }
                }
            }

            ASN1Set v8 = arg8.getCertificates();
            if(v8 == null) {
                return 0;
            }

            int v1_1 = v8.size();
            v4 = 0;
            v5 = 0;
            while(v4 < v1_1) {
                v6 = v8.getObjectAt(v4);
                if((v6 instanceof ASN1TaggedObject)) {
                    if(((ASN1TaggedObject)v6).hasContextTag(v2)) {
                        return v2;
                    }
                    else {
                        if(v5 == 0) {
                            if(((ASN1TaggedObject)v6).hasContextTag(2)) {
                            }
                            else {
                                v5 = 0;
                                goto label_37;
                            }
                        }

                        v5 = 1;
                    }
                }

            label_37:
                ++v4;
            }

            if(v5 == 0) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public ASN1Set getAuthAttrs() {
        return this.authAttrs;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public ContentInfo getEncapsulatedContentInfo() {
        return this.encapsulatedContentInfo;
    }

    public static AuthenticatedData getInstance(Object arg1) {
        if((arg1 instanceof AuthenticatedData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new AuthenticatedData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static AuthenticatedData getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return AuthenticatedData.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1OctetString getMac() {
        return this.mac;
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.originatorInfo;
    }

    public ASN1Set getRecipientInfos() {
        return this.recipientInfos;
    }

    public ASN1Set getUnauthAttrs() {
        return this.unauthAttrs;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(9);
        v0.add(this.version);
        if(this.originatorInfo != null) {
            v0.add(new DERTaggedObject(false, 0, this.originatorInfo));
        }

        v0.add(this.recipientInfos);
        v0.add(this.macAlgorithm);
        if(this.digestAlgorithm != null) {
            v0.add(new DERTaggedObject(false, 1, this.digestAlgorithm));
        }

        v0.add(this.encapsulatedContentInfo);
        if(this.authAttrs != null) {
            v0.add(new DERTaggedObject(false, 2, this.authAttrs));
        }

        v0.add(this.mac);
        if(this.unauthAttrs != null) {
            v0.add(new DERTaggedObject(false, 3, this.unauthAttrs));
        }

        return new BERSequence(v0);
    }
}

