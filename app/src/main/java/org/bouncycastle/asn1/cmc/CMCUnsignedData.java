package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CMCUnsignedData extends ASN1Object {
    private final BodyPartPath bodyPartPath;
    private final ASN1Encodable content;
    private final ASN1ObjectIdentifier identifier;

    private CMCUnsignedData(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.bodyPartPath = BodyPartPath.getInstance(arg3.getObjectAt(0));
            this.identifier = ASN1ObjectIdentifier.getInstance(arg3.getObjectAt(1));
            this.content = arg3.getObjectAt(2);
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public CMCUnsignedData(BodyPartPath arg1, ASN1ObjectIdentifier arg2, ASN1Encodable arg3) {
        super();
        this.bodyPartPath = arg1;
        this.identifier = arg2;
        this.content = arg3;
    }

    public BodyPartPath getBodyPartPath() {
        return this.bodyPartPath;
    }

    public ASN1Encodable getContent() {
        return this.content;
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.identifier;
    }

    public static CMCUnsignedData getInstance(Object arg1) {
        if((arg1 instanceof CMCUnsignedData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CMCUnsignedData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.bodyPartPath);
        v0.add(this.identifier);
        v0.add(this.content);
        return new DERSequence(v0);
    }
}

