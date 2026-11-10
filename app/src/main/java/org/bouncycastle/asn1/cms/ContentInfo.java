package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.DLTaggedObject;

public class ContentInfo extends ASN1Object implements CMSObjectIdentifiers {
    private final ASN1Encodable content;
    private final ASN1ObjectIdentifier contentType;
    private final boolean isDefiniteLength;

    public ContentInfo(ASN1ObjectIdentifier arg2, ASN1Encodable arg3) {
        super();
        if(arg2 != null) {
            this.contentType = arg2;
            this.content = arg3;
            boolean v2 = true;
            if(arg3 != null) {
                ASN1Primitive v3 = arg3.toASN1Primitive();
                if(!(v3 instanceof DEROctetString) && !(v3 instanceof DLSequence)) {
                    if((v3 instanceof DERSequence)) {
                    }
                    else {
                        v2 = false;
                    }
                }

                this.isDefiniteLength = v2;
                return;
            }

            this.isDefiniteLength = true;
            return;
        }

        throw new NullPointerException("\'contentType\' cannot be null");
    }

    private ContentInfo(ASN1Sequence arg4) {
        ASN1Object v0_1;
        super();
        if(arg4.size() >= 1 && arg4.size() <= 2) {
            this.contentType = arg4.getObjectAt(0);
            if(arg4.size() > 1) {
                ASN1TaggedObject v0 = ASN1TaggedObject.getInstance(arg4.getObjectAt(1), 0x80);
                if((v0.isExplicit()) && v0.getTagNo() == 0) {
                    v0_1 = v0.getExplicitBaseObject();
                    goto label_26;
                }

                throw new IllegalArgumentException("Bad tag for \'content\'");
            }
            else {
                ASN1Encodable v0_2 = null;
            }

        label_26:
            this.content = ((ASN1Encodable)v0_1);
            this.isDefiniteLength = arg4 instanceof BERSequence ^ 1;
            return;
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg4.size());
    }

    public ASN1Encodable getContent() {
        return this.content;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    public static ContentInfo getInstance(Object arg1) {
        if((arg1 instanceof ContentInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ContentInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static ContentInfo getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return new ContentInfo(ASN1Sequence.getInstance(arg1, arg2));
    }

    public boolean isDefiniteLength() {
        return this.isDefiniteLength;
    }

    public ASN1Primitive toASN1Primitive() {
        DLTaggedObject v1;
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.contentType);
        if(this.content != null) {
            if(this.isDefiniteLength) {
                v1 = new DLTaggedObject(0, this.content);
            }
            else {
                BERTaggedObject v1_1 = new BERTaggedObject(0, this.content);
            }

            v0.add(((ASN1Encodable)v1));
        }

        if(this.isDefiniteLength) {
            return new DLSequence(v0);
        }

        return new BERSequence(v0);
    }
}

