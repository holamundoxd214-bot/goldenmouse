package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CMSORIforKEMOtherInfo extends ASN1Object {
    private final int kekLength;
    private final byte[] ukm;
    private final AlgorithmIdentifier wrap;

    public CMSORIforKEMOtherInfo(AlgorithmIdentifier arg2, int arg3) {
        this(arg2, arg3, null);
    }

    public CMSORIforKEMOtherInfo(AlgorithmIdentifier arg2, int arg3, byte[] arg4) {
        super();
        if(arg3 <= 0xFFFF) {
            this.wrap = arg2;
            this.kekLength = arg3;
            this.ukm = arg4;
            return;
        }

        throw new IllegalArgumentException("kekLength must be <= 65535");
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector();
        v0.add(this.wrap);
        v0.add(new ASN1Integer(((long)this.kekLength)));
        if(this.ukm != null) {
            v0.add(new DERTaggedObject(true, 0, new DEROctetString(this.ukm)));
        }

        return new DERSequence(v0);
    }
}

