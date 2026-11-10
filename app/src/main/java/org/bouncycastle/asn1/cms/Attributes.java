package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DLSet;

public class Attributes extends ASN1Object {
    private ASN1Set attributes;

    public Attributes(ASN1EncodableVector arg2) {
        super();
        this.attributes = new DLSet(arg2);
    }

    private Attributes(ASN1Set arg1) {
        super();
        this.attributes = arg1;
    }

    public Attribute[] getAttributes() {
        int v0 = this.attributes.size();
        Attribute[] v1 = new Attribute[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = Attribute.getInstance(this.attributes.getObjectAt(v2));
        }

        return v1;
    }

    public static Attributes getInstance(Object arg1) {
        if((arg1 instanceof Attributes)) {
            return arg1;
        }

        if(arg1 != null) {
            return new Attributes(ASN1Set.getInstance(arg1));
        }

        return null;
    }

    public static Attributes getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return Attributes.getInstance(ASN1Set.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        return this.attributes;
    }
}

