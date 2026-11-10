package org.bouncycastle.asn1;

public class DERExternal extends ASN1External {
    public DERExternal(ASN1ObjectIdentifier arg1, ASN1Integer arg2, ASN1Primitive arg3, int arg4, ASN1Primitive arg5) {
        super(arg1, arg2, arg3, arg4, arg5);
    }

    @Deprecated public DERExternal(ASN1EncodableVector arg1) {
        this(DERFactory.createSequence(arg1));
    }

    public DERExternal(DERSequence arg1) {
        super(((ASN1Sequence)arg1));
    }

    public DERExternal(ASN1ObjectIdentifier arg1, ASN1Integer arg2, ASN1Primitive arg3, DERTaggedObject arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    ASN1Sequence buildSequence() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        if(this.directReference != null) {
            v0.add(this.directReference);
        }

        if(this.indirectReference != null) {
            v0.add(this.indirectReference);
        }

        if(this.dataValueDescriptor != null) {
            v0.add(this.dataValueDescriptor.toDERObject());
        }

        boolean v2 = this.encoding == 0 ? true : false;
        v0.add(new DERTaggedObject(v2, this.encoding, this.externalContent));
        return new DERSequence(v0);
    }

    ASN1Primitive toDERObject() {
        return this;
    }

    ASN1Primitive toDLObject() {
        return this;
    }
}

