package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Attribute;
import org.bouncycastle.asn1.x509.AttributeCertificate;

public class SignerAttribute extends ASN1Object {
    private Object[] values;

    private SignerAttribute(ASN1Sequence arg8) {
        ASN1TaggedObject v2;
        super();
        this.values = new Object[arg8.size()];
        Enumeration v8 = arg8.getObjects();
        int v1;
        for(v1 = 0; true; ++v1) {
            if(!v8.hasMoreElements()) {
                return;
            }

            v2 = ASN1TaggedObject.getInstance(v8.nextElement());
            if(v2.getTagNo() == 0) {
                ASN1Sequence v2_1 = ASN1Sequence.getInstance(v2, true);
                int v3 = v2_1.size();
                Attribute[] v4 = new Attribute[v3];
                int v5;
                for(v5 = 0; v5 != v3; ++v5) {
                    v4[v5] = Attribute.getInstance(v2_1.getObjectAt(v5));
                }

                this.values[v1] = v4;
            }
            else if(v2.getTagNo() == 1) {
                this.values[v1] = AttributeCertificate.getInstance(ASN1Sequence.getInstance(v2, true));
            }
            else {
                break;
            }
        }

        throw new IllegalArgumentException("illegal tag: " + v2.getTagNo());
    }

    public SignerAttribute(AttributeCertificate arg2) {
        super();
        Object[] v0 = new Object[1];
        this.values = v0;
        v0[0] = arg2;
    }

    public SignerAttribute(Attribute[] arg2) {
        super();
        Object[] v0 = new Object[1];
        this.values = v0;
        v0[0] = arg2;
    }

    public static SignerAttribute getInstance(Object arg1) {
        if((arg1 instanceof SignerAttribute)) {
            return arg1;
        }

        if(arg1 != null) {
            return new SignerAttribute(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public Object[] getValues() {
        Object[] v3 = this.values;
        int v0 = v3.length;
        Object[] v1 = new Object[v0];
        System.arraycopy(v3, 0, v1, 0, v0);
        return v1;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(this.values.length);
        int v2;
        for(v2 = 0; true; ++v2) {
            Object[] v3 = this.values;
            if(v2 == v3.length) {
                break;
            }

            DERTaggedObject v3_1 = (v3[v2] instanceof Attribute[]) ? new DERTaggedObject(0, new DERSequence(this.values[v2])) : new DERTaggedObject(1, this.values[v2]);
            v0.add(((ASN1Encodable)v3_1));
        }

        return new DERSequence(v0);
    }
}

