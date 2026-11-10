package org.bouncycastle.asn1;

import java.io.IOException;

abstract class ASN1UniversalType extends ASN1Type {
    final ASN1Tag tag;

    ASN1UniversalType(Class arg1, int arg2) {
        super(arg1);
        this.tag = ASN1Tag.create(0, arg2);
    }

    final ASN1Primitive checkedCast(ASN1Primitive arg3) {
        if(this.javaClass.isInstance(arg3)) {
            return arg3;
        }

        throw new IllegalStateException("unexpected object: " + arg3.getClass().getName());
    }

    final ASN1Primitive fromByteArray(byte[] arg1) throws IOException {
        return this.checkedCast(ASN1Primitive.fromByteArray(arg1));
    }

    ASN1Primitive fromImplicitConstructed(ASN1Sequence arg1) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    final ASN1Primitive getContextTagged(ASN1TaggedObject arg1, boolean arg2) {
        return this.checkedCast(ASN1Util.checkContextTagClass(arg1).getBaseUniversal(arg2, this));
    }

    final ASN1Tag getTag() {
        return this.tag;
    }

    final ASN1Primitive getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return this.checkedCast(arg1.getBaseUniversal(arg2, this));
    }
}

