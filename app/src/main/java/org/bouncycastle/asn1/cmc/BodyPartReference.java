package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class BodyPartReference extends ASN1Object implements ASN1Choice {
    private final BodyPartID bodyPartID;
    private final BodyPartPath bodyPartPath;

    public BodyPartReference(BodyPartID arg1) {
        super();
        this.bodyPartID = arg1;
        this.bodyPartPath = null;
    }

    public BodyPartReference(BodyPartPath arg2) {
        super();
        this.bodyPartID = null;
        this.bodyPartPath = arg2;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public BodyPartPath getBodyPartPath() {
        return this.bodyPartPath;
    }

    public static BodyPartReference getInstance(Object arg3) {
        if((arg3 instanceof BodyPartReference)) {
            return arg3;
        }

        if(arg3 != null) {
            if((arg3 instanceof ASN1Encodable)) {
                ASN1Primitive v0 = arg3.toASN1Primitive();
                if((v0 instanceof ASN1Integer)) {
                    return new BodyPartReference(BodyPartID.getInstance(v0));
                }
                else if((v0 instanceof ASN1Sequence)) {
                    return new BodyPartReference(BodyPartPath.getInstance(v0));
                }
            }

            if((arg3 instanceof byte[])) {
                try {
                    return BodyPartReference.getInstance(ASN1Primitive.fromByteArray(((byte[])arg3)));
                }
                catch(IOException ) {
                    throw new IllegalArgumentException("unknown encoding in getInstance()");
                }
            }

            throw new IllegalArgumentException("unknown object in getInstance(): " + arg3.getClass().getName());
        }

        return null;
    }

    public boolean isBodyPartID() {
        if(this.bodyPartID != null) {
            return 1;
        }

        return 0;
    }

    public ASN1Primitive toASN1Primitive() {
        BodyPartID v0 = this.bodyPartID;
        if(v0 != null) {
            return v0.toASN1Primitive();
        }

        return this.bodyPartPath.toASN1Primitive();
    }
}

