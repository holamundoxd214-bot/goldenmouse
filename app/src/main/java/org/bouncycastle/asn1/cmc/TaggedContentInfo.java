package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.ContentInfo;

public class TaggedContentInfo extends ASN1Object {
    private final BodyPartID bodyPartID;
    private final ContentInfo contentInfo;

    private TaggedContentInfo(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.bodyPartID = BodyPartID.getInstance(arg3.getObjectAt(0));
            this.contentInfo = ContentInfo.getInstance(arg3.getObjectAt(1));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public TaggedContentInfo(BodyPartID arg1, ContentInfo arg2) {
        super();
        this.bodyPartID = arg1;
        this.contentInfo = arg2;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public static TaggedContentInfo getInstance(Object arg1) {
        if((arg1 instanceof TaggedContentInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new TaggedContentInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static TaggedContentInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return TaggedContentInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.bodyPartID, this.contentInfo);
    }
}

