package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class LraPopWitness extends ASN1Object {
    private final ASN1Sequence bodyIds;
    private final BodyPartID pkiDataBodyid;

    private LraPopWitness(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.pkiDataBodyid = BodyPartID.getInstance(arg3.getObjectAt(0));
            this.bodyIds = ASN1Sequence.getInstance(arg3.getObjectAt(1));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public LraPopWitness(BodyPartID arg1, ASN1Sequence arg2) {
        super();
        this.pkiDataBodyid = arg1;
        this.bodyIds = arg2;
    }

    public BodyPartID[] getBodyIds() {
        BodyPartID[] v0 = new BodyPartID[this.bodyIds.size()];
        int v1;
        for(v1 = 0; v1 != this.bodyIds.size(); ++v1) {
            v0[v1] = BodyPartID.getInstance(this.bodyIds.getObjectAt(v1));
        }

        return v0;
    }

    public static LraPopWitness getInstance(Object arg1) {
        if((arg1 instanceof LraPopWitness)) {
            return arg1;
        }

        if(arg1 != null) {
            return new LraPopWitness(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public BodyPartID getPkiDataBodyid() {
        return this.pkiDataBodyid;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.pkiDataBodyid, this.bodyIds);
    }
}

