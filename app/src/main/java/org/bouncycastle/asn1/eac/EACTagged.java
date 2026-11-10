package org.bouncycastle.asn1.eac;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;

class EACTagged {
    EACTagged() {
        super();
    }

    static ASN1TaggedObject create(int arg3, ASN1Sequence arg4) {
        return new DERTaggedObject(false, 0x40, arg3, ((ASN1Encodable)arg4));
    }

    static ASN1TaggedObject create(int arg3, byte[] arg4) {
        return new DERTaggedObject(false, 0x40, arg3, new DEROctetString(arg4));
    }

    static ASN1TaggedObject create(int arg3, PublicKeyDataObject arg4) {
        return new DERTaggedObject(false, 0x40, arg3, ((ASN1Encodable)arg4));
    }
}

