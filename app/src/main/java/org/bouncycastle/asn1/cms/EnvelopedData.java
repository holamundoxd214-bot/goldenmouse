package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class EnvelopedData extends ASN1Object {
    private EncryptedContentInfo encryptedContentInfo;
    private OriginatorInfo originatorInfo;
    private ASN1Set recipientInfos;
    private ASN1Set unprotectedAttrs;
    private ASN1Integer version;

    private EnvelopedData(ASN1Sequence arg5) {
        super();
        this.version = arg5.getObjectAt(0);
        ASN1Encodable v1 = arg5.getObjectAt(1);
        int v3 = 2;
        if((v1 instanceof ASN1TaggedObject)) {
            this.originatorInfo = OriginatorInfo.getInstance(((ASN1TaggedObject)v1), false);
            v1 = arg5.getObjectAt(v3);
            v3 = 3;
        }

        this.recipientInfos = ASN1Set.getInstance(v1);
        int v1_1 = v3 + 1;
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(arg5.getObjectAt(v3));
        if(arg5.size() > v1_1) {
            this.unprotectedAttrs = ASN1Set.getInstance(arg5.getObjectAt(v1_1), false);
        }
    }

    public EnvelopedData(OriginatorInfo arg4, ASN1Set arg5, EncryptedContentInfo arg6, ASN1Set arg7) {
        super();
        this.version = new ASN1Integer(((long)EnvelopedData.calculateVersion(arg4, arg5, arg7)));
        this.originatorInfo = arg4;
        this.recipientInfos = arg5;
        this.encryptedContentInfo = arg6;
        this.unprotectedAttrs = arg7;
    }

    public EnvelopedData(OriginatorInfo arg4, ASN1Set arg5, EncryptedContentInfo arg6, Attributes arg7) {
        super();
        this.version = new ASN1Integer(((long)EnvelopedData.calculateVersion(arg4, arg5, ASN1Set.getInstance(arg7))));
        this.originatorInfo = arg4;
        this.recipientInfos = arg5;
        this.encryptedContentInfo = arg6;
        this.unprotectedAttrs = ASN1Set.getInstance(arg7);
    }

    public static int calculateVersion(OriginatorInfo arg11, ASN1Set arg12, ASN1Set arg13) {
        int v6;
        int v5;
        int v0 = 2;
        int v1 = 3;
        if(arg11 != null) {
            ASN1Set v4 = arg11.getCRLs();
            v5 = 4;
            if(v4 != null) {
                v6 = v4.size();
                int v7;
                for(v7 = 0; v7 < v6; ++v7) {
                    ASN1Encodable v8 = v4.getObjectAt(v7);
                    if(((v8 instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)v8).hasContextTag(1))) {
                        return v5;
                    }
                }
            }

            v4 = arg11.getCertificates();
            if(v4 == null) {
                goto label_42;
            }

            v6 = v4.size();
            v7 = 0;
            int v8_1 = 0;
            while(v7 < v6) {
                ASN1Encodable v9 = v4.getObjectAt(v7);
                if((v9 instanceof ASN1TaggedObject)) {
                    if(((ASN1TaggedObject)v9).hasContextTag(v1)) {
                        return v5;
                    }
                    else {
                        if(v8_1 == 0) {
                            if(((ASN1TaggedObject)v9).hasContextTag(v0)) {
                            }
                            else {
                                v8_1 = 0;
                                goto label_38;
                            }
                        }

                        v8_1 = 1;
                    }
                }

            label_38:
                ++v7;
            }

            if(v8_1 == 0) {
                goto label_42;
            }

            return v1;
        }

    label_42:
        int v4_1 = arg12.size();
        v5 = 0;
        v6 = 1;
        while(v5 < v4_1) {
            RecipientInfo v7_1 = RecipientInfo.getInstance(arg12.getObjectAt(v5));
            if(v7_1.isPasswordOrOther()) {
                return v1;
            }

            v6 = v6 == 0 || !v7_1.isKeyTransV0() ? 0 : 1;
            ++v5;
        }

        if(arg11 == null && arg13 == null && v6 != 0) {
            return 0;
        }

        return v0;
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.encryptedContentInfo;
    }

    public static EnvelopedData getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return EnvelopedData.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static EnvelopedData getInstance(Object arg1) {
        if((arg1 instanceof EnvelopedData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new EnvelopedData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.originatorInfo;
    }

    public ASN1Set getRecipientInfos() {
        return this.recipientInfos;
    }

    public ASN1Set getUnprotectedAttrs() {
        return this.unprotectedAttrs;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(5);
        v0.add(this.version);
        if(this.originatorInfo != null) {
            v0.add(new DERTaggedObject(false, 0, this.originatorInfo));
        }

        v0.add(this.recipientInfos);
        v0.add(this.encryptedContentInfo);
        if(this.unprotectedAttrs != null) {
            v0.add(new DERTaggedObject(false, 1, this.unprotectedAttrs));
        }

        return new BERSequence(v0);
    }
}

