package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ControlsProcessed extends ASN1Object {
    private final ASN1Sequence bodyPartReferences;

    private ControlsProcessed(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 1) {
            this.bodyPartReferences = ASN1Sequence.getInstance(arg3.getObjectAt(0));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public ControlsProcessed(BodyPartReference arg2) {
        super();
        this.bodyPartReferences = new DERSequence(((ASN1Encodable)arg2));
    }

    public ControlsProcessed(BodyPartReference[] arg2) {
        super();
        this.bodyPartReferences = new DERSequence(((ASN1Encodable[])arg2));
    }

    public BodyPartReference[] getBodyList() {
        BodyPartReference[] v0 = new BodyPartReference[this.bodyPartReferences.size()];
        int v1;
        for(v1 = 0; v1 != this.bodyPartReferences.size(); ++v1) {
            v0[v1] = BodyPartReference.getInstance(this.bodyPartReferences.getObjectAt(v1));
        }

        return v0;
    }

    public static ControlsProcessed getInstance(Object arg1) {
        if((arg1 instanceof ControlsProcessed)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ControlsProcessed(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.bodyPartReferences);
    }
}

