package org.bouncycastle.asn1.cms;

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

public class AuthEnvelopedData extends ASN1Object {
    private ASN1Set authAttrs;
    private EncryptedContentInfo authEncryptedContentInfo;
    private ASN1OctetString mac;
    private OriginatorInfo originatorInfo;
    private ASN1Set recipientInfos;
    private ASN1Set unauthAttrs;
    private ASN1Integer version;

    private AuthEnvelopedData(ASN1Sequence arg7) {
        super();
        ASN1Integer v1 = ASN1Integer.getInstance(arg7.getObjectAt(0).toASN1Primitive());
        this.version = v1;
        if(v1.hasValue(0)) {
            ASN1Primitive v1_1 = arg7.getObjectAt(1).toASN1Primitive();
            int v3 = 3;
            int v4 = 2;
            if((v1_1 instanceof ASN1TaggedObject)) {
                this.originatorInfo = OriginatorInfo.getInstance(((ASN1TaggedObject)v1_1), false);
                v1_1 = arg7.getObjectAt(v4).toASN1Primitive();
                v4 = v3;
            }

            ASN1Set v1_2 = ASN1Set.getInstance(v1_1);
            this.recipientInfos = v1_2;
            if(v1_2.size() != 0) {
                this.authEncryptedContentInfo = EncryptedContentInfo.getInstance(arg7.getObjectAt(v4).toASN1Primitive());
                int v2 = v4 + 2;
                v1_1 = arg7.getObjectAt(v4 + 1).toASN1Primitive();
                if((v1_1 instanceof ASN1TaggedObject)) {
                    this.authAttrs = ASN1Set.getInstance(((ASN1TaggedObject)v1_1), false);
                    v1_1 = arg7.getObjectAt(v2).toASN1Primitive();
                    v2 = v4 + v3;
                }
                else if(!this.authEncryptedContentInfo.getContentType().equals(CMSObjectIdentifiers.data)) {
                    ASN1Set v3_1 = this.authAttrs;
                    if(v3_1 != null && v3_1.size() != 0) {
                        goto label_55;
                    }

                    throw new IllegalArgumentException("authAttrs must be present with non-data content");
                }

            label_55:
                this.mac = ASN1OctetString.getInstance(v1_1);
                if(arg7.size() > v2) {
                    this.unauthAttrs = ASN1Set.getInstance(arg7.getObjectAt(v2).toASN1Primitive(), false);
                }

                return;
            }

            throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
        }

        throw new IllegalArgumentException("AuthEnvelopedData version number must be 0");
    }

    public AuthEnvelopedData(OriginatorInfo arg4, ASN1Set arg5, EncryptedContentInfo arg6, ASN1Set arg7, ASN1OctetString arg8, ASN1Set arg9) {
        super();
        this.version = new ASN1Integer(0);
        this.originatorInfo = arg4;
        this.recipientInfos = arg5;
        if(arg5.size() != 0) {
            this.authEncryptedContentInfo = arg6;
            this.authAttrs = arg7;
            if(!arg6.getContentType().equals(CMSObjectIdentifiers.data) && (arg7 == null || arg7.size() == 0)) {
                throw new IllegalArgumentException("authAttrs must be present with non-data content");
            }

            this.mac = arg8;
            this.unauthAttrs = arg9;
            return;
        }

        throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
    }

    public ASN1Set getAuthAttrs() {
        return this.authAttrs;
    }

    public EncryptedContentInfo getAuthEncryptedContentInfo() {
        return this.authEncryptedContentInfo;
    }

    public static AuthEnvelopedData getInstance(Object arg1) {
        if((arg1 instanceof AuthEnvelopedData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new AuthEnvelopedData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static AuthEnvelopedData getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return AuthEnvelopedData.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1OctetString getMac() {
        return this.mac;
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
        ASN1EncodableVector v0 = new ASN1EncodableVector(7);
        v0.add(this.version);
        if(this.originatorInfo != null) {
            v0.add(new DERTaggedObject(false, 0, this.originatorInfo));
        }

        v0.add(this.recipientInfos);
        v0.add(this.authEncryptedContentInfo);
        if(this.authAttrs != null) {
            v0.add(new DERTaggedObject(false, 1, this.authAttrs));
        }

        v0.add(this.mac);
        if(this.unauthAttrs != null) {
            v0.add(new DERTaggedObject(false, 2, this.unauthAttrs));
        }

        return new BERSequence(v0);
    }
}

