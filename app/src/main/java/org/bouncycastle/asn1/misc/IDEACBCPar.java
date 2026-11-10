package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class IDEACBCPar extends ASN1Object {
    ASN1OctetString iv;

    private IDEACBCPar(ASN1Sequence arg3) {
        ASN1OctetString v3_1;
        super();
        if(arg3.size() == 1) {
            ASN1Encodable v3 = arg3.getObjectAt(0);
        }
        else {
            v3_1 = null;
        }

        this.iv = v3_1;
    }

    public IDEACBCPar(byte[] arg2) {
        super();
        this.iv = new DEROctetString(Arrays.clone(arg2));
    }

    public byte[] getIV() {
        ASN1OctetString v0 = this.iv;
        if(v0 != null) {
            return Arrays.clone(v0.getOctets());
        }

        return null;
    }

    public static IDEACBCPar getInstance(Object arg1) {
        if((arg1 instanceof IDEACBCPar)) {
            return arg1;
        }

        if(arg1 != null) {
            return new IDEACBCPar(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(1);
        ASN1OctetString v2 = this.iv;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

