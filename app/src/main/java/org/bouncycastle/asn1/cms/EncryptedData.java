package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;

public class EncryptedData extends ASN1Object {
    private EncryptedContentInfo encryptedContentInfo;
    private ASN1Set unprotectedAttrs;
    private ASN1Integer version;

    private EncryptedData(ASN1Sequence arg4) {
        super();
        this.version = ASN1Integer.getInstance(arg4.getObjectAt(0));
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(arg4.getObjectAt(1));
        if(arg4.size() == 3) {
            this.unprotectedAttrs = ASN1Set.getInstance(arg4.getObjectAt(2), false);
        }
    }

    public EncryptedData(EncryptedContentInfo arg2) {
        this(arg2, null);
    }

    public EncryptedData(EncryptedContentInfo arg4, ASN1Set arg5) {
        super();
        long v1 = arg5 == null ? 0 : 2;
        this.version = new ASN1Integer(v1);
        this.encryptedContentInfo = arg4;
        this.unprotectedAttrs = arg5;
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.encryptedContentInfo;
    }

    public static EncryptedData getInstance(Object arg1) {
        if((arg1 instanceof EncryptedData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new EncryptedData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Set getUnprotectedAttrs() {
        return this.unprotectedAttrs;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.version);
        v0.add(this.encryptedContentInfo);
        if(this.unprotectedAttrs != null) {
            v0.add(new BERTaggedObject(false, 1, this.unprotectedAttrs));
        }

        return new BERSequence(v0);
    }
}

